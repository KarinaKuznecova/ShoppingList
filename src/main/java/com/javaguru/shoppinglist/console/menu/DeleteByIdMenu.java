package com.javaguru.shoppinglist.console.menu;

import com.javaguru.shoppinglist.console.MenuItem;
import com.javaguru.shoppinglist.console.Reader;
import com.javaguru.shoppinglist.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
class DeleteByIdMenu implements MenuItem {
    private Reader reader = new Reader();
    private ProductService productService;
    private String name = "Delete product by id";

    @Autowired
    public DeleteByIdMenu(ProductService productService) {
        this.productService = productService;
    }

    @Override
    public void action() {
        long id = reader.getUserInput("Enter product id: ");
        productService.deleteProductById(id);
    }

    @Override
    public String toString() {
        return name;
    }
}