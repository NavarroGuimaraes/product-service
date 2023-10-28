package com.navas.productservice.mapper;

import com.navas.productservice.dto.request.ProductRequest;
import com.navas.productservice.dto.response.ProductResponse;
import com.navas.productservice.model.Product;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel="spring")
public interface ProductMapper {

    Product fromProductRequestToProduct(ProductRequest request);

    ProductResponse fromProductToProductResponse(Product product);

    List<ProductResponse> fromProductToProductResponseList(List<Product> productList);

}
