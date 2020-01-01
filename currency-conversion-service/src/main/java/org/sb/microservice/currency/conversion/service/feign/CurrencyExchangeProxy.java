package org.sb.microservice.currency.conversion.service.feign;

import org.sb.microservice.currency.conversion.service.model.CurrencyConversionDTO;
import org.springframework.cloud.netflix.ribbon.RibbonClient;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "currency-exchange-service")
@RibbonClient(name = "currency-exchange-service")
public interface CurrencyExchangeProxy {
    @GetMapping("/currency-exchange/from/{from}/to/{to}")
    CurrencyConversionDTO exchange(@PathVariable("from") String from, @PathVariable("to") String to);
}
