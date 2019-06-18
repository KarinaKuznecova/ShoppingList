package com.javaguru.shoppinglist.console;

import com.javaguru.shoppinglist.service.ProductService;

public interface MenuItem {

    void action(ProductService productService);
}
