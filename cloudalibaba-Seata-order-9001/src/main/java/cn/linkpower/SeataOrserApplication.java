package cn.linkpower;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication(exclude = DataSourceAutoConfiguration.class) //移除自动数据源配置，采取自定义数据源配置方式
@EnableFeignClients  //使用激活feign
@EnableDiscoveryClient
public class SeataOrserApplication {
    public static void main(String[] args) {
        SpringApplication.run(SeataOrserApplication.class);
    }
}
