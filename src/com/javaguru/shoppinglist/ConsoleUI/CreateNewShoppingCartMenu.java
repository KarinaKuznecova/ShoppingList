package com.javaguru.shoppinglist.ConsoleUI;

import com.javaguru.shoppinglist.service.*;

import java.util.List;

class CreateNewShoppingCartMenu implements MenuItem {

    private Reader reader = new Reader();
    private List<ShoppingCart> shoppingCarts;

    CreateNewShoppingCartMenu(List<ShoppingCart> shoppingCarts) {
        this.shoppingCarts = shoppingCarts;
    }

    @Override
    public void action(ProductService productService) {
        String name = reader.getUserInputLine("Enter name for new shopping list");
        String description = reader.getUserInputLine("Enter description for new shopping list");
        ShoppingCart shoppingList = new ShoppingCart(name, description);
        shoppingCarts.add(shoppingList);
        System.out.println("Created shopping list: ");
        System.out.println(shoppingList);
    }
}