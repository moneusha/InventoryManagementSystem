package com.example.inventory.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.example.inventory.model.Product;
import com.example.inventory.model.Supplier;
import com.example.inventory.repository.ProductRepository;
import com.example.inventory.repository.SupplierRepository;

import jakarta.annotation.PostConstruct;

@Configuration
@Profile("!test")
public class DataLoader {

    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private SupplierRepository supplierRepository;

    @PostConstruct
    public void loadData() {
        // Load initial data
        Supplier supplier1 = new Supplier("Supplier 1", "supplier1@example.com");
        Supplier supplier2 = new Supplier("Supplier 2", "supplier2@example.com");
        
        supplierRepository.save(supplier1);
        supplierRepository.save(supplier2);

        Product product1 = new Product("Product 1", 50, supplier1);
        Product product2 = new Product("Product 2", 30, supplier2);

        productRepository.save(product1);
        productRepository.save(product2);
    }
}
