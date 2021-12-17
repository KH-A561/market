package com.khilkoa.market.basket.dto.response;

import com.khilkoa.market.product.model.CalculatedProduct;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CalculatedProductsDtoResponse {
    private List<CalculatedProduct> calculatedProducts;
}
