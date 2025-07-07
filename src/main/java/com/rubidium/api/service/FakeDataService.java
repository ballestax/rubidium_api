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
        category.setName(faker.food().dish());
        category.setZOrder(1);
        return category;
    }

    public Product generateFakeProduct(){
        Product product = new Product();
        product.setName(faker.food().fruit());
        product.setCode(faker.code().asin());
        product.setDescription(faker.lorem().sentence(15));
        product.setPrice(new BigDecimal(5000));
        product.setVariable(false);
        product.setEnabled(true);
        return product;
    } 
    
}
