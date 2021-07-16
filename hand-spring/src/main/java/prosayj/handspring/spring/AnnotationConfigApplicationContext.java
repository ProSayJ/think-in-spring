package prosayj.handspring.spring;

import java.io.File;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.net.URL;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;

/**
 * AnnotationConfigApplicationContext
 *
 * @author yangjian
 * @since 1.0.0 <br>2021-07-16 上午 08:39
 */
public class AnnotationConfigApplicationContext {
    private final Class<?> configClass;
    /**
     * 单例池
     */
    private final ConcurrentHashMap<String, Object> singletonObjects = new ConcurrentHashMap<>(255);
    /**
     * beanDefinitionMap
     */
    private final LinkedHashMap<String, BeanDefinition> beanDefinitionMap = new LinkedHashMap<>(255);
    //   private final ConcurrentHashMap<String, BeanDefinition> beanDefinitionMap = new ConcurrentHashMap<>(255);

    /**
     * beanPostProcessors
     */
    private final List<BeanPostProcessor> beanPostProcessors = new ArrayList<>(128);

    public AnnotationConfigApplicationContext(Class<?> configClass) {
        //1：拿到配置类
        this.configClass = configClass;

        //2：解析配置类并注册 BeanDefinition
        //ComponentSacn 注解--->扫描路径---->扫描---->注册 BeanDefinition
        sacn();

        //3:实例化
        beanDefinitionMap.forEach((beanName, beanDefinition) -> {
            if ("singleton".equals(beanDefinition.getScope())) {
                //创建单例Bean
                Object o = createBean(beanName, beanDefinition);
                assert o != null;
                singletonObjects.put(beanName, o);
            }
        });

    }

    private void sacn() {
        ComponentSacn componentSacnAnnotation = configClass.getDeclaredAnnotation(ComponentSacn.class);
        String value = componentSacnAnnotation.value();
        //System.out.println("---value----->" + value);
        value = value.replaceAll("\\.", "/");
        //System.out.println("----value---->" + value);
        //扫描
        // BootStrap---> jre/lib
        // Ext---------> jre/ext/lib
        // App---------> classpath
        ClassLoader classLoader = AnnotationConfigApplicationContext.class.getClassLoader();
        URL resource = classLoader.getResource(value);
        assert resource != null;
        File fileDir = new File(resource.getFile());
        if (fileDir.isDirectory()) {
            File[] files = fileDir.listFiles();
            assert files != null;
            for (File file : files) {
                if (file.isFile()) {
                    String fileName = file.getAbsolutePath();
                    //System.out.println("----fileName---->" + fileName);
                    String clazzName = fileName.substring(fileName.indexOf("classes") + "classes".length() + 1, fileName.indexOf(".class"))
                            .replaceAll("/", ".").replaceAll("\\\\", ".");
                    //System.out.println("----clazzName---->" + clazzName);

                    try {
                        Class<?> beanClass = classLoader.loadClass(clazzName);
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

                            //System.out.println("----beanClass---->" + beanClass);
                            Component componentAnnotation = beanClass.getDeclaredAnnotation(Component.class);
                            String beanName = componentAnnotation.value();

                            BeanDefinition beanDefinition = new BeanDefinition();
                            beanDefinition.setClazz(beanClass);
                            if (beanClass.isAnnotationPresent(Scope.class)) {
                                Scope scopeAnnotation = beanClass.getDeclaredAnnotation(Scope.class);
                                beanDefinition.setScope(scopeAnnotation.value());
                            } else {
                                //默认为单例
                                beanDefinition.setScope("singleton");
                            }
                            beanDefinitionMap.put(beanName, beanDefinition);
                        }
                    } catch (ClassNotFoundException | NoSuchMethodException | InvocationTargetException | InstantiationException | IllegalAccessException e) {
                        e.printStackTrace();
                    }

                }
            }


        }


    }

    public Object getBean(String beanName) {
        if (beanDefinitionMap.containsKey(beanName)) {
            BeanDefinition beanDefinition = beanDefinitionMap.get(beanName);
            if ("singleton".equals(beanDefinition.getScope())) {
                return singletonObjects.get(beanName);
            } else {
                //如何创建bean？
                return createBean(beanName, beanDefinition);
            }
        } else {
            throw new RuntimeException("Bean 不存在");
        }
    }


    private Object createBean(String beanName, BeanDefinition beanDefinition) {
        Class<?> clazz = beanDefinition.getClazz();
        try {
            Object instance = clazz.getDeclaredConstructor().newInstance();

            //依赖注入
            for (Field declaredField : clazz.getDeclaredFields()) {
                if (declaredField.isAnnotationPresent(Autowired.class)) {
                    //获取目标对象中的属性名称
                    String fieldName = declaredField.getName();
                    //生成目标对象中的属性的对象
                    Object bean = getBean(fieldName);
                    // TODO 如果获取的bean为null? 怎么办?

                    //给对目标象中属性赋值
                    declaredField.setAccessible(true);
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

            // 初始化之后 BeanPostProcessor ---> InitDestroyAnnotationBeanPostProcessor
            for (BeanPostProcessor beanPostProcessor : beanPostProcessors) {
                //传入的对象和返回的对象不一定是同一个对象，虽然用的是同一个引用。
                instance = beanPostProcessor.postProcessAfterInitialization(instance, beanName);
            }
            return instance;
        } catch (InstantiationException | IllegalAccessException | InvocationTargetException | NoSuchMethodException e) {
            e.printStackTrace();
        }
        return null;
    }


}
