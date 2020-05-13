对于ORM框架而言，数据源的组织是一个非常重要的一部分，这直接影响到框架的性能问题。
本文将通过对MyBatis框架的数据源结构进行详尽的分析，并且深入解析MyBatis的连接池。

本文首先会讲述MyBatis的数据源的分类，然后会介绍数据源是如何加载和使用的。
紧接着将分类介绍UNPOOLED、POOLED和JNDI类型的数据源组织；期间我们会
重点讲解POOLED类型的数据源和其实现的连接池原理。



以下是本章的组织结构：

```
    一、MyBatis数据源DataSource分类
    二、数据源DataSource的创建过程
    三、 DataSource什么时候创建Connection对象
    四、不使用连接池的UnpooledDataSource
    五、为什么要使用连接池？
    六、使用了连接池的PooledDataSource
    七、Druid是如何接管Mybatis的连接池的

```


#### 1.MyBatis数据源DataSource分类
    MyBatis把数据源DataSource分类3类：
        1. UnPooledDataSource      不使用连接池的数据源
        2. PooledDataSource            使用连接池
        3. JNDIDataSource           使用JNDI实现的数据源
        
        其中三者均继承与DataSource接口
        
        
        
        
#### 2. 数据源DataSource的创建工程

    MyBatis数据源DataSource对象的创建是发生在Mybatis初始化的过程中
    
    在mybatis-config.xml配置文件中，使用<dataSource>元素来配置数据源
    ```
    <dataSource type="POOLED">
        <property name="driver" value="${jdbc.driverClassName}">
        <property name="url" value="${jdbc.url}">
        <property name="username" value="${jdbc.username}">
        <property name="password" value="${jdbc.password}">
    </dataSource>
    ```
          
        
    1. mybatis初始化时，解析此文件，根据<dataSource>的type属性来创建相应类型的数据源DataSource
    
        type="POOLED"       mybatis会创建PooledDataSource实例
        type="UNPOOLED"     mybatis会创建UnpooledDataSource实例
        type="JNDI"         mybatis会从JNDI服务器上查找DataSource实例，然后返回
        
        
    2. DataSource的对象创建是通过DataSouceFactory来创建的
    
    3.  MyBatis创建了DataSource实例后，会将其放到Configuration对象内的Environment对象中， 供以后使用。
    

    
    
#### 3.DataSource什么时候创建Connection对象?
    
    当我们需要创建SqlSession对象并需要执行SQL语句时，这时候MyBatis才会去调用
    dataSource对象来创建java.sql.Connection对象。也就是说，java.sql.Connection
    对象的创建一直延迟到执行SQL语句的时候。
    
    
    比如，我们有如下方法执行一个简单的SQL语句：
    

    ```
        String resource = "mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        SqlSession sqlSession = sqlSessionFactory.openSession();
        sqlSession.selectList("SELECT * FROM STUDENTS");
    ```
    
    前4句都不会导致java.sql.Connection对象的创建，
    只有当第5句sqlSession.selectList("SELECT * FROM STUDENTS")，
    才会触发MyBatis在底层执行下面这个方法来创建java.sql.Connection对象：
    
    
   ```
   protected void openConnection() throws SQLException {
       if (log.isDebugEnabled()) {
         log.debug("Opening JDBC Connection");
       }
       connection = dataSource.getConnection();
       if (level != null) {
         connection.setTransactionIsolation(level.getLevel());
       }
       setDesiredAutoCommit(autoCommmit);
    }

   ```
   
   
#### 4、不使用连接池的UnpooledDataSource

    使用UnpooledDataSource的getConnection(),每调用一次就会产生一个新的Connection实例对象。
    
    ```
    /*
    UnpooledDataSource的getConnection()实现
    */
    public Connection getConnection() throws SQLException
    {
        return doGetConnection(username, password);
    }
     
    private Connection doGetConnection(String username, String password) throws SQLException
    {
        //封装username和password成properties
        Properties props = new Properties();
        if (driverProperties != null)
        {
            props.putAll(driverProperties);
        }
        if (username != null)
        {
            props.setProperty("user", username);
        }
        if (password != null)
        {
            props.setProperty("password", password);
        }
        return doGetConnection(props);
    }
     
    /*
     *  获取数据连接
     */
    private Connection doGetConnection(Properties properties) throws SQLException
    {
        //1.初始化驱动
        initializeDriver();
        //2.从DriverManager中获取连接，获取新的Connection对象
        Connection connection = DriverManager.getConnection(url, properties);
        //3.配置connection属性
        configureConnection(connection);
        return connection;
    }
    
    ```
    
    如上代码所示，UnpooledDataSource会做以下事情：
    
    1.  初始化驱动：    判断driver驱动是否已经加载到内存中，如果还没有加载，则会动态地加载driver类，并实例化一个Driver对象，使用DriverManager.registerDriver()方法将其注册到内存中，以供后续使用。
    
    2.  创建Connection对象：    使用DriverManager.getConnection()方法创建连接。
    
    3.  配置Connection对象：    设置是否自动提交autoCommit和隔离级别isolationLevel。
    
    4.  返回Connection对象。


    总结：从上述的代码中可以看到，我们每调用一次getConnection()方法，都会通过DriverManager.getConnection()返回新的java.sql.Connection实例。
    

