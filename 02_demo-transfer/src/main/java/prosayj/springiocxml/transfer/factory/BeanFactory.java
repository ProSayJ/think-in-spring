package prosayj.springiocxml.transfer.factory;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

import java.io.InputStream;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 工厂类，生产对象的工厂（使用反射技术）
 * <p>
 * 读取解析xml，通过反射技术实例化对象并且存储待用（map集合）
 * 对外提供获取实例对象的接口（根据id获取）
 *
 * @author yangjian
 * @date 2021-05-13
 */
public class BeanFactory {
    /**
     * 存储对象
     */
    private static final Map<String, Object> MAP = new HashMap<>();


    static {
        // 任务一：读取解析xml，通过反射技术实例化对象并且存储待用（map集合）
        // 加载xml
        InputStream resourceAsStream = BeanFactory.class.getClassLoader().getResourceAsStream("beans.xml");
        // 解析xml
        SAXReader saxReader = new SAXReader();
        try {
            Document document = saxReader.read(resourceAsStream);
            Element rootElement = document.getRootElement();
            @SuppressWarnings("unchecked")
            List<Element> beanList = rootElement.selectNodes("//bean");
            for (Element element : beanList) {
                // 处理每个bean元素，获取到该元素的id 和 class 属性
                String id = element.attributeValue("id");
                String clazz = element.attributeValue("class");
                // 通过反射技术实例化对象
                Class<?> aClass = Class.forName(clazz);
                // 实例化之后的对象,存储到map中待用
                MAP.put(id, aClass.newInstance());

            }

            // 实例化完成之后维护对象的依赖关系，检查哪些对象需要传值进入，根据它的配置，我们传入相应的值
            // 有property子元素的bean就有传值需求
            @SuppressWarnings("unchecked")
            List<Element> propertyList = rootElement.selectNodes("//property");
            // 解析property，获取父元素
            for (Element element : propertyList) {
                //<property name="AccountDao" ref="accountDao"/>
                String name = element.attributeValue("name");
                String ref = element.attributeValue("ref");

                // 找到当前需要被处理依赖关系的bean
                Element parent = element.getParent();

                // 调用父元素对象的反射功能
                String parentId = parent.attributeValue("id");
                Object parentObject = MAP.get(parentId);
                // 遍历父对象中的所有方法，找到"set" + name
                Method[] methods = parentObject.getClass().getMethods();
                for (Method method : methods) {
                    // 该方法就是 setAccountDao(AccountDao accountDao)
                    if (method.getName().equalsIgnoreCase("set" + name)) {
                        method.invoke(parentObject, MAP.get(ref));
                    }
                }

                // 把处理之后的parentObject重新放到map中
                MAP.put(parentId, parentObject);

            }

        } catch (DocumentException | ClassNotFoundException |
                IllegalAccessException | InstantiationException | InvocationTargetException e) {
            e.printStackTrace();
        }

    }


    /**
     * 对外提供获取实例对象的接口（根据id获取）
     *
     * @param id id
     * @return Object
     */
    public static Object getBean(String id) {
        return MAP.get(id);
    }

}
