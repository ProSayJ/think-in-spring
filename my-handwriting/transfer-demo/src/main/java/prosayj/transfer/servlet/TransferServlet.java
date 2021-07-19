package prosayj.transfer.servlet;


import prosayj.handwriting.spring.AnnotationConfigApplicationContext;
import prosayj.transfer.config.AppConfig;
import prosayj.transfer.pojo.Result;
import prosayj.transfer.service.TransferService;
import prosayj.transfer.tx.ProxyFactory;
import prosayj.transfer.utils.JsonUtils;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
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
    AnnotationConfigApplicationContext applicationContext;

    @PostConstruct
    public void initContext() {
        System.out.println("初始化Sping容器开始~~~~");
        applicationContext = new AnnotationConfigApplicationContext(AppConfig.class);
        System.out.println("初始化Sping容器结束~~~~");
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
        String expection = req.getParameter("hasExpection");
        int money = Integer.parseInt(moneyStr);
        boolean hasExpection = Boolean.parseBoolean(expection);

        Result result = new Result();
        try {
            // 2. 调用service层方法
            TransferService transferService = (TransferService) applicationContext.getBean("transferService");


            ProxyFactory proxyFactory = (ProxyFactory) applicationContext.getBean("proxyFactory");
            TransferService enhanceTransferService = (TransferService) proxyFactory.getJdkProxy(transferService);


            //transferService.transfer(fromCardNo, toCardNo, money, hasExpection);
            enhanceTransferService.transfer(fromCardNo, toCardNo, money, hasExpection);
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
