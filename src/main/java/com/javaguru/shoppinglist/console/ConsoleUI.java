package com.javaguru.shoppinglist.console;

import com.javaguru.shoppinglist.console.menu.MenuItem;
import com.javaguru.shoppinglist.console.menu.Reader;

import java.util.List;

public class ConsoleUI {
    private Reader reader = new Reader();
    private final List<MenuItem> menuItems;

    public ConsoleUI(List<MenuItem> menuItems) {
        this.menuItems = menuItems;
    }

    public void go() {
        while (true) {
            printMenu();
            try {
                int pickedNumber = reader.getUserInput("Enter a number: ");
                menuSelected(pickedNumber);
            } catch (Exception e) {
                System.out.println(e.getMessage());
                System.out.println("Error! Please try again.");
            }
        }
    }

    private void printMenu() {
        for (int i = 0; i < menuItems.size(); i++) {
            System.out.println(i + 1 + ". " + menuItems.get(i));
        }
    }

    private void menuSelected(int userPickedNumber) {
        int index = userPickedNumber - 1;
        try {
            menuItems.get(index).action();
        } catch (ArrayIndexOutOfBoundsException ex) {
            System.out.println("Wrong number, try again");
        }
    }
}