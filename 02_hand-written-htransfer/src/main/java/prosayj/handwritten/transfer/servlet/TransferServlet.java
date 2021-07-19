package prosayj.handwritten.transfer.servlet;

import prosayj.handwritten.transfer.container.BeanFactory;
import prosayj.handwritten.transfer.tx.ProxyFactory;
import prosayj.handwritten.transfer.pojo.Result;
import prosayj.handwritten.transfer.service.TransferService;
import prosayj.handwritten.transfer.utils.JsonUtils;

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

    /**
     * 1. 实例化service层对象
     * private TransferService transferService = new TransferServiceImpl();
     * private TransferService transferService = (TransferService) BeanFactory.getBean("transferService");
     * <p>
     * 从工厂获取委托对象（委托对象是增强了事务控制的功能）
     * 首先从BeanFactory获取到proxyFactory代理工厂的实例化对象
     */
    private final ProxyFactory proxyFactory = (ProxyFactory) BeanFactory.getBean("proxyFactory");
    private final TransferService transferService = (TransferService) proxyFactory.getJdkProxy(BeanFactory.getBean("transferService"));

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
        String expection = req.getParameter("hasExpection");
        int money = Integer.parseInt(moneyStr);
        boolean hasExpection = Boolean.parseBoolean(expection);

        Result result = new Result();
        try {
            // 2. 调用service层方法
            transferService.transfer(fromCardNo, toCardNo, money, hasExpection);
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
