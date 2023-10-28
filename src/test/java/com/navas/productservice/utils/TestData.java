package com.navas.productservice.utils;

import com.navas.productservice.dto.request.ProductRequest;

import java.math.BigDecimal;

public class TestData {

    public static ProductRequest gimmeASuccessfullProductRequest() {
        return ProductRequest
                .builder()
                .name("Test")
                .description("Test description")
                .price(new BigDecimal("30.0"))
                .build();

    }
}
