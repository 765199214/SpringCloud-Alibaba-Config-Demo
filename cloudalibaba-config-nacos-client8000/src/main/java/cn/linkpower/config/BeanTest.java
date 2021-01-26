package cn.linkpower.config;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 用于测试nacos-config能否动态刷新bean中的属性值；<br/>
 * 结合 http://localhost:8001/getInfo 测试
 */
//@Configuration
//@RefreshScope
public class BeanTest {

    Logger log = LoggerFactory.getLogger(BeanTest.class);

    //@Value("${change.info}")
    private String changeinfo;

   // @Bean
    public TestVo testBean(){
        log.info("===============");
        log.info("---->"+String.valueOf(changeinfo));
        log.info("===============");
        TestVo tv = new TestVo();
        tv.setInfo(changeinfo);
        return tv;
    }
}
