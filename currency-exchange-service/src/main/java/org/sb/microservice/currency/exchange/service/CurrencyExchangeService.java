package org.sb.microservice.currency.exchange.service;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class CurrencyExchangeService {
    public static void main(String[] args) {
        SpringApplication.run(CurrencyExchangeService.class, args);
    }
}
