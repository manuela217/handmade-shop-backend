package com.handmade.ecommerce.backend.domain.model;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class OrderProduct {
    private Integer id;
    private Integer quantity;
    private BigDecimal price;
    private Integer productId;

    public BigDecimal getTotalItem() {
        return this.price.multiply(BigDecimal.valueOf(quantity));
    }
}
