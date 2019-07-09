package com.javaguru.shoppinglist.service.validation;

import com.javaguru.shoppinglist.domain.Product;

import java.math.BigDecimal;
import java.util.HashSet;
import java.util.Set;

public class ProductValidationService {

    private Set<ProductValidationRule> validationRules = new HashSet<>();

    public ProductValidationService() {
        validationRules.add(new ProductNameValidationRule());
        validationRules.add(new ProductPriceValidationRule());
    }

    public void validate(Product product) {
        validationRules.forEach(s -> s.validate(product));
    }

    public void productValidateDiscount(BigDecimal discount) {
        BigDecimal maxDiscount = new BigDecimal(80);
        if (discount.compareTo(BigDecimal.ZERO) < 0 || discount.compareTo(maxDiscount) > 0) {
            throw new ProductValidationException("Discount must be more than 0% and less than 80%");
        }
    }

    public void productValidateChangeName(String name) {
        if (name.length() < 3 || name.length() > 30) {
            throw new ProductValidationException("Name length should be more than 3 symbols and less than 30");
        }
    }

    public void productValidateChangePrice(BigDecimal price) {
        if (price.compareTo(BigDecimal.ZERO) <= 0) {
            throw new ProductValidationException("Price must be more than 0");
        }
    }
}
