package org.example;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class OrderCreateRequest {
    private String productName;

    private int quantity;

    private int price;

    public OrderEntity toOrder() {
        return OrderEntity.builder()
                .productName(productName)
                .quantity(quantity)
                .price(price)
                .build();
    }
}
