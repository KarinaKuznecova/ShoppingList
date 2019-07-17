package com.javaguru.shoppinglist.console.menu;

import com.javaguru.shoppinglist.console.MenuItem;
import com.javaguru.shoppinglist.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
class PrintAllProductsMenu implements MenuItem {
    private ProductService productService;
    private String name = "Print all products";

    @Autowired
    public PrintAllProductsMenu(ProductService productService) {
        this.productService = productService;
    }

    @Override
    public void action() {
        productService.printAll();
    }

    @Override
    public String toString() {
        return name;
    }
}
