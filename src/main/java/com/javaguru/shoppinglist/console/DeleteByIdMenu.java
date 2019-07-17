package com.javaguru.shoppinglist.console;

import com.javaguru.shoppinglist.service.ProductService;

class DeleteByIdMenu implements MenuItem {
    private Reader reader = new Reader();

    @Override
    public void action(ProductService productService) {
        long id = reader.getUserInput("Enter product id: ");
        productService.deleteProductById(id);
    }
}