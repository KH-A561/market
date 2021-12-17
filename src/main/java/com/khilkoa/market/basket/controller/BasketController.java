package com.khilkoa.market.basket.controller;

import com.khilkoa.market.basket.dto.request.CalculateBasketDtoRequest;
import com.khilkoa.market.basket.dto.response.CalculatedBasketDtoResponse;
import com.khilkoa.market.basket.service.BasketService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Контроллер Корзин
 **/
@RestController
@RequestMapping("/api/basket")
public class BasketController {
    private final BasketService basketService;

    public BasketController(BasketService basketService) {
        this.basketService = basketService;
    }

    @PostMapping(consumes = "application/json", produces = "application/json")
    public CalculatedBasketDtoResponse calculateBasketCost(@RequestBody CalculateBasketDtoRequest request) {
        return basketService.calculateBasket(request);
    }
}
