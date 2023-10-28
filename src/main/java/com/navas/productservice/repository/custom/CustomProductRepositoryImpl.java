package com.navas.productservice.repository.custom;

import com.navas.productservice.model.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;

import java.math.BigDecimal;
import java.util.List;

public class CustomProductRepositoryImpl implements CustomProductRepository {

    @Autowired
    private MongoTemplate mongoTemplate;

    @Override
    public List<Product> findProducts(String name, BigDecimal price) {

        Query mongoQuery = new Query();

        if (name != null && !name.isEmpty()) {
            mongoQuery.addCriteria(Criteria.where("name").regex(name, "i")); // "i" for case-insensitive matching
        }

        if (price != null) {
            mongoQuery.addCriteria(Criteria.where("price").is(price));
        }

        return mongoTemplate.find(mongoQuery, Product.class);

    }
}
