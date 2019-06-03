package com.javaguru.shoppinglist.ConsoleUI;

import com.javaguru.shoppinglist.service.*;

import java.math.BigDecimal;

public class CreateNewMenu implements MenuItem {
    private Reader reader = new Reader();

    @Override
    public void action(ProductService productService) {
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
}