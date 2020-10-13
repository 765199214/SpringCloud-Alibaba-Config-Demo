package linkpower.config;

import com.alibaba.csp.sentinel.adapter.servlet.CommonFilter;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class FilterContextConfig {
    /**
     * 1、Sentinel 从 1.6.3版本开始，Sentinel Web Filter 默认收敛所有URL的入口Context，因此链路限流不生效。
     * 2、1.7.0版本开始，官方在CommomFilter中引入了一个WEB_CONTEXT_UNIFY参数，用于控制是否收敛context。默认为true(默认收敛所有)，配置为false则可根据不同URL进行链路的限流操作。
     * 3、Spring Cloud Alibaba 在2.1.1.RELEASE版本后，可以根据配置spring.cloud.sentinel.filter.enabled: false来关闭自动收敛。
     * @return
     */
    @Bean
    public FilterRegistrationBean sentinelFilterRegistration(){
        FilterRegistrationBean registrationBean = new FilterRegistrationBean();
        registrationBean.setFilter(new CommonFilter());
        registrationBean.addUrlPatterns("/*");
        //入口资源关闭聚合
        // 1.7.0版本开始，此参数默认为true，表示收敛所有URL的入口Context，因此链路限流不生效
        registrationBean.addInitParameter(CommonFilter.WEB_CONTEXT_UNIFY,"false");
        registrationBean.setName("sentinelFilter");
        registrationBean.setOrder(1);
        return registrationBean;
    }
}
