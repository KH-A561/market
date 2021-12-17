package com.khilkoa.market;

import com.khilkoa.market.product.repository.ProductRepository;
import com.khilkoa.market.product.repository.SimpleProductRepository;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration
public class MarketConfiguration {
    @Bean
    public RestTemplate restTemplate() {
        return new RestTemplate();
    }

    @Bean
    public ProductRepository basketRepository() {
        return new SimpleProductRepository(restTemplate());
    }
}
