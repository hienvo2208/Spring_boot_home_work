package com.hachiko.bookshop.entties.enums;

public enum PaymentMethod {
    CASH            ("cash"),
    CREDIT_CARD     ("credit card"),
    PAYPAL          ("paypal"),
    CRYPTO_CURRENCY ("crypto currency");
    private String value;

    PaymentMethod(String value) {
        this.value = value;
    }
}
