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
@Component("bService")
public class BServiceImpl implements BService {
	@Autowired
	private AService aService;

//	public BServiceImpl(AService aService) {
//		this.aService = aService;
//	}



}
