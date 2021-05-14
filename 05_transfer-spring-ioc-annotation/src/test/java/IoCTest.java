
import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import prosayj.springiocannotation.transfer.dao.AccountDao;
import prosayj.springiocannotation.transfer.service.TransferService;

/**
 * IoCTest
 *
 * @author yangjian
 * @date 2021-05-13
 */
public class IoCTest {


    @Test
    public void testIoC() throws Exception {
        // 通过读取classpath下的xml文件来启动容器（xml模式SE应用下推荐）
        ClassPathXmlApplicationContext applicationContext = new ClassPathXmlApplicationContext("classpath:applicationContext.xml");
        // 不推荐使用
        //ApplicationContext applicationContext1 = new FileSystemXmlApplicationContext("文件系统的绝对路径");
        AccountDao accountDao = (AccountDao) applicationContext.getBean("accountDao");

        accountDao.queryAccountByCardNo("1111111");
        System.out.println("accountDao：" + accountDao);
        AccountDao accountDao1 = (AccountDao) applicationContext.getBean("accountDao");
        System.out.println("accountDao1：" + accountDao1);


        Object connectionUtils = applicationContext.getBean("connectionUtils");
        System.out.println(connectionUtils);

        applicationContext.close();
    }


    /**
     * 测试bean的lazy-init属性
     */
    @Test
    public void testBeanLazy() {
        ClassPathXmlApplicationContext applicationContext = new ClassPathXmlApplicationContext("classpath:applicationContext.xml");
        Object lazyResult = applicationContext.getBean("lazyResult");
        System.out.println(lazyResult);
        applicationContext.close();
    }


    /**
     * 测试xml aop
     */
    @Test
    public void testXmlAop() throws Exception {
        ClassPathXmlApplicationContext applicationContext = new ClassPathXmlApplicationContext("classpath:applicationContext.xml");
        TransferService transferService = applicationContext.getBean(TransferService.class);
        transferService.transfer("6029621011000", "6029621011001", 100);
    }


    /**
     * 测试xml-anno aop
     */
    @Test
    public void testXmlAnnoAop() throws Exception {
        ClassPathXmlApplicationContext applicationContext = new ClassPathXmlApplicationContext("classpath:applicationContext.xml");
        TransferService transferService = applicationContext.getBean(TransferService.class);
        transferService.transfer("6029621011000", "6029621011001", 100);
    }


}