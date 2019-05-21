package com.javaguru.shoppinglist;

import java.math.BigDecimal;
import java.math.RoundingMode;

import static java.math.RoundingMode.CEILING;

class Product {

    private Long id;
    private String name;
    private BigDecimal price;
    private String description;
    private category category;
    private BigDecimal discount;
    private BigDecimal discountPrice;


    Long getId() {
        return id;
    }

    void setId(Long id) {
        this.id = id;
    }

    String getName() {
        return name;
    }

    void setName(String name) {
        this.name = name;
    }

    BigDecimal getPrice() {
        return price;
    }

    void setPrice(BigDecimal price) {
        this.price = price;
    }

    String getDescription() {
        return description;
    }

    void setDescription(String description) {
        this.description = description;
    }

    category getCategory() {
        return category;
    }

    void setCategory(category category) {
        this.category = category;
    }

    BigDecimal getDiscount() {
        return discount;
    }

    void setDiscount(BigDecimal discount) {
        this.discount = discount;
        setDiscountPrice();
    }

    void setDiscountPrice(){
        BigDecimal discount = this.discount;
        BigDecimal hundred = new BigDecimal("100");
        BigDecimal prise = this.price;

        discountPrice = price.subtract((prise.multiply(discount).divide(hundred, 2, CEILING)));
    }

    @Override
    public String toString() {

        return "Product name " + name + ", " +
                "Product price = " + price + ", " +
                "Product discount = " + discount + " % ," +
                "Product description: " + description + ", " +
                "Product category: " + category +
                discountPrice;

    }
}
