package cn.linkpower.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class TestController {
    @Value("${server.port}")
    private String port;

    @Autowired
    private RestTemplate restTemplate;

    @RequestMapping("/consumer/nacos/{id}")
    public String getPayMent(@PathVariable("id") String id) {
        //return "nacos registry,server port:"+port+" \t id:"+id;
        //拉取服务信息
        String reqUrl = "http://nacos-product/product/getProduct/"+id;
        String result = restTemplate.getForObject(reqUrl, String.class);
        return "consumer get result --- >"+result;
    }
}
