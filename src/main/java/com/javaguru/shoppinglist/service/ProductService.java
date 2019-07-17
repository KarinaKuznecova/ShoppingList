package com.javaguru.shoppinglist.service;

import com.javaguru.shoppinglist.domain.Product;
import com.javaguru.shoppinglist.repository.InMemoryRepository;
import com.javaguru.shoppinglist.service.validation.ProductValidationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;

@Service
public class ProductService {
    private InMemoryRepository repository;
    private ProductValidationService validationService;

    @Autowired
    public ProductService(InMemoryRepository repository, ProductValidationService validationService) {
        this.repository = repository;
        this.validationService = validationService;
    }

    @Transactional
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
        validationService.productValidateDiscount(discount, repository.getProductById(id));
        repository.getProductById(id).setDiscount(discount);
    }

    public void changeNameById(long id, String newName) {
        validationService.productValidateChangeName(newName);
        repository.getProductById(id).setName(newName);
    }

    public void setPriceById(long id, BigDecimal newPrice) {
        validationService.productValidateChangePrice(newPrice);
        repository.getProductById(id).setPrice(newPrice);
    }

    public void changeProductDescription(long id, String newDescription) {
        repository.getProductById(id).setDescription(newDescription);
    }
}