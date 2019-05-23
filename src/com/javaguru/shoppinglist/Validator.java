package com.javaguru.shoppinglist;

import java.math.BigDecimal;

class Validator {

    void validateProduct(Product product) {
        validateName(product.getName());
        validateDiscount(product.getDiscount());
        validatePrice(product.getPrice());
    }

    void validateName(String name) {
        if (name.length() < 3 || name.length() > 30) {
            throw new ValidationException("Name length should be more than 3 symbols and less than 30");
        }
    }

    void validateDiscount(BigDecimal discount) {
        BigDecimal maxDiscount = new BigDecimal(80);
        if (discount.compareTo(BigDecimal.ZERO) < 0 || discount.compareTo(maxDiscount) > 0) {
            throw new ValidationException("Discount must be more than 0% and less than 80%");
        }
    }

    void validatePrice(BigDecimal price) {
        if (price.compareTo(BigDecimal.ZERO) <= 0) {
            throw new ValidationException("Price must be more than 0");
}