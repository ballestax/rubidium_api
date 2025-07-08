package com.rubidium.api.service;

import java.math.BigDecimal;

import org.springframework.stereotype.Service;

import com.github.javafaker.Faker;
import com.rubidium.api.model.Category;
import com.rubidium.api.model.Product;

@Service
public class FakeDataService {

    private final Faker faker = new Faker();

    public Category generateFakeCategory(){
        Category category = new Category();
        category.setName(faker.commerce().department());
        category.setZOrder(1);
        return category;
    }

    public Product generateFakeProduct(){
        Product product = new Product();
        product.setName(faker.commerce().productName());
        product.setCode(faker.code().ean13());
        product.setDescription(faker.lorem().sentence(15));
        product.setPrice(BigDecimal.valueOf(Double.parseDouble(faker.commerce().price().replace(',', '.'))));
        product.setVariable(false);
        product.setEnabled(true);
        return product;
    } 
    
}
