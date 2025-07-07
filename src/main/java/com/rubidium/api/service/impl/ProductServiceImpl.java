package com.rubidium.api.service.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rubidium.api.dto.ProductDto;
import com.rubidium.api.dto.ProductFullDto;
import com.rubidium.api.exception.ResourceNotFoundException;
import com.rubidium.api.mapper.ProductMapper;
import com.rubidium.api.model.Product;
import com.rubidium.api.repository.ProductRepository;
import com.rubidium.api.service.ProductService;


@Service
public class ProductServiceImpl implements ProductService {

    private ProductRepository productRepository;
    @Autowired
    private ProductMapper mapper;

    public ProductServiceImpl(ProductRepository productRepository) {
        super();
        this.productRepository = productRepository;
    }

    @Override
    public Product saveProduct(Product product) {
        return productRepository.save(product);
    }

    @Override
    public List<ProductDto> getAllProducts() {
        return productRepository.findAll()
                .stream()
                .map(product -> mapper.entityToDto(product))
                .collect(Collectors.toList());
    }

    @Override
    public ProductFullDto getProductById(long id) {
        return productRepository.findById(id).map(product -> mapper.productToProductFullDto(product)).orElseThrow(()->
                new ResourceNotFoundException("Product", "id", id));
    }

    @Override
    public Product updateProduct(Product product, long id) {
        Product existingProduct = productRepository.findById(id).orElseThrow(
                () -> new ResourceNotFoundException("Product", "id", id)
        );
        existingProduct.setName(product.getName());
        existingProduct.setDescription(product.getDescription());
        existingProduct.setPrice(product.getPrice());
        existingProduct.setVariable(product.isVariable());
        existingProduct.setEnabled(product.isEnabled());

        productRepository.save(existingProduct);
        return existingProduct;
    }

    @Override
    public void delete(long id) {
        productRepository.findById(id).orElseThrow(() ->
                new ResourceNotFoundException("Product", "Id", id));
        productRepository.deleteById(id);
    }

}
