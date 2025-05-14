package service;

import dao.CustomerDAO;
import dao.OrderDAO;
import dao.ProductDAO;
import model.Customer;
import model.Order;
import model.OrderItem;
import model.Product;

import java.sql.SQLException;
import java.time.LocalDateTime;
import java.util.List;

public class OrderManagementService {
    private final CustomerDAO customerDAO;
    private final ProductDAO productDAO;
    private final OrderDAO orderDAO;
    
    public OrderManagementService() {
        this.customerDAO = new CustomerDAO();
        this.productDAO = new ProductDAO();
        this.orderDAO = new OrderDAO();
    }
    
    // Lấy thông tin khách hàng theo ID
    public Customer getCustomerById(int customerId) throws SQLException {
        return customerDAO.getCustomerById(customerId);
    }
    
    // Lấy danh sách khách hàng
    public List<Customer> getAllCustomers() throws SQLException {
        return customerDAO.getAllCustomers();
    }
    
    // Lấy thông tin sản phẩm theo ID
    public Product getProductById(int productId) throws SQLException {
        return productDAO.getProductById(productId);
    }
    
    // Lấy danh sách sản phẩm
    public List<Product> getAllProducts() throws SQLException {
        return productDAO.getAllProducts();
    }
    
    // Tạo đơn hàng mới
    public int createOrder(int customerId, List<OrderItem> items) throws SQLException {
        // Kiểm tra khách hàng tồn tại
        Customer customer = customerDAO.getCustomerById(customerId);
        if (customer == null) {
            throw new IllegalArgumentException("Customer with ID " + customerId + " does not exist.");
        }
        
        // Kiểm tra và cập nhật thông tin sản phẩm
        for (OrderItem item : items) {
            Product product = productDAO.getProductById(item.getProductId());
            if (product == null) {
                throw new IllegalArgumentException("Product with ID " + item.getProductId() + " does not exist.");
            }
            
            // Kiểm tra số lượng tồn kho
            if (product.getStockQuantity() < item.getQuantity()) {
                throw new IllegalArgumentException("Product " + product.getName() + " is out of stock. Only " 
                                               + product.getStockQuantity() + " available.");
            }
            
            // Cập nhật thông tin giá và tên sản phẩm
            item.setPrice(product.getPrice());
            item.setProductName(product.getName());
        }
        
        // Tạo đơn hàng
        Order order = new Order();
        order.setCustomerId(customerId);
        order.setOrderDate(LocalDateTime.now());
        order.setStatus("Pending");
        order.setOrderItems(items);
        
        // Lưu đơn hàng vào database
        return orderDAO.addOrder(order);
    }
    
    // Lấy lịch sử đơn hàng của khách hàng
    public List<Order> getOrderHistory(int customerId) throws SQLException {
        return orderDAO.getOrdersByCustomerId(customerId);
    }
    
    // Tính tổng tiền đơn hàng
    public double calculateOrderTotal(int orderId) throws SQLException {
        Order order = orderDAO.getOrderById(orderId);
        if (order == null) {
            throw new IllegalArgumentException("Order with ID " + orderId + " does not exist.");
        }
        
        return order.calculateTotal();
    }
    
    // Cập nhật trạng thái đơn hàng
    public boolean updateOrderStatus(int orderId, String status) throws SQLException {
        return orderDAO.updateOrderStatus(orderId, status);
    }
}