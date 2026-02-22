package com.project1_spring_mvc_backend.project1_spring_mvc_backend.service;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import org.jspecify.annotations.Nullable;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project1_spring_mvc_backend.project1_spring_mvc_backend.model.Order;
import com.project1_spring_mvc_backend.project1_spring_mvc_backend.model.OrderItem;
import com.project1_spring_mvc_backend.project1_spring_mvc_backend.model.ProductModel;
import com.project1_spring_mvc_backend.project1_spring_mvc_backend.model.dto.OrderItemRequest;
import com.project1_spring_mvc_backend.project1_spring_mvc_backend.model.dto.OrderItemResponse;
import com.project1_spring_mvc_backend.project1_spring_mvc_backend.model.dto.OrderRequest;
import com.project1_spring_mvc_backend.project1_spring_mvc_backend.model.dto.OrderResponse;
import com.project1_spring_mvc_backend.project1_spring_mvc_backend.repository.OrderRepository;
import com.project1_spring_mvc_backend.project1_spring_mvc_backend.repository.ProductRepository;

@Service
public class OrderService {
    @Autowired
    private OrderRepository orderRepository;
    @Autowired
    private ProductRepository productRepository;

    public OrderResponse placeOrder(OrderRequest orderRequest) {
        String uuid = UUID.randomUUID().toString();
        Order order = Order
                .builder()
                .customerName("User One")
                .email("user1@gmail.com")
                .orderDate(LocalDate.now())
                .orderId(uuid)
                .orderItems(null)
                .build();
        List<OrderItem> orderItems = new ArrayList<>();
        for (OrderItemRequest orderItemRequest : orderRequest.orderItemRequest()) {
            ProductModel product = productRepository.findById(orderItemRequest.productId())
                    .orElseThrow(() -> new RuntimeException("Product Not Found"));
            product.setStockQuantity(product.getStockQuantity() + orderItemRequest.quantity());
            productRepository.save(product);
            OrderItem orderItem=OrderItem.builder()
            .product(product)
            .quantity(orderItemRequest.quantity())
            .totalPrice(product.getPrice().multiply(BigDecimal.valueOf(orderItemRequest.quantity())))
            .order(order)
            .build();
            orderItems.add(orderItem);
        }
        order.setOrderItems(orderItems);
        Order savedOrder=orderRepository.save(order);
        List<OrderItemResponse> itemResponses=new ArrayList<>();
        for(OrderItem item:order.getOrderItems()){
            OrderItemResponse orderItemResponse=new OrderItemResponse(
                item.getProduct().getName(),
                item.getQuantity(),
                item.getTotalPrice()
            );
            itemResponses.add(orderItemResponse);
        }
        OrderResponse orderResponse=new OrderResponse(
            savedOrder.getOrderId(),
            savedOrder.getCustomerName(),
            savedOrder.getEmail(),
            savedOrder.getStatus(),
            savedOrder.getOrderDate(),
            itemResponses
        ); 
        return orderResponse;
    }

    public List<OrderResponse> getOrder() {
        List<Order> orders=orderRepository.findAll();
        List<OrderResponse> orderResponses=new ArrayList<>();
        for (Order order:orders){
            List <OrderItemResponse> itemResponses=new ArrayList<>();
            for(OrderItem item:order.getOrderItems()){
                OrderItemResponse orderItemResponse=new OrderItemResponse(
                    item.getProduct().getName(),
                    item.getQuantity(),
                    item.getTotalPrice()
                );
                itemResponses.add(orderItemResponse);
            }
            OrderResponse orderResponse=new OrderResponse(
                order.getOrderId(),
                order.getCustomerName(),
                order.getEmail(),
                order.getStatus(),
                order.getOrderDate(),
                itemResponses
            );  
        }
        return orderResponses;
    }

}
