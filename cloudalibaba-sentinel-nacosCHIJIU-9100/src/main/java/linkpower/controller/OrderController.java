package linkpower.controller;

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
}
