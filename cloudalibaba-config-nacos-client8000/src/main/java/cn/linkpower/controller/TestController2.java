package cn.linkpower.controller;

import cn.linkpower.config.TestVo;
import cn.linkpower.config.TestVo2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController2 {

    @Autowired
    private TestVo beanTest;

    @Autowired
    private TestVo2 testVo2;

    @GetMapping("/getInfo")
    public String getBeanTestInfo(){
        return "--->"+beanTest.getInfo();
    }

    @GetMapping("/getInfo2")
    public String getBeanTestInfo2(){
        return "--->"+testVo2.getInfo();
    }
}
