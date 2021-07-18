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
@Component("aService")
public class AServiceImpl implements AService {
	@Autowired
	private BService bService;

//	public AServiceImpl(BService bService) {
//		this.bService = bService;
//	}


}
