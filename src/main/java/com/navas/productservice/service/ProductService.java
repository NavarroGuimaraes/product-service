package com.navas.productservice.service;

import com.navas.productservice.dto.request.ProductRequest;
import com.navas.productservice.dto.response.ProductResponse;
import com.navas.productservice.mapper.ProductMapper;
import com.navas.productservice.model.Product;
import com.navas.productservice.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class ProductService {

    private final ProductMapper productMapper;
    private final ProductRepository productRepository;

    public ProductResponse createProduct(ProductRequest request) {

        Product product = productMapper.fromProductRequestToProduct(request);

        Product savedEntity = productRepository.save(product);

        return productMapper.fromProductToProductResponse(savedEntity);

    }

    public List<ProductResponse> listAllProducts(String name, BigDecimal price) {
        List<Product> productList = productRepository.findProducts(name, price);
        return productMapper.fromProductToProductResponseList(productList);
    }
}
