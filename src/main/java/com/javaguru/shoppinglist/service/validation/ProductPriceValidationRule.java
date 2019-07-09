package com.javaguru.shoppinglist.service.validation;

import com.javaguru.shoppinglist.domain.Product;

import java.math.BigDecimal;

public class ProductPriceValidationRule implements ProductValidationRule {
    @Override
    public void validate(Product product) {
        if (product.getPrice().compareTo(BigDecimal.ZERO) < 1) {
            throw new ProductValidationException("Price must be more than 0");
        }
    }
}
