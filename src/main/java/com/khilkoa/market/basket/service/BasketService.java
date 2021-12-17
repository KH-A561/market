package com.khilkoa.market.basket.service;

import com.khilkoa.market.basket.dto.request.CalculateBasketDtoRequest;
import com.khilkoa.market.basket.dto.response.CalculatedBasketDtoResponse;
import com.khilkoa.market.product.repository.ProductRepository;
import com.khilkoa.market.product.model.CalculatedProduct;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Сервис по работе с корзиной
 **/
@Service
public class BasketService {
    private final ProductRepository productRepository;

    public BasketService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    /**
     * Расчёт стоимости корзины пользователя
     * Если в кэше нет информации о ценах товаров, то берём информацию из внешнего микросервиса по http
     **/
    public CalculatedBasketDtoResponse calculateBasket(CalculateBasketDtoRequest request) {
        List<CalculatedProduct> calculatedProducts = productRepository.calculateProductsCost(
                request.getProducts(),
                request.getAdditionalInfo()
        );
        // из ТЗ не совсем было понятно, что подразумевается под "суммой по позиции", поэтому принял, что это
        // стоимость товара * количество товара в корзине, а не за единицу
        return new CalculatedBasketDtoResponse(
                calculatedProducts,
                calculatedProducts.stream().map(CalculatedProduct::getCostByPosition).reduce(0.f, Float::sum)
        );
    }
}
