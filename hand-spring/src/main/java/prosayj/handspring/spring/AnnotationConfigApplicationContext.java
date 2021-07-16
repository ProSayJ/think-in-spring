package prosayj.handspring.spring;

import java.io.File;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Type;
import java.net.URL;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;

import static prosayj.handspring.spring.BeanDefinition.SCOPE_SINGLETON;

/**
 * AnnotationConfigApplicationContext
 *
 * @author yangjian
 * @since 1.0.0 <br>2021-07-16 上午 08:39
 */
public class AnnotationConfigApplicationContext {
    private Class<?> configClass;

    /**
     * beanDefinitionMap
     */
    private final LinkedHashMap<String, BeanDefinition> beanDefinitionMap = new LinkedHashMap<>(255);
    //   private final ConcurrentHashMap<String, BeanDefinition> beanDefinitionMap = new ConcurrentHashMap<>(255);

    /**
     * 一级缓存【单例池】
     */
    private final ConcurrentHashMap<String, Object> singletonObjects = new ConcurrentHashMap<>(255);


    /**
     * beanPostProcessors
     */
    private final List<BeanPostProcessor> beanPostProcessors = new ArrayList<>(128);

    public AnnotationConfigApplicationContext(Class<?> configClass) {
        //1：加载资源【配置类】
        this.register(configClass);
        //2：扫描配置类指定路径下的 符合的所有 Bean 并注册 每个bean对应的  BeanDefinition
        this.scanning();
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
    private void scanning() {
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
                return singletonObjects.get(beanName);
            } else {
                //如何创建bean？
                return doCreateBean(beanName, beanDefinition);
            }
        } else {
            throw new RuntimeException("NoSuchBeanDefinitionException No bean named '" + beanName + "' available");
        }
    }

    @SuppressWarnings("unchecked")
    public <T> T getBean(Class<T> requiredType) {
        //TODO
        return (T) new Object();
    }


    private Object doCreateBean(String beanName, BeanDefinition beanDefinition) {
        Class<?> clazz = beanDefinition.getClazz();
        try {
            Object instance = clazz.getDeclaredConstructor().newInstance();

            //依赖注入
            for (Field declaredField : clazz.getDeclaredFields()) {
                if (declaredField.isAnnotationPresent(Autowired.class)) {

                    Type genericType = declaredField.getGenericType();
                    Class<? extends Field> fieldClass = declaredField.getClass();


                    //获取目标对象中的属性名称
                    String fieldName = declaredField.getName();
                    //生成目标对象中的属性的对象
                    Object bean = getBean(fieldName);
                    // TODO 如果获取的bean为null? 怎么办?
                    //设置目标象中属性可访问
                    declaredField.setAccessible(true);
                    //给目标象中属性赋值
                    declaredField.set(instance, bean);
                }
            }

            // Aware 回调
            if (instance instanceof BeanNameAware) {
                ((BeanNameAware) instance).setBeanName(beanName);
            }

            //初始化之前 BeanPostProcessor ---> InitDestroyAnnotationBeanPostProcessor
            for (BeanPostProcessor beanPostProcessor : beanPostProcessors) {
                //传入的对象和返回的对象不一定是同一个对象，虽然用的是同一个引用。
                instance = beanPostProcessor.postProcessBeforeInitialization(instance, beanName);
            }

            // 初始化
            if (instance instanceof InitializingBean) {
                try {
                    ((InitializingBean) instance).afterPropertiesSet();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }

            // 初始化之后 BeanPostProcessor --->
            // eg:InitDestroyAnnotationBeanPostProcessor
            // eg:AutowiredAnnotationBeanPostProcessor
            for (BeanPostProcessor beanPostProcessor : beanPostProcessors) {
                //传入的对象和返回的对象不一定是同一个对象，虽然用的是同一个引用。
                instance = beanPostProcessor.postProcessAfterInitialization(instance, beanName);

                //初始化之后的对象，即Spring容器中的真正的对象。
                //aop可以在此实现.实际源码中开启aop的注解：EnableAspectJAutoProxy 底层就是 实现了  BeanPostProcessor 接口

            }
            return instance;
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
