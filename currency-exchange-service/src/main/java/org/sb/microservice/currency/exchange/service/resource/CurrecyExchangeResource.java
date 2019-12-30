package org.sb.microservice.currency.exchange.service.resource;

import org.sb.microservice.currency.exchange.service.model.ExchangeValueDTO;
import org.sb.microservice.currency.exchange.service.repository.ExchangeValueRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;

@RestController
public class CurrecyExchangeResource {

    @Autowired
    private Environment env;

    @Autowired
    private ExchangeValueRepository exchangeValueRepository;

    @GetMapping("/currency-exchange/from/{from}/to/{to}")
    public ExchangeValueDTO exchange(@PathVariable String from, @PathVariable String to){
        ExchangeValueDTO exchangeValue =  exchangeValueRepository.findByFromAndTo(from, to);
        exchangeValue.setPort(Integer.parseInt(env.getProperty("local.server.port")));
        return exchangeValue;
//        return ExchangeValueDTO.builder()
//            .id(1000)
//            .from(from)
//            .to(to)
//            .factor(BigDecimal.valueOf(71))
//            .port(Integer.parseInt(env.getProperty("local.server.port")))
//            .build();
    }
}
