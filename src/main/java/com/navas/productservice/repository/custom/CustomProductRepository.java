package com.navas.productservice.repository.custom;

import com.navas.productservice.model.Product;

import java.math.BigDecimal;
import java.util.List;

public interface CustomProductRepository {

    List<Product> findProducts(String name, BigDecimal price);

}
