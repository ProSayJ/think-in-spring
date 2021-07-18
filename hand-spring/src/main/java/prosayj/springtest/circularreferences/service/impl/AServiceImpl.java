package prosayj.springtest.circularreferences.service.impl;

import prosayj.springtest.spring.Autowired;
import prosayj.springtest.spring.Component;
import prosayj.springtest.circularreferences.service.AService;
import prosayj.springtest.circularreferences.service.BService;

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
