package com.chauncy.mvctest;

import com.chauncy.mvcframework.anotation.MyService;

/**
 * Created by chauncy on 2019/3/26.
 */
@MyService
public class TestService {
    public String doTest() {
        return "Hello World1";
    }
}
