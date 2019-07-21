package com.javaguru.shoppinglist.service;

import com.javaguru.shoppinglist.domain.Product;
import com.javaguru.shoppinglist.repository.ProductRepository;
import com.javaguru.shoppinglist.service.validation.ProductValidationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;

@Component
public class ProductService {
    private ProductRepository repository;
    private ProductValidationService validationService;

    @Autowired
    public ProductService(ProductRepository repository, ProductValidationService validationService) {
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
        return repository.getProductById(id).orElseThrow(() ->
                new IllegalArgumentException("Product with id " + id + " not found"));
    }

    public void printAll() {
        repository.printAll();
    }

    public void deleteProductById(Long id) {
        repository.removeProductById(id);
    }

    public void setDiscountById(Long id, BigDecimal discount) {
        validationService.productValidateDiscount(discount, getProductById(id));
        repository.changeDiscount(id, discount);
    }

    public void setPriceById(Long id, BigDecimal price) {
        validationService.productValidateChangePrice(price);
        repository.changePrice(id, price);
    }

    public void changeProductDescription(long id, String description) {
        repository.changeDescription(id, description);
    }

    public void changeNameById(long id, String name) {
        validationService.productValidateChangeName(name);
        repository.changeName(id, name);
    }

    public void removeAllProducts() {
        repository.removeAllProducts();
    }

    public long getStorageSize() {
        return repository.getStorageSize();
    }

}