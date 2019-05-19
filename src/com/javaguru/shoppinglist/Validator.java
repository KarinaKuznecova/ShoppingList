package com.javaguru.shoppinglist;

import java.math.BigDecimal;

class Validator {

    boolean validateProduct(Product product) {
        return validateMinLength(product.getName()) &&
                validateMaxLength(product.getName()) &&
                validateMinDiscount(product.getDiscount()) &&
                validateMaxDiscount(product.getDiscount()) &&
                validateMinPrice(product.getPrice());
    }

    boolean validatePrice(BigDecimal price) {
        return price.doubleValue() >= 0;
    }

    boolean validateName(String name) {
        return name.length() >= 3 && name.length() <= 30;
    }

    boolean validateDiscount(BigDecimal discount) {
        return discount.doubleValue() >=0 && discount.doubleValue() <=80;
    }

    private boolean validateMinLength(String name) {
        if (name.length() >= 3) {
            return true;
        }
        throw new ValidationException("Name length should be more than 3 symbols");
    }

    private boolean validateMaxLength(String name) {
        if (name.length() <= 30) {
            return true;
        }
        throw new ValidationException("Name length should be less than 30 symbols");
    }

    private boolean validateMinDiscount(BigDecimal discount) {
        if (discount.doubleValue() >= 0) {
            return true;
        }
        throw new ValidationException("Discount must be more than 0%");
    }

    private boolean validateMaxDiscount(BigDecimal discount) {
        if (discount.doubleValue() <= 80) {
            return true;
        }
        throw new ValidationException("Discount must be less than 80%");
    }

    private boolean validateMinPrice(BigDecimal price) {
        if (price.doubleValue() >= 0) {
            return true;
        }
        throw new ValidationException("Price must be more than 0");
    }
}
