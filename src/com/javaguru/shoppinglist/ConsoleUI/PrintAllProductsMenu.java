package com.javaguru.shoppinglist.ConsoleUI;

import com.javaguru.shoppinglist.service.ProductService;

class PrintAllProductsMenu implements MenuItem {

    @Override
    public void action(ProductService productService) {
        productService.printAll();
    }
}
