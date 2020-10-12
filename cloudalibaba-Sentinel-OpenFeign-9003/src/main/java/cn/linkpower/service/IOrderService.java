package cn.linkpower.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@FeignClient(value = "nacos-product",fallback = IOrderServiceFallback.class)
public interface IOrderService {

    @RequestMapping("/product/getProduct/{id}")
    public String getOrder(@PathVariable("id") String id);
}
