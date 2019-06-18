package com.javaguru.shoppinglist.service;

import com.javaguru.shoppinglist.domain.Product;
import com.javaguru.shoppinglist.repository.InMemoryRepository;
import com.javaguru.shoppinglist.service.validation.ProductValidationService;

public class ProductService {
    private InMemoryRepository repository;
    private ProductValidationService validationService;

    public ProductService(InMemoryRepository repository, ProductValidationService validationService) {
        this.repository = repository;
        this.validationService = validationService;
    }

    public Long createProduct(Product product) {
        validationService.validate(product);
        Product createdProduct = repository.add(product);
        return createdProduct.getId();
    }

    public Product getProductById(Long id) {
        return repository.getProductById(id);
    }

    public void printAll() {
        repository.printAll();
    }

    public void deleteById(Long id) {
        repository.removeProductById(id);
    }

}
