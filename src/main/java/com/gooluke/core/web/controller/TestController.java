package com.gooluke.core.web.controller;

import com.gooluke.core.common.utils.CoreDateUtils;
import com.gooluke.core.common.utils.CoreHttpUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author 咕噜科
 * ClassName: TestController
 * date: 2023-06-10 15:53
 * Description:
 * version 1.0
 */
@RestController
@RequestMapping("/test")
public class TestController {

    @Autowired
    private CoreHttpUtils httpUtils;

    @Autowired
    private CoreDateUtils dateUtils;

    @RequestMapping("/http")
    public Object testHttp() {
        return httpUtils.getForObject("http://localhost:1702/gooluke-admin/test/http",null,String.class);
    }

    @RequestMapping("/date")
    public void testDateUtil(String date ,String format) {
        dateUtils.String2date(date,format);
    }
}
