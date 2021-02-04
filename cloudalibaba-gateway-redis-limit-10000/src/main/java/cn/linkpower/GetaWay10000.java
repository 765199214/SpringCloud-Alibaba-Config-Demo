package cn.linkpower;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient // 注册至nacos 如果配置文件中写了配置且引入了nacos-client的依赖，可以不用加
public class GetaWay10000 {
    public static void main(String[] args) {
        SpringApplication.run(GetaWay10000.class,args);
    }
}
