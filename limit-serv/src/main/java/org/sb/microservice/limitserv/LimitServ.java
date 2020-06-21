package org.sb.microservice.limitserv;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class LimitServ {
    public static void main(String[] args) {
        SpringApplication.run(LimitServ.class, args);
    }
}
