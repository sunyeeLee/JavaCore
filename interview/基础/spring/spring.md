#### Spring中bean的生命周期
    Bean 容器找到配置文件中 Spring Bean 的定义。
    Bean 容器利用 Java Reflection API 创建一个Bean的实例。
    如果涉及到一些属性值 利用 set()方法设置一些属性值。
    如果 Bean 实现了 BeanNameAware 接口，调用 setBeanName()方法，传入Bean的名字。
    如果 Bean 实现了 BeanClassLoaderAware 接口，调用 setBeanClassLoader()方法，传入 ClassLoader对象的实例。
    与上面的类似，如果实现了其他 *.Aware接口，就调用相应的方法。
    如果有和加载这个 Bean 的 Spring 容器相关的 BeanPostProcessor 对象，执行postProcessBeforeInitialization() 方法
    如果Bean实现了InitializingBean接口，执行afterPropertiesSet()方法。
    如果 Bean 在配置文件中的定义包含 init-method 属性，执行指定的方法。
    如果有和加载这个 Bean的 Spring 容器相关的 BeanPostProcessor 对象，执行postProcessAfterInitialization() 方法
    当要销毁 Bean 的时候，如果 Bean 实现了 DisposableBean 接口，执行 destroy() 方法。
    当要销毁 Bean 的时候，如果 Bean 在配置文件中的定义包含 destroy-method 属性，执行指定的方法。
    
    
#### SpringBoot的优势
    Spring Boot中最重要的两个优势就是可以使用starter简化依赖配置和Spring的自动配置。
    
    1。使用starter简化依赖配置
    Spring提供了一系列starter来简化Maven配置。其核心原理也就是Maven和Gradle的依赖传递方案。
    当我们在我们的pom文件中增加对某个starter的依赖时，该starter的依赖也会自动的传递性被依赖进来。
    而且，很多starter也依赖了其他的starter。例如web starter就依赖了tomcat starter，并且大多数starter
    基本都依赖了spring-boot-starter。
    
    2。Spring自动配置
    Spring Boot会根据类路径中的jar包、类，为jar包里的类自动配置，这样可以极大的减少配置的数量。
    简单点说就是它会根据定义在classpath下的类，自动的给你生成一些Bean，并加载到Spring的Context中。
    自动配置充分的利用了spring 4.0的条件化配置特性，能够自动配置特定的Spring bean，用来启动某项特性。
       
    3。条件化配置
    假设你希望一个或多个bean只有在某种特殊的情况下才需要被创建，比如，一个应用同时服务于中美用户，要在中美部署，
    有的服务在美国集群中需要提供，在中国集群中就不需要提供。在Spring 4之前，要实现这种级别的条件化配置是比较复杂的，
    但是，Spring 4引入了一个新的@Conditional注解可以有效的解决这类问题。
    
    @Bean
    @Conditional(ChinaEnvironmentCondition.class)
    public ServiceBean serviceBean(){
        return new ServiceBean();
    }
    当@Conditional(ChinaEnvironmentCondition.class)条件的值为true的时候，该ServiceBean才会被创建，否则该bean就会被忽略。
    
    @Conditional指定了一个条件。他的条件的实现是一个Java类——ChinaEnvironmentCondition，要实现以上功能就要定义ChinaEnvironmentCondition类，
    并继承Condition接口并重写其中的matches方法。
    class ChinaEnvironmentCondition implements Condition{
        public final boolean matches(ConditionContext context, AnnotatedTypeMetadata metadata) {
    
            Environment env = context.getEnvironment();
            return env.containProperty("ENV_CN");
        }
    }MessageQueueSelector
    
#### Spring Boot的自动配置
    ![https://www.hollischuang.com/archives/1791]()
    
    
#### Spring如何实现AOP？，您可以这样说：
    AnnotationAwareAspectJAutoProxyCreator是AOP核心处理类
    AnnotationAwareAspectJAutoProxyCreator实现了BeanProcessor，其中postProcessAfterInitialization是核心方法。
    核心实现分为2步
     getAdvicesAndAdvisorsForBean获取当前bean匹配的增强器 createProxy为当前bean创建代理
    getAdvicesAndAdvisorsForBean核心逻辑如下
     a. 找所有增强器，也就是所有@Aspect注解的Bean
     b. 找匹配的增强器，也就是根据@Before，@After等注解上的表达式，与当前bean进行匹配，暴露匹配上的。
     c. 对匹配的增强器进行扩展和排序，就是按照@Order或者PriorityOrdered的getOrder的数据值进行排序，越小的越靠前。
    createProxy有2种创建方法，JDK代理或CGLIB
     a. 如果设置了proxyTargetClass=true，一定是CGLIB代理
     b. 如果proxyTargetClass=false，目标对象实现了接口，走JDK代理
     c. 如果没有实现接口，走CGLIB代理