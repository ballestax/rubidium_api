package com.rubidium.api.service;

import org.springframework.stereotype.Service;

import com.rubidium.api.repository.CategoryRepository;
import com.rubidium.api.repository.ProductRepository;

@Service
public class DataPopulationService {
    
    private CategoryRepository categoryRepository;
    private ProductRepository productRepository;
    private FakeDataService fakeDataService;

    public DataPopulationService(ProductRepository productRepository, CategoryRepository categoryRepository, FakeDataService fakeDataService) {
        this.productRepository = productRepository;
        this.categoryRepository = categoryRepository;
        this.fakeDataService = fakeDataService;
    }

    public void populateCategories(int numberOfCategories) {
        for (int i = 0; i < numberOfCategories; i++) {
            categoryRepository.save(fakeDataService.generateFakeCategory());
        }
    }

    public void populateProducts(int numberOfProducts) {
        for (int i = 0; i < numberOfProducts; i++) {
            productRepository.save(fakeDataService.generateFakeProduct());
        }
    }
   
}
