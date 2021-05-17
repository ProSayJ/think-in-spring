
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import prosayj.spring.iocaop.xml.transfer.dao.AccountDao;
import prosayj.spring.iocaop.xml.transfer.service.TransferService;

/**
 * IoCTest
 *
 * @author yangjian
 * @date 2021-05-13
 */
public class IoCTest {


    @Test
    public void testIoC() throws Exception {
        // Applicationcontext 是容器的高级接口， Beanfacotry(顶级容器/根容器，规范了/定义了容器的基础行为)
        // Spring应用上下文，官方称之为IoC容器（错误的认识：容器就是map而已；准确来说，map是ioc容器的一个成员，叫做单例池， sinaletonobiects,容器是一组组件和过程的集合
        // 包括BeanFactory、单例池、BeanPostProcesser等以及之间的协作
        // 通过读取classpath下的xml文件来启动容器（xml模式SE应用下推荐）
        ClassPathXmlApplicationContext applicationContext = new ClassPathXmlApplicationContext("classpath:applicationContext.xml");
        // 不推荐使用
        //ApplicationContext applicationContext1 = new FileSystemXmlApplicationContext("文件系统的绝对路径");
        AccountDao accountDao =  applicationContext.getBean(AccountDao.class);

        ClassPathXmlApplicationContext context = applicationContext;
        context.close();

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