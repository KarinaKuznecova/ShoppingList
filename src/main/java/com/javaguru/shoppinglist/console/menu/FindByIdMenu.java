package com.javaguru.shoppinglist.console.menu;

import com.javaguru.shoppinglist.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
class FindByIdMenu implements MenuItem {
    private Reader reader = new Reader();
    private ProductService productService;
    private String name = "Find product by id";

    @Autowired
    public FindByIdMenu(ProductService productService) {
        this.productService = productService;
    }

    @Override
    public void action() {
        long id = reader.getUserInput("Enter product id: ");
        System.out.println(productService.getProductById(id));
    }

    @Override
    public String toString() {
        return name;
    }
}
