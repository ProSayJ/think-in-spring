package prosayj.handwritten.demo.controller;

import prosayj.handwritten.demo.service.IDemoService;
import prosayj.handwritten.mvcframework.annotations.MyAutowired;
import prosayj.handwritten.mvcframework.annotations.MyController;
import prosayj.handwritten.mvcframework.annotations.MyRequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * DemoController
 *
 * @author yangjian
 * @date 2021-05-19
 */
@MyController
@MyRequestMapping("/demo")
public class DemoController {

    @MyAutowired
    private IDemoService demoService;


    /**
     * <a href="http://localhost:8080/demo/query?name=lisi">URL</a>
     */
    @MyRequestMapping("/query")
    public String query(HttpServletRequest request, HttpServletResponse response, String name) {
        return demoService.get(name);
    }
}
