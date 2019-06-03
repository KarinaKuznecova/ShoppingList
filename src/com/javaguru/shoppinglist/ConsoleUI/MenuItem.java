package com.javaguru.shoppinglist.ConsoleUI;

import com.javaguru.shoppinglist.service.ProductService;

public interface MenuItem {

    void action(ProductService productService);
}
