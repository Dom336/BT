package model;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class Order {
    private int id;
    private int customerId;
    private LocalDateTime orderDate;
    private String status;
    private List<OrderItem> orderItems;
    
    public Order() {
        this.orderItems = new ArrayList<>();
        this.orderDate = LocalDateTime.now();
    }
    
    public Order(int id, int customerId, LocalDateTime orderDate, String status) {
        this.id = id;
        this.customerId = customerId;
        this.orderDate = orderDate;
        this.status = status;
        this.orderItems = new ArrayList<>();
    }
    
    // Getters and Setters
    public int getId() {
        return id;
    }
    
    public void setId(int id) {
        this.id = id;
    }
    
    public int getCustomerId() {
        return customerId;
    }
    
    public void setCustomerId(int customerId) {
        this.customerId = customerId;
    }
    
    public LocalDateTime getOrderDate() {
        return orderDate;
    }
    
    public void setOrderDate(LocalDateTime orderDate) {
        this.orderDate = orderDate;
    }
    
    public String getStatus() {
        return status;
    }
    
    public void setStatus(String status) {
        this.status = status;
    }
    
    public List<OrderItem> getOrderItems() {
        return orderItems;
    }
    
    public void setOrderItems(List<OrderItem> orderItems) {
        this.orderItems = orderItems;
    }
    
    public void addOrderItem(OrderItem item) {
        this.orderItems.add(item);
    }
    
    // Tính tổng tiền đơn hàng
    public double calculateTotal() {
        return orderItems.stream().mapToDouble(item -> item.getQuantity() * item.getPrice()).sum();
    }
    
    @Override
    public String toString() {
        return "Order [id=" + id + ", customerId=" + customerId + ", orderDate=" + orderDate + ", status=" + status + "]";
    }
}