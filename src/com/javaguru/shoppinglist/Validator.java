package com.javaguru.shoppinglist;

import java.math.BigDecimal;

class Validator {

    boolean validateProduct(Product product) {
        return validateName(product.getName()) &&
                validateDiscount(product.getDiscount()) &&
                validatePrice(product.getPrice());
    }

    boolean validateName(String name) {
        if (name.length() >= 3 && name.length() <= 30) {
            return true;
        }
        throw new ValidationException("Name length should be more than 3 symbols and less than 30");
    }

    boolean validateDiscount(BigDecimal discount) {
        BigDecimal maxDiscount = new BigDecimal(80);
        if (discount.compareTo(BigDecimal.ZERO) >= 0 && discount.compareTo(maxDiscount) <=0) {
            return true;
        }
        throw new ValidationException("Discount must be more than 0% and less than 80%");
    }

    boolean validatePrice(BigDecimal price) {
        if (price.compareTo(BigDecimal.ZERO) > 0) {
            return true;
        }
        throw new ValidationException("Price must be more than 0");
    }
}