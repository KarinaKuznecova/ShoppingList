package com.javaguru.shoppinglist.repository;

import com.javaguru.shoppinglist.domain.Product;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.Map;

@Repository
@Profile("inmemory")
public class InMemoryRepository {
    private Map<Long, Product> productRepository = new HashMap<>();
    private Long productIdSequence = 0L;

    public Product add(Product product) {
        product.setId(productIdSequence++);
        productRepository.put(product.getId(), product);
        return product;
    }

    public Product getProductById(Long id) {
        return productRepository.get(id);
    }

    public Product removeProductById(Long id) {
        return productRepository.remove(id);
    }

    public void removeAllProducts() {
        productRepository.clear();
        productIdSequence = 0L;
    }

    public void printAll() {
        for (Product i : productRepository.values()) {
            System.out.println(i);
        }
    }

    public boolean containsProduct(Product product) {
        return productRepository.containsValue(product);
    }

    public long getStorageSize() {
        return productRepository.size();
    }
}
