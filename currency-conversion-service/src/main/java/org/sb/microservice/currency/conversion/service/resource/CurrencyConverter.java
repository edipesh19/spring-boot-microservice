package org.sb.microservice.currency.conversion.service.resource;

import org.sb.microservice.currency.conversion.service.feign.CurrencyExchangeProxy;
import org.sb.microservice.currency.conversion.service.model.CurrencyConversionDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

@RestController
public class CurrencyConverter {
    @Autowired
    private CurrencyExchangeProxy ceProxy;

    @GetMapping("/currency-converter/from/{from}/to/{to}/quantity/{quantity}")
    public CurrencyConversionDTO convert(@PathVariable String from, @PathVariable String to, @PathVariable BigDecimal quantity) {
        CurrencyConversionDTO currencyConversionDTO = ceProxy.exchange(from,to);
        return new CurrencyConversionDTO(currencyConversionDTO.getId(),
            currencyConversionDTO.getFrom(),
            currencyConversionDTO.getTo(),
            currencyConversionDTO.getFactor(),
            currencyConversionDTO.getQuantity(),
            quantity.multiply(currencyConversionDTO.getFactor()),
            currencyConversionDTO.getPort());
    }

    @GetMapping("/currency-converter-feign/from/{from}/to/{to}/quantity/{quantity}")
    public CurrencyConversionDTO convertFeign(@PathVariable String from, @PathVariable String to, @PathVariable BigDecimal quantity) {
        Map<String, String> uriMap = new HashMap<>();
        uriMap.put("from", from);
        uriMap.put("to", to);
        ResponseEntity<CurrencyConversionDTO> responseEntity = new RestTemplate().getForEntity("http://localhost:8000//currency-exchange/from/{from}/to/{to}", CurrencyConversionDTO.class, uriMap);
        CurrencyConversionDTO currencyConversionDTO = responseEntity.getBody();
        return new CurrencyConversionDTO(currencyConversionDTO.getId(),
            currencyConversionDTO.getFrom(),
            currencyConversionDTO.getTo(),
            currencyConversionDTO.getFactor(),
            currencyConversionDTO.getQuantity(),
            quantity.multiply(currencyConversionDTO.getFactor()),
            currencyConversionDTO.getPort());
    }
}
