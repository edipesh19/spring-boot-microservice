package org.sb.microservice.currency.exchange.service.repository;

import org.sb.microservice.currency.exchange.service.model.ExchangeValueDTO;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ExchangeValueRepository extends JpaRepository<ExchangeValueDTO, Long> {
    ExchangeValueDTO findByFromAndTo(String from, String to);
}
