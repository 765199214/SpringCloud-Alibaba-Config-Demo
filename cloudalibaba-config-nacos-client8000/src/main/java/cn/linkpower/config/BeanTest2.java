package cn.linkpower.config;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@RefreshScope
public class BeanTest2 {

    Logger log = LoggerFactory.getLogger(BeanTest2.class);

    @Value("${change.info}")
    private String changeinfo;

    @Bean
    @RefreshScope
    public TestVo testBean(){
        log.info("===============");
        log.info("---->"+String.valueOf(changeinfo));
        log.info("===============");
        TestVo tv = new TestVo();
        tv.setInfo(changeinfo);
        return tv;
    }
}
