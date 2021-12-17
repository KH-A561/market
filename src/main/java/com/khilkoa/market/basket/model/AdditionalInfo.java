package com.khilkoa.market.basket.model;

import com.khilkoa.market.user.model.PaymentType;
import lombok.Data;
import org.springframework.stereotype.Component;

import javax.validation.constraints.NotNull;

/**
 * Дополнительная информация
 **/
@Data
public class AdditionalInfo {
    /**
     * Тип оплаты
     **/
    @NotNull
    private PaymentType paymentType;
    /**
     * id адреса из адресной книги пользователя
     **/
    private Integer addressId;
}
