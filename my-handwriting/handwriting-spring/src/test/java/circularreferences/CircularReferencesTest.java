package circularreferences;


import circularreferences.config.AppConfig;
import circularreferences.service.AService;
import circularreferences.service.BService;
import prosayj.handwriting.spring.AnnotationConfigApplicationContext;

/**
 * 1：构造注入的循环依赖Spring无法解决。<br>
 * 2：set注入可以解决，要求不能重写toString方法。<br>
 * 3：set注入和构造注入都存在时，Spring框架优先使用构造注入。<br>
 *
 * @author yangjian
 * @since 1.0.0 <br>2021-07-16 上午 08:36
 */
public class CircularReferencesTest {

	public static void main(String[] args) {
		AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext(AppConfig.class);

		AService aService = (AService) applicationContext.getBean("aService");
		System.out.println(aService);
		BService bService = (BService) applicationContext.getBean("bService");
		System.out.println(bService);

	}
}
