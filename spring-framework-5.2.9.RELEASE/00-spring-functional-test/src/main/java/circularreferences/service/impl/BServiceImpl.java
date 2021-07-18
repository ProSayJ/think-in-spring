package circularreferences.service.impl;


import circularreferences.service.AService;
import circularreferences.service.BService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * 循环依赖测试
 *
 * @author yangjian
 * @since 1.0.0 <br>  2021-07-16 下午 05:41
 */
@Component("bService")
public class BServiceImpl implements BService {
	@Autowired
	private AService aService;

//	public BServiceImpl(AService aService) {
//		this.aService = aService;
//	}



}
