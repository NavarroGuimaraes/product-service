package com.navas.productservice.controller;

import com.navas.productservice.dto.request.ProductRequest;
import com.navas.productservice.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/products")
public class ProductController {

    private final ProductService productService;

    @PostMapping
    public ResponseEntity<?> createProduct(@RequestBody ProductRequest productRequest) {

        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(productService.createProduct(productRequest));

    }

    @GetMapping
    public ResponseEntity<?> listAllProducts(
            @RequestParam(required = false) String name,
            @RequestParam(required = false) BigDecimal price) {

        // TODO implement filter
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(productService.listAllProducts(name, price));

    }

}
