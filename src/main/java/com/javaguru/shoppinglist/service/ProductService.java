package com.javaguru.shoppinglist.service;

import com.javaguru.shoppinglist.domain.Product;
import com.javaguru.shoppinglist.repository.InMemoryRepository;
import com.javaguru.shoppinglist.service.validation.ProductValidationService;
import com.javaguru.shoppinglist.service.validation.Validator;

import java.math.BigDecimal;

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

    public void deleteProductById(Long id) {
        repository.removeProductById(id);
    }

    public void setDiscountById(long id, BigDecimal discount) {
        validationService.ProductValidateDiscount(discount);
        repository.getProductById(id).setDiscount(discount);
    }

    public void changeNameById(long id, String newName) {
        repository.getProductById(id).setName(newName);
    }

    public void setPriceById(long id, BigDecimal newPrice) {
        repository.getProductById(id).setPrice(newPrice);
    }

    public void changeProductDescription(long id, String newDescription) {
        repository.getProductById(id).setDescription(newDescription);
    }
}