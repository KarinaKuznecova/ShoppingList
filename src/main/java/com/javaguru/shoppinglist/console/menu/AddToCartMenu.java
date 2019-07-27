package com.javaguru.shoppinglist.console.menu;

import com.javaguru.shoppinglist.console.MenuItem;
import com.javaguru.shoppinglist.console.Reader;
import com.javaguru.shoppinglist.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
class AddToCartMenu implements MenuItem {
    Reader reader = new Reader();
    private List<ShoppingCart> shoppingCarts;
    private ProductService productService;
    private String name = "Add product to shopping cart";

    @Autowired
    public AddToCartMenu(List<ShoppingCart> shoppingCarts, ProductService productService) {
        this.shoppingCarts = shoppingCarts;
        this.productService = productService;
    }

    @Override
    public void action() {
        for (int i = 0; i < shoppingCarts.size(); i++) {
            System.out.println(i + ". " + shoppingCarts.get(i));
        }
        int chosenList = reader.getUserInput("Enter number to pick a cart");
        long productId = reader.getUserInput("Enter id of product to add to this cart");

        shoppingCarts.get(chosenList).addProduct(productService.getProductById(productId));
        System.out.println("Product with id " + productId + " added");
    }

    @Override
    public String toString() {
        return name;
    }
}