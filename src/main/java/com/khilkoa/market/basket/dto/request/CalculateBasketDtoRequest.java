package com.khilkoa.market.basket.dto.request;

import com.khilkoa.market.basket.model.AdditionalInfo;
import com.khilkoa.market.product.model.Product;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CalculateBasketDtoRequest {
    /**
     * Продукты в корзине
     **/
    @NotEmpty(message = "Please fill your basket first")
    private List<Product> products;

    /**
     * Дополнительная информация
     **/
    @NotNull
    private AdditionalInfo additionalInfo;
}
