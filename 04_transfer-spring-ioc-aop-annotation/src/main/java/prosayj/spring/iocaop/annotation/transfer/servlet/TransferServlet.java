package prosayj.spring.iocaop.annotation.transfer.servlet;

import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;
import prosayj.spring.iocaop.annotation.transfer.pojo.Result;
import prosayj.spring.iocaop.annotation.transfer.service.TransferService;
import prosayj.spring.iocaop.annotation.transfer.utils.JsonUtils;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * TransferServlet
 *
 * @author yangjian
 * @date 2021-05-13
 */
@WebServlet(name = "transferServlet", urlPatterns = "/transferServlet")
public class TransferServlet extends HttpServlet {

    private TransferService transferService;


    /**
     * 1. 实例化service层对象
     * 1.1:原始new
     * private TransferService transferService = new TransferServiceImpl();
     * private TransferService transferService = (TransferService) BeanFactory.getBean("transferService");
     * <p>
     * 1.2：使用手写的BeanFactory获取对象
     * 从工厂获取委托对象（委托对象是增强了事务控制的功能）
     * 首先从BeanFactory获取到proxyFactory代理工厂的实例化对象
     * private final ProxyFactory proxyFactory = (ProxyFactory) BeanFactory.getBean("proxyFactory");
     * private final TransferService transferService = (TransferService) proxyFactory.getJdkProxy(BeanFactory.getBean("transferService"));
     * <p>
     * 1.3：从spring容器获取对象
     */
    @Override
    public void init() throws ServletException {
        WebApplicationContext webApplicationContext = WebApplicationContextUtils.getWebApplicationContext(this.getServletContext());
        assert webApplicationContext != null;
        transferService = webApplicationContext.getBean(TransferService.class);
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // 设置请求体的字符编码
        req.setCharacterEncoding("UTF-8");

        String fromCardNo = req.getParameter("fromCardNo");
        String toCardNo = req.getParameter("toCardNo");
        String moneyStr = req.getParameter("money");
        int money = Integer.parseInt(moneyStr);

        Result result = new Result();
        try {
            // 2. 调用service层方法
            transferService.transfer(fromCardNo, toCardNo, money);
            result.setStatus("200");
        } catch (Exception e) {
            e.printStackTrace();
            result.setStatus("201");
            result.setMessage(e.toString());
        }

        // 响应
        resp.setContentType("application/json;charset=utf-8");
        resp.getWriter().print(JsonUtils.object2Json(result));
    }
}
