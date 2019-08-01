package com.javaguru.shoppinglist.console.menu;

import com.javaguru.shoppinglist.domain.Category;
import com.javaguru.shoppinglist.domain.Product;
import com.javaguru.shoppinglist.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;

@Component
public class CreateNewMenu implements MenuItem {
    private Reader reader = new Reader();
    private ProductService productService;
    private String name = "Create new product";

    @Autowired
    public CreateNewMenu(ProductService productService) {
        this.productService = productService;
    }

    @Override
    public void action() {
        CategoryChooser categoryChooser = new CategoryChooser();
        String name = reader.getUserInputLine("Enter product name: ");
        BigDecimal price = new BigDecimal(reader.getUserInputDouble("Enter product price: "));
        String description = reader.getUserInputLine("Enter description (optional): ");
        Category category = categoryChooser.getCategory();
        Product product = new Product();
        product.setName(name);
        product.setPrice(price);
        product.setCategory(category);
        if (!description.isEmpty()) {
            product.setDescription(description);
        }
        System.out.println("Result: " + productService.createProduct(product));
    }

    @Override
    public String toString() {
        return name;
    }
}