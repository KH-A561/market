package com.khilkoa.market.product.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.Min;

/**
 * Товар
 **/
@Data
@AllArgsConstructor
@NoArgsConstructor
@JsonInclude(JsonInclude.Include.NON_DEFAULT)
public class Product {
    /**
     *  id товара
     **/
    private int id;
    /**
     * Количество товара
     **/
    @Min(value = 1, message = "At least 1 item for each product")
    private int count;
}
