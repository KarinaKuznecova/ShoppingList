package com.javaguru.shoppinglist;

import jdk.jfr.Category;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

class ShoppingListApplication {

    public static void main(String[] args) {
        Map<Long, Product> productRepository = new HashMap<>();
        Long productIdSequence = 1L;
        Product product = new Product();
        Validator validator = new Validator();
        while (true) {
            Scanner scanner = new Scanner(System.in);
            try {
                System.out.println("1. Create product");
                System.out.println("2. Find product by id");
                System.out.println("3. Exit");
                Integer userInput = Integer.valueOf(scanner.nextLine());
                switch (userInput) {
                    case 1:
                        System.out.println("Enter product name: ");
                        String name = scanner.nextLine();

                        System.out.println("Enter product price: ");
                        BigDecimal price = new BigDecimal(scanner.nextLine());

                        System.out.println("Enter product discount: ");
                        BigDecimal discouunt = new BigDecimal(scanner.nextLine());

                        System.out.println("Enter product description: ");
                        String description = scanner.nextLine();

                        System.out.println("Enter product category: ");

                        System.out.println("1. " + category.ALCOHOL);
                        System.out.println("2. " + category.FISH);
                        System.out.println("3. " + category.FRUIT);
                        System.out.println("4. " + category.MEAT);
                        System.out.println("5. " + category.MILK);
                        System.out.println("6. " + category.VEGETABLE);

                        try {
                            Integer userInputCategory = Integer.valueOf(scanner.nextLine());
                            switch (userInputCategory) {
                                case 1:
                                    product.setCategory(category.ALCOHOL);
                                    break;
                                case 2:
                                    product.setCategory(category.FISH);
                                    break;
                                case 3:
                                    product.setCategory(category.FRUIT);
                                    break;
                                case 4:
                                    product.setCategory(category.MEAT);
                                    break;
                                case 5:
                                    product.setCategory(category.MILK);
                                    break;
                                case 6:
                                    product.setCategory(category.VEGETABLE);
                                    break;
                            }
                        } catch (Exception e) {
                            e.printStackTrace();
                            System.out.println("Error, try again");
                        }

                        product.setName(name);
                        product.setPrice(price);
                        product.setDiscount(discouunt);
                        product.setDescription(description);

                        if (validator.validateProduct(product)) {
                            productRepository.put(productIdSequence, product);
                            product.setId(productIdSequence);
                            productIdSequence++;
                        }
                        System.out.println(productRepository);
                        break;
                    case 2:
                        System.out.println("Enter product id: ");
                        long id = scanner.nextLong();
                        Product findProductResult = productRepository.get(id);
                        System.out.println(findProductResult);
                    case 3:
                        return;
                }
            } catch (Exception e) {
                e.printStackTrace();
                System.out.println("Error! Please try again.");
            }
        }
    }
}