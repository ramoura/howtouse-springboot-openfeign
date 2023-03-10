package io.ramoura.howtouse.springboot.openfign.config;

import feign.Logger;
import feign.slf4j.Slf4jLogger;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Slf4j
@Configuration
public class FeignConfiguration {

    @Bean
    public Logger getDefultFeignLogger() {
        return new Slf4jLogger();
    }

}
