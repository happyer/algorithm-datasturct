package com.chauncy.mvctest;

import com.chauncy.mvcframework.anotation.MyAutowired;
import com.chauncy.mvcframework.anotation.MyController;
import com.chauncy.mvcframework.anotation.MyRequestMapping;
import com.chauncy.mvcframework.anotation.MyRequestParam;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by chauncy on 2019/3/26.
 */
@MyController
@MyRequestMapping("/demo")
public class TestController {


    @MyAutowired
    private TestService testService;

    @MyRequestMapping("/test.json")
    public void test(HttpServletRequest request, HttpServletResponse response) {
        String ret = testService.doTest();
        try {
            response.getWriter().write(ret);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @MyRequestMapping("/testParam.json")
    public void testParam(HttpServletRequest request,
                          HttpServletResponse response,
                          @MyRequestParam("param") String param) {
        try {
            response.getWriter().write(param);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
