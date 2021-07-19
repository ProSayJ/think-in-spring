package circularreferences.service.impl;


import circularreferences.service.AService;
import circularreferences.service.BService;
import prosayj.handwriting.spring.Autowired;
import prosayj.handwriting.spring.Component;

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
