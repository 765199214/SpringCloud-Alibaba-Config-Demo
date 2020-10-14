package linkpower.controller;

import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.sun.deploy.security.BlockedException;
import linkpower.service.IOrderService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class OrderController {

    Logger log = LoggerFactory.getLogger(OrderController.class);

    @Autowired
    private IOrderService oserService;

    @RequestMapping("/product/getProduct/{id}")
    public String getOrder(@PathVariable("id") String id){
        log.info("----getOrder---- id={}",id);
        return oserService.getOrder(id);
    }

    // 测试两个流控配置持久化
    @SentinelResource(value = "test",blockHandler ="fallbackhandler",fallback = "fallback") //采取sentinelresources测试
    @RequestMapping("/product/getProduct2/{id}")
    public String getOrder2(@PathVariable("id") String id){
        log.info("----getOrder2---- id={}",id);
        return oserService.getOrder(id);
    }

    public String fallbackhandler(String id,BlockedException e){
        log.info("----getOrder2--fallbackhandler");
        return "SentinelResource test fallbackhandler  请求降级！！";
    }
    public String fallback(String id){
        log.info("----getOrder2--fallback");
        return "SentinelResource test  fallback  请求降级！！";
    }

}
