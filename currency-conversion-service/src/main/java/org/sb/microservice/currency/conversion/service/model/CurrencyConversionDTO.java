package org.sb.microservice.currency.conversion.service.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class CurrencyConversionDTO {
    private Long id;
    private String from;
    private String to;
    private BigDecimal factor;
    private BigDecimal quantity;
    private BigDecimal calculatedAmount;
    private int port;
}
