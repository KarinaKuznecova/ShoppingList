package com.javaguru.shoppinglist.console.menu;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
class CreateNewShoppingCartMenu implements MenuItem {

    private Reader reader = new Reader();
    private List<ShoppingCart> shoppingCarts;
    private String name = "Create new shopping cart";

    @Autowired
    public CreateNewShoppingCartMenu(List<ShoppingCart> shoppingCarts) {
        this.shoppingCarts = shoppingCarts;
    }

    @Override
    public void action() {
        String name = reader.getUserInputLine("Enter name for new shopping cart");
        String description = reader.getUserInputLine("Enter description for new shopping cart");
        ShoppingCart cart = new ShoppingCart(name, description);
        shoppingCarts.add(cart);
        System.out.println("Created shopping cart: ");
        System.out.println(cart);
    }

    @Override
    public String toString() {
        return name;
    }
}