package com.khilkoa.market.product.repository;

import com.khilkoa.market.basket.model.AdditionalInfo;
import com.khilkoa.market.product.model.CalculatedProduct;
import com.khilkoa.market.product.model.Product;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Хранилище продуктов
 **/
@Repository
public interface ProductRepository {
    /**
     * Получаем цену продуктов
     **/
    List<CalculatedProduct> calculateProductsCost(List<Product> products, AdditionalInfo additionalInfo);
}
