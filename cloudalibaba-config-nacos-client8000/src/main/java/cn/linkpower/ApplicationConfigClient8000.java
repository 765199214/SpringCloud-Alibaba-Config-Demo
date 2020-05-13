package cn.linkpower;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class ApplicationConfigClient8000 {
    public static void main(String[] args) {
        SpringApplication.run(ApplicationConfigClient8000.class,args);
    }
}
