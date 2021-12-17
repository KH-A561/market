package com.khilkoa.market.basket.dto.response;

import com.khilkoa.market.product.model.CalculatedProduct;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotEmpty;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CalculatedBasketDtoResponse {
    /**
     * Продукты с рассчитанной стоимостью
     **/
    @NotEmpty
    private List<CalculatedProduct> calculatedProducts;
    /**
     * Общая сумма
     **/
    private float fullCost;
}
