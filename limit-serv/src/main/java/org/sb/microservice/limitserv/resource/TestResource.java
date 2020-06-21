package org.sb.microservice.limitserv.resource;

import org.sb.microservice.limitserv.config.Configuration;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestResource {

    private Configuration configuration;

    @Autowired
    public TestResource(Configuration configuration) {
        this.configuration = configuration;
    }

    @GetMapping("/test/{data}")
    public String test(@PathVariable String data) {
        return "Hi " + data;
    }

    @GetMapping("/configurations")
    public Configuration getConfig() {
        return configuration;
    }


}
