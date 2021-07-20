package prosayj.handwritingspring.spring;


import java.io.File;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import static prosayj.handwritingspring.spring.BeanDefinition.SCOPE_SINGLETON;


/**
 * AnnotationConfigApplicationContext
 *
 * @author yangjian
 * @since 1.0.0 <br>2021-07-16 上午 08:39
 */
public class AnnotationConfigApplicationContext {
    private Class<?> configClass;


    /**
     * 一级缓存：单例对象的cache,已经初始化完成的bean<br>
     * https://blog.csdn.net/qwe123147369/article/details/109552743
     * 如果一个类创建过了, 那么就请不要在创建了
     */
    private final ConcurrentHashMap<String, Object> singletonObjects = new ConcurrentHashMap<>(255);


    /**
     * Cache of singleton factories: bean name to ObjectFactory.<br>
     * 三级缓存：单例对象工厂的cache
     */
    //private final Map<String, ObjectFactory<?>> singletonFactories = new HashMap<>(16);

    /**
     * Cache of early singleton objects: bean name to bean instance.<br>
     * 二级缓存：提前暴光的单例对象的Cache
     */
    private final Map<String, Object> earlySingletonObjects = new ConcurrentHashMap<>(16);


    /**
     * beanDefinitionMap
     */
    private final ConcurrentHashMap<String, BeanDefinition> beanDefinitionMap = new ConcurrentHashMap<>(255);


    /**
     * beanPostProcessors
     */
    private final List<BeanPostProcessor> beanPostProcessors = new ArrayList<>(128);

    public AnnotationConfigApplicationContext(Class<?> configClass) {
        //1：加载资源【配置类】
        this.register(configClass);
        //2：扫描配置类指定路径下的 符合的所有 Bean 并注册 每个bean对应的  BeanDefinition
        this.scanningAndLoadBeanDefinition();
        //3:通过注册的 BeanDefinition 实例化 Bean
        this.createBean();
    }


    /**
     * 加载 Resource 资源
     *
     * @param configClass configClass
     */
    private void register(Class<?> configClass) {
        this.configClass = configClass;
    }

    /**
     * 扫描注解，加载 BeanDefinition
     */
    private void scanningAndLoadBeanDefinition() {
        ComponentScan componentSacnAnnotation = configClass.getDeclaredAnnotation(ComponentScan.class);
        // 获取待扫描包路径：eg:   prosayj.handspring.test.service
        String value = componentSacnAnnotation.value();
        //将包路径拼接成文件路径 eg:  prosayj/handspring/test/service
        value = value.replaceAll("\\.", "/");
        //通过 classLoad 获取 包路径资源
        // BootStrap---> jre/lib
        // Ext---------> jre/ext/lib
        // App---------> classpath
        ClassLoader classLoader = AnnotationConfigApplicationContext.class.getClassLoader();
        URL resource = classLoader.getResource(value);
        assert resource != null;
        // eg: /C:/idea_workspace/git/ProSayJ/think-more/think-in-spring/hand-spring/target/classes/prosayj/handspring/test/service
        File fileDir = new File(resource.getFile());

        //加载 Bean 定义
        loadBeanDefinition(fileDir, classLoader);

    }


    /**
     * createBean
     */
    private void createBean() {
        beanDefinitionMap.forEach((beanName, beanDefinition) -> {
            if (SCOPE_SINGLETON.equals(beanDefinition.getScope())) {
                //创建单例Bean
                Object o = doCreateBean(beanName, beanDefinition);
                assert o != null;
                singletonObjects.put(beanName, o);
            }
        });
    }


    /**
     * 递归指定文件目录下的所有文件 加载 BeanDefinition
     *
     * @param rootFile    根文件目录
     * @param classLoader 类加载器
     */
    private void loadBeanDefinition(File rootFile, ClassLoader classLoader) {
        if (rootFile.isDirectory()) {
            File[] files = rootFile.listFiles();
            assert files != null;
            for (File file : files) {
                if (file.isFile()) {
                    doLoadBeanDefinition(file, classLoader);
                } else if (file.isDirectory()) {
                    File[] subfiles = file.listFiles();
                    assert subfiles != null;
                    for (File subFile : subfiles) {
                        loadBeanDefinition(subFile, classLoader);
                    }
                }
            }
        } else if (rootFile.isFile()) {
            doLoadBeanDefinition(rootFile, classLoader);
        }
    }


    public Object getBean(String beanName) {
        if (beanDefinitionMap.containsKey(beanName)) {
            BeanDefinition beanDefinition = beanDefinitionMap.get(beanName);
            if (SCOPE_SINGLETON.equals(beanDefinition.getScope())) {
                Object o = singletonObjects.get(beanName);
                if (o == null) {
                    Object bean = doCreateBean(beanName, beanDefinition);
                    assert bean != null;
                    singletonObjects.put(beanName, bean);
                    return bean;
                }
                return o;
            } else {
                //非单例 Bean 延时加载
                Object o = doCreateBean(beanName, beanDefinition);
                assert o != null;
                singletonObjects.put(beanName, o);
                return o;
            }
        } else {
            throw new RuntimeException("NoSuchBeanDefinitionException No bean named '" + beanName + "' available");
        }
    }

    private Object getSingleton(String beanName) {
        Object singletonObject = this.singletonObjects.get(beanName);
        if (singletonObject == null) {
            singletonObject = this.earlySingletonObjects.get(beanName);
            if (singletonObject == null) {
                synchronized (this.singletonObjects) {
                    singletonObject = this.singletonObjects.get(beanName);
                    if (singletonObject == null) {
                        singletonObject = this.singletonObjects.get(beanName);
                        if (singletonObject == null) {

                        }
                    }
                }
            }
        }
        return null;
    }

