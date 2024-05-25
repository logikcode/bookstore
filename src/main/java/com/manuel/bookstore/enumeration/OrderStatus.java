package com.manuel.bookstore.enumeration;

import lombok.Data;
import lombok.Getter;

@Getter
public enum OrderStatus {

    PAID("Paid", "00"),
    UNPAID("Payment not yet made", "01"),
    AWAITING_SHIPPING("Order awaiting shipment", "02"),
    DELIVERED("Order delivered", "20");

    private String description;
    private String code;

    OrderStatus(String description, String code) {
        this.description = description;
        this.code = code;
    }


}