#### 5.为什么要使用连接池?

    1. 问题分析

    如果不使用连接池，每次查询都会创建连接、执行SQL语句。而创建连接Connection对象是一件
    很耗时的行为.
    
    创建一个java.sql.Connection对象的代价是如此巨大，是因为创建一个Connection对象的过程，
    在底层就相当于和数据库建立的通信连接，在建立通信连接的过程，消耗了这么多的时间，而往往我们建立连接
    后（即创建Connection对象后），就执行一个简单的SQL语句，然后就要抛弃掉，这是一个非常大的资源浪费！
    
    
    2.解决方案--》使用连接池
    
    3.解决方案:
    
    对于需要频繁地跟数据库交互的应用程序，可以在创建了Connection对象，并操作完数据库后，
    可以不释放掉资源，而是将它放到内存中，当下次需要操作数据库时，可以直接从内存中取出
    Connection对象，不需要再创建了，这样就极大地节省了创建Connection对象的资源消耗。
    由于内存也是有限和宝贵的，这又对我们对内存中的Connection对象怎么有效地维护提出了
    很高的要求。我们将在内存中存放Connection对象的容器称之为 连接池（Connection Pool）。
    下面让我们来看一下MyBatis的线程池是怎样实现的。
    
    
    
#### 6. 使用连接池的数据源--》PooledDataSource

    PooledDataSource将java.sql.connection对象封装成PooledConnection对象放到了PoolState类型的
    容器中维护。MyBatis将连接池中的PooledConnect分为2种状态：空闲状态(idel)和活动状态(active)，
    这2种状态的PooledConnection对象分别被存储到PooledState容器中的idleConnections和activeConnects
    2个List集合中
    
    
    idleConnections:空闲(idle)状态PooledConnection对象被放置到此集合中，表示当前
    闲置的没有被使用的PooledConnection集合，调用PooledDataSource的getConnection()
    方法时，会优先从此集合中取PooledConnection对象。当用完一个java.sql.Connection
    对象时，MyBatis会将其包裹成PooledConnection对象放到此集合中。
    
    
    activeConnections:活动(active)状态的PooledConnection对象被放置到名为activeConnections
    的ArrayList中，表示当前正在被使用的PooledConnection集合，调用PooledDataSource
    的getConnection()方法时，会优先从idleConnections集合中取PooledConnection对象,
    如果没有，则看此集合是否已满，如果未满，PooledDataSource会创建出一个PooledConnection，
    添加到此集合中，并返回。
    
    
    
##### 6.1 PooledDataSource获取Connection对象的过程

    ```
    public Connection getConnection() throws SQLException {
        return popConnection(dataSource.getUsername(), dataSource.getPassword()).getProxyConnection();
      }
     
    public Connection getConnection(String username, String password) throws SQLException {
       return popConnection(username, password).getProxyConnection();
    }
    ```
    
    
    现在让我们看一下popConnection()方法到底做了什么：
    
    1.  先看是否有空闲(idle)状态下的PooledConnection对象，如果有，就直接返回一个可用的PooledConnection对象；否则进行第2步。
    
    2.  查看活动状态的PooledConnection池activeConnections是否已满；
            如果没有满，则创建一个新的PooledConnection对象，然后放到activeConnections池中，
            然后返回此PooledConnection对象；否则进行第三步；
    
    3.  看最先进入activeConnections池中的PooledConnection对象是否已经过期：
            如果已经过期，从activeConnections池中移除此对象，然后创建一个新的PooledConnection对象，
            添加到activeConnections中，然后将此对象返回；否则进行第4步。
    
    4.  线程等待，循环2步

##### 6.2java.sql.Connection对象的回收
      
    使用动态代理模式，PooledConenction实现了InvocationHandler接口，
    并且，proxyConnection对象也是根据这个它来生成的代理对象：
    
    
    实际上，我们调用PooledDataSource的getConnection()方法返回的就是这个proxyConnection对象。
    
    当我们调用此proxyConnection对象上的任何方法时，都会调用PooledConnection对象内invoke()方法。
    
    让我们看一下PooledConnection类中的invoke()方法定义：
    
    ```
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        String methodName = method.getName();
        //当调用关闭的时候，回收此Connection到PooledDataSource中
        if (CLOSE.hashCode() == methodName.hashCode() && CLOSE.equals(methodName)) {
          dataSource.pushConnection(this);
          return null;
        } else {
          try {
            if (!Object.class.equals(method.getDeclaringClass())) {
              checkConnection();
            }
            return method.invoke(realConnection, args);
          } catch (Throwable t) {
            throw ExceptionUtil.unwrapThrowable(t);
          }
        }
      }
    ```
    
    从上述代码可以看到，当我们使用了pooledDataSource.getConnection()
    返回的Connection对象的close()方法时，不会调用真正Connection的close()方法，
    而是将此Connection对象放到连接池中。
    


#### 7. Druid是如何接管mybatis的连接池的?
    
    1。为什么要使用Druid而不用Pooled连接池？
        1。在工作中发现mybatis默认的连接池POOLED，运行时间长了会报莫名其妙的连接失败错误。
        2。Druid是阿里开源的数据库连接池，性能比POOLED好的多
        
      综上，我们一般使用Druid或者是hikare
      
      
    2。Druid如何接管myabtis连接池?
    
        1. 通过(DruidDataSource) DruidDataSourceFactory.createDataSource(props)
            初始化DruidDataSource实例
        2. 然后通过SqlSessionFactoryBean.setDataSource(dataSource)设置
       