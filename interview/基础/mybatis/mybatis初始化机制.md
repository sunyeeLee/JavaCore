#### 知识清单
    ```
        1.MyBatis的初始化做了什么
    
        2. MyBatis基于XML配置文件创建Configuration对象的过程
    
        3. 手动加载XML配置文件创建Configuration对象完成初始化，创建并使用SqlSessionFactory对象
    
        4. 涉及到的设计模式
    
        5. Mybatis如何与Spring结合
    ```



#### 1. MyBatis初始化做了什么？
    任务框架的初始化，无非是加载其运行时所需要的配置信息。Mybatis的初始化本质其实就是构建Configuration的过程，
    
    MyBatis的配置信息，大概包含以下信息，其高层级结构如下：
    
    ```
    × configuration 配置
    
        × properties 属性
        × settings 设置
       × typeAliases 类型命名
       × typeHandlers 类型处理器
       × objectFactory 对象工厂
       × plugins 插件
       × environments 环境
           ×environment 环境变量
           × transactionManager 事务管理器
           ×dataSource 数据源
    × Mapper映射器
    ```
    
    MyBatis采用了一个非常直白和简单的方式---使用 org.apache.ibatis.session.Configuration
    对象作为一个所有配置信息的容器，Configuration对象的组织结构和XML配置文件的组织结构几乎完全一样
    
    
    Mybatis的初始化方式有2种：
    
    ```
    基于XML配置文件：基于XML配置文件的方式是将MyBatis的所有配置信息放在XML文件中，MyBatis
    通过加载并XML配置文件，将配置文信息组装成内部的Configuration对象
    基于Java API：这种方式不使用XML配置文件，需要MyBatis使用者在Java代码中，手动创建
    Configuration对象，然后将配置参数set 进入Configuration对象中
    ```
    
#### 2.MyBatis基于XML配置文件创建Configuration对象的过程
    
    ```
    String resource = "mybatis-config.xml";
    InputStream inputStream = Resources.getResourceAsStream(resource);
    SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
    SqlSession sqlSession = sqlSessionFactory.openSession();
    List list = sqlSession.selectList("com.foo.bean.BlogMapper.queryAllBlogInfo");
    ```
    
     上述语句的作用是执行com.foo.bean.BlogMapper.queryAllBlogInfo 定义的SQL语句，
    返回一个List结果集。总的来说，上述代码经历了mybatis初始化 -->创建SqlSession -->执行SQL语句,
    返回结果三个过程。
    
    初始化的代码：SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
    
    ![](https://img-blog.csdn.net/20140718131020765)
    初始化过程：
    
    ``` 
    1. 客户端读取mybatis-config.xml文件字节流
    2. 调用SqlSessionFactoryBuilder类的build(inputStream)方法
    3. SqlSessionFactoryBuilder根据输入的字节流创建一个XMLConfigBuilder对象
    4. SqlSessionFactoryBuilder类调用XMLConfigBuilder的parse()方法
    5. XMLConfigBuilder解析字节流后返回一个Configuration对象
    6. SqlSessionFactoryBuilder类调用build(configuration)创建DefaultSessionFactory对象
    7. 返回DeFaultSessionFactory对象给客户端使用
    ```
    
#### 3、手动加载XML配置文件创建Configuration对象完成初始化，创建并使用SqlSessionFactory对象
    
    ```
    String resource = "mybatis-config.xml";
    InputStream inputStream = Resources.getResourceAsStream(resource);
    //手动创建XMLConfigBuilder，并解析创建Configuration对象
    XMLConfigBuilder parser = new XMLConfigBuilder(inputStream, null,null);
    Configuration configuration=parse();
    //使用Configuration对象创建SqlSessionFactory
    SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(configuration);
    //使用MyBatis
    SqlSession sqlSession = sqlSessionFactory.openSession();
    List list = sqlSession.selectList("com.foo.bean.BlogMapper.queryAllBlogInfo");
    ```
    
    
#### 4. 涉及到的涉及模式
    
    1. Builder模式应用1： SqlSessionFactory的创建
    
    2. 工厂模式： SqlSessionFactory创建Session(openSession()方法)
    
    
#### 5. Mybatis如何与Spring结合?
    依赖：
    ```
        <dependency>
            <groupId>org.mybatis.spring.boot</groupId>
            <artifactId>mybatis-spring-boot-starter</artifactId>
            <version>1.3.2</version>
        </dependency>
    ```
    
    在SpringBoot项目中，mybatis与spring结合是通过SqlSessionFactoryBean类来创建SqlSeesionFactory()的，
    其本质和前面将的初始化过程是一样的
    
    ```
        SqlSessionFactoryBean factoryBean = new SqlSessionFactoryBean();
        factoryBean.setDataSource(dataSource);
        factoryBean.setMapperLocations(new PathMatchingResourcePatternResolver().getResources(mapperLocation));
        factoryBean.setTypeAliasesPackage(typeAliasesPackage);
        factoryBean.setConfigLocation(new ClassPathResource("mybatis-config.xml"));
        return factoryBean.getObject();
    ```
    设置mybatis-config.xml文件的路径、数据源、typeAliasPackage等信息，然后调用
    getObject()方法，代码如下：
    
    ```
    if (this.sqlSessionFactory == null) {
        this.afterPropertiesSet();
    }

    return this.sqlSessionFactory;
    ```
    其中afterPropertiesSet()方法中调用了
    this.sqlSessionFactory = this.buildSqlSessionFactory();
    本质还是通过SqlSessionFactoryBuilder.build(configuration)方法初始化
    