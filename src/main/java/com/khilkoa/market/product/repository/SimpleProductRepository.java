package com.khilkoa.market.product.repository;

import com.khilkoa.market.basket.dto.request.CalculateProductsDtoRequest;
import com.khilkoa.market.basket.dto.response.CalculatedProductsDtoResponse;
import com.khilkoa.market.basket.model.AdditionalInfo;
import com.khilkoa.market.product.model.CalculatedProduct;
import com.khilkoa.market.product.model.Product;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;

import java.util.List;
import java.util.Optional;

/**
 * Реализация репозитория через обращение к микроконтроллеру с использованием кэша
 **/
@Slf4j
public class SimpleProductRepository implements ProductRepository {
    public static final String CALCULATION_MICROSERVICE_URI = "https://calculation.microservice.uri/api/calculate/";

    private final RestTemplate restTemplate;

    public SimpleProductRepository(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    @Override
    @Cacheable("costs")
    public List<CalculatedProduct> calculateProductsCost(List<Product> products, AdditionalInfo additionalInfo) {
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        HttpEntity<CalculateProductsDtoRequest> requestEntity = new HttpEntity<>(
                new CalculateProductsDtoRequest(products, additionalInfo),
                headers
        );
        try {
            log.debug("Making http request for calculateProductsCost");
            CalculatedProductsDtoResponse response = restTemplate.postForObject(
                    CALCULATION_MICROSERVICE_URI,
                    requestEntity,
                    CalculatedProductsDtoResponse.class
            );
            return Optional.ofNullable(response).map(CalculatedProductsDtoResponse::getCalculatedProducts)
                    .orElseThrow(() -> new RuntimeException("Empty response"));
        } catch (RestClientException e) {
            throw new RuntimeException(
                    String.format("There's a problem with http connection: %s", e.getLocalizedMessage())
            );
        }
    }
}
