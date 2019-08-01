package com.javaguru.shoppinglist.console.menu;

import com.javaguru.shoppinglist.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;

@Component
class EditProductMenu implements MenuItem {
    private Reader reader = new Reader();
    private ProductService productService;
    private String name = "Edit product";

    @Autowired
    public EditProductMenu(ProductService productService) {
        this.productService = productService;
    }

    @Override
    public void action() {
        long id = reader.getUserInput("Enter product Id");
        int pickedAction = pickEditAction();
        switch (pickedAction) {
            case 1:
                String newName = reader.getUserInputLine("Enter new name");
                productService.changeNameById(id, newName);
                break;
            case 2:
                BigDecimal newPrice = BigDecimal.valueOf(reader.getUserInputDouble("Enter new price"));
                productService.setPriceById(id, newPrice);
                break;
            case 3:
                BigDecimal newDiscount = BigDecimal.valueOf(reader.getUserInputDouble("Enter new discount"));
                productService.setDiscountById(id, newDiscount);
                break;
            case 4:
                String newDescription = reader.getUserInputLine("Enter new description");
                productService.changeProductDescription(id, newDescription);
                break;
            default:
                System.out.println("Wrong number");
                action();
        }
        System.out.println("Information is updated");
    }

    private int pickEditAction() {
        System.out.println("Please, choose what to do:");
        System.out.println();
        System.out.println("1. Change name");
        System.out.println("2. Change price");
        System.out.println("3. Set Discount");
        System.out.println("4. Change description");
        System.out.println();
        return reader.getUserInput("Enter a number: ");
    }

    @Override
    public String toString() {
        return name;
    }
}