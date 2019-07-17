package com.javaguru.shoppinglist.console.menu;


import com.javaguru.shoppinglist.console.MenuItem;
import com.javaguru.shoppinglist.console.Reader;
import com.javaguru.shoppinglist.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;

@Component
class AddDiscountByIdMenu implements MenuItem {
    private Reader reader = new Reader();
    private ProductService productService;
    private String name = "Add discount by id";

    @Autowired
    public AddDiscountByIdMenu(ProductService productService) {
        this.productService = productService;
    }

    @Override
    public void action() {
        long id = reader.getUserInput("Enter product id: ");
        BigDecimal discount = new BigDecimal(reader.getUserInputDouble("Enter discount: "));
        productService.setDiscountById(id, discount);
    }

    @Override
    public String toString() {
        return name;
    }
}