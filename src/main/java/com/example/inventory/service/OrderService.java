package com.example.inventory.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.inventory.enums.OrderStatus;
import com.example.inventory.model.Order;
import com.example.inventory.model.Product;
import com.example.inventory.repository.OrderRepository;
import com.example.inventory.repository.ProductRepository;

import java.time.LocalDateTime;

@Service
public class OrderService {

    @Autowired
    private OrderRepository orderRepository;

    @Autowired
    private ProductRepository productRepository;

    public List<Order> getAllOrders() {
        return orderRepository.findAll();
    }

    public Order placeOrder(Order order) {
        order.setOrderDate(LocalDateTime.now());
        order.setStatus(OrderStatus.PENDING);

        Product product = order.getProduct();
        product.setQuantity(product.getQuantity() - 1);
        productRepository.save(product);

        return orderRepository.save(order);
    }

    public Order updateOrder(Long id, Order order) {
        Order existingOrder = orderRepository.findById(id).orElseThrow();
        existingOrder.setCustomerName(order.getCustomerName());
        existingOrder.setStatus(order.getStatus());
        return orderRepository.save(existingOrder);
    }

    public void cancelOrder(Long id) {
        Order order = orderRepository.findById(id).orElseThrow();
        order.setStatus(OrderStatus.CANCELLED);

        Product product = order.getProduct();
        product.setQuantity(product.getQuantity() + 1);
        productRepository.save(product);

        orderRepository.save(order);
    }
}
