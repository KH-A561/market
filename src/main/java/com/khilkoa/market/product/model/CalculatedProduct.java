package com.khilkoa.market.product.model;

import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.validation.constraints.Min;

@Data
@EqualsAndHashCode(callSuper = true)
public class CalculatedProduct extends Product {
    /**
     * Сумма по позиции
     **/
    @Min(0)
    private float costByPosition;

    public CalculatedProduct(int id, int count, float costByPosition) {
        super(id, count);
        this.costByPosition = costByPosition;
    }
}

