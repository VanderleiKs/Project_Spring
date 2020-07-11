package com.project.spring.entities.enuns;

public enum OrderStatus {

    WAITING_PAYMENT(1),
    PAID(2),
    SHIPPED(3),
    DELIVERED(4),
    CANCELED(5);

    private Integer code;

    private OrderStatus(Integer code) {
        this.code = code;
    }

    public int getCode() {
        return code;
    }

    public static OrderStatus valueOf(int code) {
        for (OrderStatus order : OrderStatus.values()) {
            if (order.getCode() == code) {
                return order;
            }
        }throw new IllegalStateException("OrderStatus Inválid");

    }
}