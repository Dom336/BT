package dao;

import model.Order;
import model.OrderItem;

import java.sql.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class OrderDAO {
    // Lấy thông tin đơn hàng theo ID
    public Order getOrderById(int orderId) throws SQLException {
        String query = "SELECT * FROM orders WHERE id = ?";
        
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(query)) {
            
            stmt.setInt(1, orderId);
            
            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    Order order = new Order();
                    order.setId(rs.getInt("id"));
                    order.setCustomerId(rs.getInt("customer_id"));
                    order.setOrderDate(rs.getTimestamp("order_date").toLocalDateTime());
                    order.setStatus(rs.getString("status"));
                    
                    // Lấy các items của đơn hàng
                    order.setOrderItems(getOrderItemsByOrderId(orderId));
                    
                    return order;
                }
            }
        }
        
        return null;
    }
    
    // Lấy tất cả đơn hàng của một khách hàng
    public List<Order> getOrdersByCustomerId(int customerId) throws SQLException {
        List<Order> orders = new ArrayList<>();
        String query = "SELECT * FROM orders WHERE customer_id = ? ORDER BY order_date DESC";
        
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(query)) {
            
            stmt.setInt(1, customerId);
            
            try (ResultSet rs = stmt.executeQuery()) {
                while (rs.next()) {
                    Order order = new Order();
                    order.setId(rs.getInt("id"));
                    order.setCustomerId(rs.getInt("customer_id"));
                    order.setOrderDate(rs.getTimestamp("order_date").toLocalDateTime());
                    order.setStatus(rs.getString("status"));
                    
                    // Lấy các items của đơn hàng
                    order.setOrderItems(getOrderItemsByOrderId(order.getId()));
                    
                    orders.add(order);
                }
            }
        }
        
        return orders;
    }
    
    // Lấy các item trong đơn hàng
    private List<OrderItem> getOrderItemsByOrderId(int orderId) throws SQLException {
        List<OrderItem> items = new ArrayList<>();
        String query = "SELECT oi.*, p.name as product_name FROM order_items oi " +
                       "JOIN products p ON oi.product_id = p.id " +
                       "WHERE oi.order_id = ?";
        
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(query)) {
            
            stmt.setInt(1, orderId);
            
            try (ResultSet rs = stmt.executeQuery()) {
                while (rs.next()) {
                    OrderItem item = new OrderItem();
                    item.setId(rs.getInt("id"));
                    item.setOrderId(rs.getInt("order_id"));
                    item.setProductId(rs.getInt("product_id"));
                    item.setQuantity(rs.getInt("quantity"));
                    item.setPrice(rs.getDouble("price"));
                    item.setProductName(rs.getString("product_name"));
                    items.add(item);
                }
            }
        }
        
        return items;
    }
    
    // Thêm đơn hàng mới (kèm các items)
    public int addOrder(Order order) throws SQLException {
        Connection conn = null;
        try {
            conn = DatabaseConnection.getConnection();
            conn.setAutoCommit(false);
            
            // Thêm đơn hàng
            String orderQuery = "INSERT INTO orders (customer_id, order_date, status) VALUES (?, ?, ?)";
            int orderId;
            
            try (PreparedStatement stmt = conn.prepareStatement(orderQuery, Statement.RETURN_GENERATED_KEYS)) {
                stmt.setInt(1, order.getCustomerId());
                stmt.setTimestamp(2, Timestamp.valueOf(order.getOrderDate()));
                stmt.setString(3, order.getStatus());
                
                int affectedRows = stmt.executeUpdate();
                
                if (affectedRows == 0) {
                    throw new SQLException("Creating order failed, no rows affected.");
                }
                
                try (ResultSet generatedKeys = stmt.getGeneratedKeys()) {
                    if (generatedKeys.next()) {
                        orderId = generatedKeys.getInt(1);
                        order.setId(orderId);
                    } else {
                        throw new SQLException("Creating order failed, no ID obtained.");
                    }
                }
            }
            
            // Thêm các order items
            String itemQuery = "INSERT INTO order_items (order_id, product_id, quantity, price) VALUES (?, ?, ?, ?)";
            
            try (PreparedStatement stmt = conn.prepareStatement(itemQuery)) {
                for (OrderItem item : order.getOrderItems()) {
                    stmt.setInt(1, orderId);
                    stmt.setInt(2, item.getProductId());
                    stmt.setInt(3, item.getQuantity());
                    stmt.setDouble(4, item.getPrice());
                    stmt.addBatch();
                    
                    // Cập nhật số lượng tồn kho
                    ProductDAO productDAO = new ProductDAO();
                    if (!productDAO.updateStock(item.getProductId(), item.getQuantity())) {
                        throw new SQLException("Product " + item.getProductId() + " is out of stock.");
                    }
                }
                
                stmt.executeBatch();
            }
            
            conn.commit();
            return orderId;
            
        } catch (SQLException e) {
            if (conn != null) {
                try {
                    conn.rollback();
                } catch (SQLException ex) {
                    ex.printStackTrace();
                }
            }
            throw e;
        } finally {
            if (conn != null) {
                try {
                    conn.setAutoCommit(true);
                    conn.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
    }
    
    // Cập nhật trạng thái đơn hàng
    public boolean updateOrderStatus(int orderId, String status) throws SQLException {
        String query = "UPDATE orders SET status = ? WHERE id = ?";
        
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(query)) {
            
            stmt.setString(1, status);
            stmt.setInt(2, orderId);
            
            int affectedRows = stmt.executeUpdate();
            return affectedRows > 0;
        }
    }
    
    // Xóa đơn hàng (thường không nên xóa mà chỉ đổi trạng thái)
    public boolean deleteOrder(int orderId) throws SQLException {
        Connection conn = null;
        try {
            conn = DatabaseConnection.getConnection();
            conn.setAutoCommit(false);
            
            // Xóa các order items trước
            String deleteItemsQuery = "DELETE FROM order_items WHERE order_id = ?";
            try (PreparedStatement stmt = conn.prepareStatement(deleteItemsQuery)) {
                stmt.setInt(1, orderId);
                stmt.executeUpdate();
            }
            
            // Xóa đơn hàng
            String deleteOrderQuery = "DELETE FROM orders WHERE id = ?";
            try (PreparedStatement stmt = conn.prepareStatement(deleteOrderQuery)) {
                stmt.setInt(1, orderId);
                int affectedRows = stmt.executeUpdate();
                
                conn.commit();
                return affectedRows > 0;
            }
        } catch (SQLException e) {
            if (conn != null) {
                try {
                    conn.rollback();
                } catch (SQLException ex) {
                    ex.printStackTrace();
                }
            }
            throw e;
        } finally {
            if (conn != null) {
                try {
                    conn.setAutoCommit(true);
                    conn.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}