package com.example.inventory.util;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.example.inventory.model.Order;
import com.example.inventory.model.Product;
import com.example.inventory.model.Supplier;
import com.example.inventory.repository.OrderRepository;
import com.example.inventory.repository.ProductRepository;
import com.example.inventory.repository.SupplierRepository;

@Component
public class ReportGenerator {

    @Autowired
    private OrderRepository orderRepository;

    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private SupplierRepository supplierRepository;

    public void generateStockReport() {
        List<Product> products = productRepository.findAll();
        System.out.println("Stock Report:");
        for (Product product : products) {
            System.out.println("Product: " + product.getName() + ", Quantity: " + product.getQuantity());
        }
    }

    public void generateOrderReport() {
        List<Order> orders = orderRepository.findAll();
        System.out.println("Order Report:");
        for (Order order : orders) {
            System.out.println(order.getOrderDetails());
        }
    }

    public void generateSupplierReport() {
        List<Supplier> suppliers = supplierRepository.findAll();
        System.out.println("Supplier Report:");
        for (Supplier supplier : suppliers) {
            System.out.println(supplier.getSupplierDetails());
        }
    }
}
