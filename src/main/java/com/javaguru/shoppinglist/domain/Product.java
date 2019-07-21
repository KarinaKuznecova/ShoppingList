package com.javaguru.shoppinglist.domain;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Objects;

import static java.math.RoundingMode.CEILING;

@Entity
@Table(name = "Products")
public class Product {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name = "price")
    private BigDecimal price;

    @Column(name = "description")
    private String description;

    @Column(name = "category")
    @Enumerated(EnumType.STRING)
    private Category category;

    @Column(name = "discount")
    private BigDecimal discount;

    @Column(name = "discountPrice")
    private BigDecimal discountPrice;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public BigDecimal getDiscount() {
        return discount;
    }

    public void setDiscount(BigDecimal discount) {
        this.discount = discount;
        setDiscountPrice();
    }

    void setDiscountPrice() {
        BigDecimal hundred = new BigDecimal("100");
        discountPrice = price.subtract((price.multiply(discount).divide(hundred, 2, CEILING)));
    }

    public BigDecimal getDiscountPrice() {
        return discountPrice;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Product product = (Product) o;
        return Objects.equals(name, product.name) &&
                Objects.equals(price, product.price) &&
                Objects.equals(description, product.description) &&
                category == product.category &&
                Objects.equals(discount, product.discount) &&
                Objects.equals(discountPrice, product.discountPrice);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, price, description, category, discount, discountPrice);
    }

    @Override
    public String toString() {

        return "ID: " + id
                + " | Name: " + name
                + " | Price = " + price + " \u20AC/kg"
                + " | Discount = " + discount + " %"
                + " | Description: " + description
                + " | Category: " + category
                + " | Discount price = " + discountPrice + " \u20AC/kg";
    }
}
