package com.khilkoa.market.basket.service;

import com.khilkoa.market.basket.dto.request.CalculateBasketDtoRequest;
import com.khilkoa.market.basket.dto.response.CalculatedBasketDtoResponse;
import com.khilkoa.market.basket.model.AdditionalInfo;
import com.khilkoa.market.product.repository.SimpleProductRepository;
import com.khilkoa.market.product.model.CalculatedProduct;
import com.khilkoa.market.product.model.Product;
import com.khilkoa.market.user.model.PaymentType;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

@SpringBootTest
class BasketServiceTest {
    @Mock
    private SimpleProductRepository basketRepository;

    @InjectMocks
    private BasketService basketService;

    @Test
    public void whenGettingCalculateBasketRequest_thenReturnCalculatedBasketResponse() {
        AdditionalInfo additionalInfo = new AdditionalInfo();
        additionalInfo.setPaymentType(PaymentType.VISA);

        List<Product> products = Arrays.asList(
                new Product(1, 5),
                new Product(2, 3)
        );
        List<CalculatedProduct> calculatedProducts = Arrays.asList(
                new CalculatedProduct(1, 5, 100.f),
                new CalculatedProduct(2, 3, 10000.f)
        );

        CalculateBasketDtoRequest request = new CalculateBasketDtoRequest(products, additionalInfo);
        CalculatedBasketDtoResponse response = new CalculatedBasketDtoResponse(
                calculatedProducts,
                calculatedProducts.stream().map(CalculatedProduct::getCostByPosition).reduce(0.f, Float::sum)
        );

        when(basketRepository.calculateProductsCost(products, additionalInfo)).thenReturn(calculatedProducts);

        assertEquals(basketService.calculateBasket(request), response);
        Mockito.verify(basketRepository).calculateProductsCost(products, additionalInfo);
    }
}