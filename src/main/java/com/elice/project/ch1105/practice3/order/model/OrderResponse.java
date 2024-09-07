package com.elice.project.ch1105.practice3.order.model;

import lombok.Getter;

@Getter
public class OrderResponse {
    private String orderUuid;
    private boolean success;

    public OrderResponse(String orderUuid, boolean success) {
        this.orderUuid = orderUuid;
        this.success = success;
    }
}
