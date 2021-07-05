package prosayj.thinking.spring;


import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import prosayj.thinking.spring.common.util.JsonUtils;

import java.io.InputStream;
import java.util.List;

/**
 * XpathTest
 *
 * @author yangjian
 * @date 2021-05-14
 */
public class XpathTest {
    public final Logger logger = LoggerFactory.getLogger(getClass());


    /**
     * XPath 使用路径表达式来选取 XML 文档中的节点或节点集
     * <p>
     * 经常使用到的路径表达式,如下
     * <p>
     * nodename	选取此节点的所有子节点。
     * /	        从根节点选取。
     * //	        从匹配选择的当前节点选择文档中的节点，而不考虑它们的位置。
     * .	        选取当前节点。
     * ..	        选取当前节点的父节点。
     *
     * @	 选取属性。
     */

    @Test
    public void testXpath() throws DocumentException {
        InputStream resourceAsStream = this.getClass().getClassLoader().getResourceAsStream("books.xml");
        SAXReader saxReader = new SAXReader();
        Document document = saxReader.read(resourceAsStream);
        Element rootElement = document.getRootElement();
        // 找 xml 根元素的下一级元素
        @SuppressWarnings("unchecked")
        List<Element> selectNodes = rootElement.selectNodes("book");
        for (Element element : selectNodes) {
            logger.info(element.attributeValue("title"));
            logger.info(element.attributeValue("price"));
        }
    }
}
