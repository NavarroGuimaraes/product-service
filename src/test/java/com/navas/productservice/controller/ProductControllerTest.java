package com.navas.productservice.controller;

import com.navas.productservice.dto.request.ProductRequest;
import com.navas.productservice.dto.response.ProductResponse;
import com.navas.productservice.service.ProductService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.math.BigDecimal;

import static com.navas.productservice.utils.TestData.gimmeASuccessfullProductRequest;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class ProductControllerTest {

    @InjectMocks
    private ProductController productController;

    @Mock
    private ProductService productService;

    @Test
    void createProduct() {

        ProductRequest productRequest = gimmeASuccessfullProductRequest();

        ProductResponse expectedProductResponse = ProductResponse
                .builder()
                .id("a734jas1832")
                .name("Test")
                .description("Test description")
                .price(new BigDecimal("30.0"))
                .build();

        when(productService.createProduct(any(ProductRequest.class))).thenReturn(expectedProductResponse);

        ResponseEntity<?> response = productController.createProduct(productRequest);

        verify(productService, times(1)).createProduct(productRequest);
        assertEquals(HttpStatus.CREATED, response.getStatusCode());
        assertEquals(expectedProductResponse, response.getBody());

    }

    @Test
    void listAllProducts() {

        String name = "Iphone 13";
        BigDecimal price = new BigDecimal("3499");

        ResponseEntity<?> response = productController.listAllProducts(name, price);

        // TODO continue the test

    }
}