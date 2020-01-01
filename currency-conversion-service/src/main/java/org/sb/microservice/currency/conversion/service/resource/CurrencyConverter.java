package org.sb.microservice.currency.conversion.service.resource;

import org.sb.microservice.currency.conversion.service.feign.CurrencyExchangeProxy;
import org.sb.microservice.currency.conversion.service.model.CurrencyConversionDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;

@RestController
public class CurrencyConverter {
    @Autowired
    private CurrencyExchangeProxy ceProxy;

    @GetMapping("/currency-converter/from/{from}/to/{to}/quantity/{quantity}")
    public CurrencyConversionDTO convert(@PathVariable String from, @PathVariable String to, @PathVariable BigDecimal quantity) {
        CurrencyConversionDTO currencyConversionDTO = ceProxy.exchange(from, to);
        return new CurrencyConversionDTO(currencyConversionDTO.getId(),
            currencyConversionDTO.getFrom(),
            currencyConversionDTO.getTo(),
            currencyConversionDTO.getFactor(),
            currencyConversionDTO.getQuantity(),
            quantity.multiply(currencyConversionDTO.getFactor()),
            currencyConversionDTO.getPort());
    }
}
