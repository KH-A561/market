package com.khilkoa.market.basket.dto.request;

import com.khilkoa.market.basket.model.AdditionalInfo;
import com.khilkoa.market.product.model.Product;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CalculateProductsDtoRequest {
    /**
     * Продукты в корзине
     **/
    private List<Product> products;

    /**
     * Дополнительная информация
     **/
    private AdditionalInfo additionalInfo;
}