    @SuppressWarnings("unchecked")
    public <T> T getBean(Class<T> requiredType) {
//        beanDefinitionMap.values().stream().map()
        for (BeanDefinition beanDefinition : beanDefinitionMap.values()) {

        }
        return (T) new Object();
    }


    private Object doCreateBean(String beanName, BeanDefinition beanDefinition) {
        Class<?> clazz = beanDefinition.getClazz();
        try {
            Object targetInstance = clazz.getDeclaredConstructor().newInstance();

            //依赖注入
            for (Field declaredField : clazz.getDeclaredFields()) {
                if (declaredField.isAnnotationPresent(Autowired.class)) {
                    //Type genericType = declaredField.getGenericType();
                    //Class<? extends Field> fieldClass = declaredField.getClass();


                    //获取目标对象中的属性名称
                    String fieldName = declaredField.getName();
                    //生成目标对象中的属性的对象
                    Object bean = getBean(fieldName);
                    // TODO 如果获取的bean为null? 怎么办?
                    //设置目标象中属性可访问
                    declaredField.setAccessible(true);
                    //给目标象中属性赋值
                    declaredField.set(targetInstance, bean);
                }
            }

            // Aware 回调
            if (targetInstance instanceof BeanNameAware) {
                ((BeanNameAware) targetInstance).setBeanName(beanName);
            }

            //初始化之前 BeanPostProcessor ---> InitDestroyAnnotationBeanPostProcessor
            for (BeanPostProcessor beanPostProcessor : beanPostProcessors) {
                //传入的对象和返回的对象不一定是同一个对象，虽然用的是同一个引用。
                targetInstance = beanPostProcessor.postProcessBeforeInitialization(targetInstance, beanName);
            }

            // 初始化
            if (targetInstance instanceof InitializingBean) {
                try {
                    ((InitializingBean) targetInstance).afterPropertiesSet();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }

            // 初始化之后 BeanPostProcessor --->
            // eg:InitDestroyAnnotationBeanPostProcessor
            // eg:AutowiredAnnotationBeanPostProcessor
            for (BeanPostProcessor beanPostProcessor : beanPostProcessors) {
                //传入的对象和返回的对象不一定是同一个对象，虽然用的是同一个引用。
                targetInstance = beanPostProcessor.postProcessAfterInitialization(targetInstance, beanName);

                //初始化之后的对象，即Spring容器中的真正的对象。
                //aop可以在此实现.实际源码中开启aop的注解：EnableAspectJAutoProxy 底层就是 实现了  BeanPostProcessor 接口

            }
            return targetInstance;
        } catch (InstantiationException | IllegalAccessException | InvocationTargetException | NoSuchMethodException e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * 加载指定文件的 Bean 定义
     *
     * @param file        指定文件
     * @param classLoader 类加载器
     */
    private void doLoadBeanDefinition(File file, ClassLoader classLoader) {
        if (file.isDirectory()) {
            throw new RuntimeException("LoadBeanDefinition Error");
        }
        String beanAbsoluteFilePath = file.getAbsolutePath();
        String beanClassPath = beanAbsoluteFilePath
                .substring(beanAbsoluteFilePath.indexOf("classes") + "classes".length() + 1, beanAbsoluteFilePath.indexOf(".class"))
                .replaceAll("/", ".").replaceAll("\\\\", ".");

        try {
            Class<?> beanClass = classLoader.loadClass(beanClassPath);
            //class--->Bean？？  需要看Bean的作用域

            //判断当前Bean是单例Bean还是原型Bean。即：需要解析Bean---->BeanDefinition
            //判断当前的这个类是一个目标Bean
            if (beanClass.isAnnotationPresent(Component.class)) {

                //判断 beanClass 是否实现了 BeanPostProcessor 这个接口
                if (BeanPostProcessor.class.isAssignableFrom(beanClass)) {
                    //实际源码中不是自己 newInstance 而是 getBean 方法。因为 自定义的 BeanPostProcessor 也可能会 Autowired 一些对象。
                    BeanPostProcessor beanPostProcessor =
                            (BeanPostProcessor) beanClass.getDeclaredConstructor().newInstance();
                    beanPostProcessors.add(beanPostProcessor);
                }

                //获取 Component 注解上自定义的 Bean 名称
                String customerBeanName = beanClass
                        .getDeclaredAnnotation(Component.class)
                        .value();
                //如果注解上没有指定bean名称则默认赋值bean名称
                customerBeanName = "".equals(customerBeanName) ?
                        beanClass.getSimpleName().substring(0, 1).toLowerCase() + beanClass.getSimpleName().substring(1) :
                        customerBeanName;

                BeanDefinition beanDefinition = new BeanDefinition();
                beanDefinition.setClazz(beanClass);
                if (beanClass.isAnnotationPresent(Scope.class)) {
                    Scope scopeAnnotation = beanClass.getDeclaredAnnotation(Scope.class);
                    beanDefinition.setScope(scopeAnnotation.value());
                } else {
                    //默认为单例
                    beanDefinition.setScope(SCOPE_SINGLETON);
                }
                beanDefinitionMap.put(customerBeanName, beanDefinition);
            }
        } catch (ClassNotFoundException | NoSuchMethodException | InvocationTargetException | InstantiationException | IllegalAccessException e) {
            e.printStackTrace();
        }

    }


}
