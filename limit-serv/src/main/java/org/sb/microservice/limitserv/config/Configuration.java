package org.sb.microservice.limitserv.config;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Component
@ConfigurationProperties("limit-service")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Configuration {
    private int maximum;
    private int minimum;
}
