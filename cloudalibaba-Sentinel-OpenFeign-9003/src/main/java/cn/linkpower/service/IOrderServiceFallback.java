package cn.linkpower.service;

import org.springframework.stereotype.Component;

/**
 * IOrderService  降级处理类
 */
//org.springframework.beans.factory.BeanCreationException:
// Error creating bean with name 'cn.linkpower.service.IOrderService':
// FactoryBean threw exception on object creation; nested exception is java.lang.IllegalStateException:
// No fallback instance of type class cn.linkpower.service.IOrderServiceFallback found for
// feign client nacos-product
@Component
public class IOrderServiceFallback implements IOrderService {

    /**
     * 针对  getOrder的降级处理
     * @param id
     * @return
     */
    @Override
    public String getOrder(String id) {
        return "fallback --- IOrderServiceFallback";
    }
}
