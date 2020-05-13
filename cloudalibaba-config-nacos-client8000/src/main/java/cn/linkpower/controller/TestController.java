package cn.linkpower.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RefreshScope //必须标注此注解，才能达到刷新的目的
public class TestController {

    //配置文件中不存在，需要从nacos注册中心管理网站上进行获取
    @Value("${config.info}")
    private String configInfo;

    @RequestMapping("/config/getConfigInfo")
    public String getConfigInfo() {
        return configInfo;
    }
}
