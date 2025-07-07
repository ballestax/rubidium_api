package com.rubidium.api.service;

import java.util.List;

import com.rubidium.api.model.Product;

public interface ProductService {

    Product saveProduct(Product product);

    List<com.rubidium.api.dto.ProductDto> getAllProducts();

    com.rubidium.api.dto.ProductFullDto getProductById(long id);

    Product updateProduct(Product product, long id);

    void delete(long id);

}
