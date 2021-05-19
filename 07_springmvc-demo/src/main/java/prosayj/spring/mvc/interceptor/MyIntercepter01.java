package prosayj.spring.mvc.interceptor;


import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 自定义springmvc拦截器
 *
 * @author yangjian
 * @date 2021-05-19
 */
public class MyIntercepter01 implements HandlerInterceptor {


    /**
     * 会在handler方法业务逻辑执行之前执行
     * 往往在这里完成权限校验工作
     *
     * @return 返回值boolean代表是否放行，true代表放行，false代表中止
     */
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        System.out.println("MyIntercepter01 preHandle......");
        return true;
    }


    /**
     * 会在handler方法业务逻辑执行之后尚未跳转页面时执行
     *
     * @param modelAndView 封装了视图和数据，此时尚未跳转页面呢，你可以在这里针对返回的数据和视图信息进行修改
     */
    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
        System.out.println("MyIntercepter01 postHandle......");
    }

    /**
     * 页面已经跳转渲染完毕之后执行
     *
     * @param ex 可以在这里捕获异常
     */
    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
        System.out.println("MyIntercepter01 afterCompletion......");
    }
}
