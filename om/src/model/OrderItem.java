package model;

public class OrderItem {
    private int id;
    private int orderId;
    private int productId;
    private int quantity;
    private double price;
    private String productName; // để hiển thị thông tin
    
    public OrderItem() {
    }
    
    public OrderItem(int id, int orderId, int productId, int quantity, double price) {
        this.id = id;
        this.orderId = orderId;
        this.productId = productId;
        this.quantity = quantity;
        this.price = price;
    }
    
    // Constructor không cần id và orderId (để tạo item trước khi lưu vào db)
    public OrderItem(int productId, int quantity, double price, String productName) {
        this.productId = productId;
        this.quantity = quantity;
        this.price = price;
        this.productName = productName;
    }
    
    // Getters and Setters
    public int getId() {
        return id;
    }
    
    public void setId(int id) {
        this.id = id;
    }
    
    public int getOrderId() {
        return orderId;
    }
    
    public void setOrderId(int orderId) {
        this.orderId = orderId;
    }
    
    public int getProductId() {
        return productId;
    }
    
    public void setProductId(int productId) {
        this.productId = productId;
    }
    
    public int getQuantity() {
        return quantity;
    }
    
    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
    
    public double getPrice() {
        return price;
    }
    
    public void setPrice(double price) {
        this.price = price;
    }
    
    public String getProductName() {
        return productName;
    }
    
    public void setProductName(String productName) {
        this.productName = productName;
    }
    
    // Tính tổng giá trị của item
    public double getSubtotal() {
        return quantity * price;
    }
    
    @Override
    public String toString() {
        return "OrderItem [id=" + id + ", orderId=" + orderId + ", productId=" + productId + ", quantity=" + quantity + ", price=" + price + "]";
    }
}