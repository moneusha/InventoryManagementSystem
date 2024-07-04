package com.example.inventory.model;

import org.springframework.data.annotation.Id;

import com.example.inventory.enums.OrderStatus;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import java.time.LocalDateTime;

@Entity
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String customerName;
    private LocalDateTime orderDate;
    private OrderStatus status;

    @ManyToOne
    @JoinColumn(name = "product_id", nullable = false)
    private Product product;

    public Order() {
    }

    public Order(String customerName, LocalDateTime orderDate, OrderStatus status, Product product) {
        this.customerName = customerName;
        this.orderDate = orderDate;
        this.status = status;
        this.product = product;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public LocalDateTime getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(LocalDateTime orderDate) {
        this.orderDate = orderDate;
    }

    public OrderStatus getStatus() {
        return status;
    }

    public void setStatus(OrderStatus status) {
        this.status = status;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public String getOrderDetails() {
        return "Order ID: " + id + ", Customer Name: " + customerName + ", Order Date: " + orderDate + 
               ", Status: " + status + ", Product: " + product.getName();
    }
}
