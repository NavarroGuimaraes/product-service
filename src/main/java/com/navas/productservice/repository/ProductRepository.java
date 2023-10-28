package com.navas.productservice.repository;

import com.navas.productservice.model.Product;
import com.navas.productservice.repository.custom.CustomProductRepository;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface ProductRepository extends MongoRepository<Product, String>, CustomProductRepository {

}
