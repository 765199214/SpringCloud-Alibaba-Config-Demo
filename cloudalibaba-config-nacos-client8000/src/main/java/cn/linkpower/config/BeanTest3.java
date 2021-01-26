package cn.linkpower.config;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 测试类上无 @RefreshScope 修饰时，此时的数据是否能动态刷新
 */
//@Configuration
public class BeanTest3 {

    Logger log = LoggerFactory.getLogger(BeanTest3.class);

    // :后表示如果没有，则默认为 ""
   // @Value("${change.info:}")
    private String changeinfo;

   // @Bean
   // @RefreshScope
    public TestVo testBean(){
        log.info("===============");
        log.info("---->"+String.valueOf(changeinfo));
        log.info("===============");
        TestVo tv = new TestVo();
        tv.setInfo(changeinfo);
        return tv;
    }
}
