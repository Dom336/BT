package main;

import model.Customer;
import model.Order;
import model.OrderItem;
import model.Product;
import service.OrderManagementService;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

    private static OrderManagementService service = new OrderManagementService();
    private static Scanner scanner = new Scanner(System.in);
    
    public static void main(String[] args) {
        System.out.println("=== CHƯƠNG TRÌNH QUẢN LÝ ĐƠN HÀNG ===");
        
        boolean exit = false;
        while (!exit) {
            System.out.println("\nCác chức năng:");
            System.out.println("1. Thêm đơn hàng mới");
            System.out.println("2. Xem lịch sử đơn hàng của khách hàng");
            System.out.println("3. Tính tổng tiền đơn hàng");
            System.out.println("4. Xem danh sách khách hàng");
            System.out.println("5. Xem danh sách sản phẩm");
            System.out.println("0. Thoát");
            
            System.out.print("Chọn chức năng (0-5): ");
            int choice = Integer.parseInt(scanner.nextLine());
            
            try {
                switch (choice) {
                    case 1:
                        createNewOrder();
                        break;
                    case 2:
                        viewOrderHistory();
                        break;
                    case 3:
                        calculateOrderTotal();
                        break;
                    case 4:
                        viewAllCustomers();
                        break;
                    case 5:
                        viewAllProducts();
                        break;
                    case 0:
                        exit = true;
                        System.out.println("Cảm ơn bạn đã sử dụng chương trình!");
                        break;
                    default:
                        System.out.println("Chức năng không hợp lệ, vui lòng chọn lại!");
                }
            } catch (Exception e) {
                System.out.println("Lỗi: " + e.getMessage());
                e.printStackTrace();
            }
        }
        
        scanner.close();
    }
    
    // Hàm tạo đơn hàng mới
    private static void createNewOrder() throws SQLException {
        System.out.println("\n=== THÊM ĐƠN HÀNG MỚI ===");
        
        // Hiển thị danh sách khách hàng
        List<Customer> customers = service.getAllCustomers();
        System.out.println("\nDanh sách khách hàng:");
        for (Customer customer : customers) {
            System.out.println(customer.getId() + ". " + customer.getName() + " - " + customer.getPhone());
        }
        
        // Chọn khách hàng
        System.out.print("\nNhập ID khách hàng: ");
        int customerId = Integer.parseInt(scanner.nextLine());
        
        // Kiểm tra khách hàng tồn tại
        Customer customer = service.getCustomerById(customerId);
        if (customer == null) {
            System.out.println("Khách hàng không tồn tại!");
            return;
        }
        
        // Tạo danh sách sản phẩm trong đơn hàng
        List<OrderItem> orderItems = new ArrayList<>();
        boolean addingItems = true;
        
        while (addingItems) {
            // Hiển thị danh sách sản phẩm
            List<Product> products = service.getAllProducts();
            System.out.println("\nDanh sách sản phẩm:");
            for (Product product : products) {
                System.out.println(product.getId() + ". " + product.getName() + 
                                  " - Giá: " + product.getPrice() + 
                                  " - Tồn kho: " + product.getStockQuantity());
            }
            
            // Chọn sản phẩm
            System.out.print("\nNhập ID sản phẩm (0 để hoàn thành): ");
            int productId = Integer.parseInt(scanner.nextLine());
            
            if (productId == 0) {
                addingItems = false;
                continue;
            }
            
            // Kiểm tra sản phẩm tồn tại
            Product product = service.getProductById(productId);
            if (product == null) {
                System.out.println("Sản phẩm không tồn tại!");
                continue;
            }
            
            // Nhập số lượng
            System.out.print("Nhập số lượng: ");
            int quantity = Integer.parseInt(scanner.nextLine());
            
            // Kiểm tra số lượng
            if (quantity <= 0) {
                System.out.println("Số lượng phải lớn hơn 0!");
                continue;
            }
            
            if (quantity > product.getStockQuantity()) {
                System.out.println("Số lượng vượt quá tồn kho! Tồn kho hiện tại: " + product.getStockQuantity());
                continue;
            }
            
            // Thêm vào danh sách
            OrderItem item = new OrderItem(productId, quantity, product.getPrice(), product.getName());
            orderItems.add(item);
            
            System.out.println("Đã thêm " + quantity + " " + product.getName() + " vào đơn hàng.");
            
            // Hỏi có tiếp tục thêm sản phẩm không
            System.out.print("\nBạn có muốn thêm sản phẩm khác không? (y/n): ");
            String answer = scanner.nextLine();
            if (!answer.equalsIgnoreCase("y")) {
                addingItems = false;
            }
        }
        
        // Kiểm tra đơn hàng có sản phẩm không
        if (orderItems.isEmpty()) {
            System.out.println("Đơn hàng không có sản phẩm nào, hủy tạo đơn hàng!");
            return;
        }
        
        // Hiển thị thông tin đơn hàng
        System.out.println("\n=== THÔNG TIN ĐƠN HÀNG ===");
        System.out.println("Khách hàng: " + customer.getName() + " - " + customer.getPhone());
        System.out.println("Các sản phẩm:");
        
        double total = 0;
        for (OrderItem item : orderItems) {
            System.out.println("- " + item.getProductName() + " x " + item.getQuantity() + 
                              " = " + (item.getPrice() * item.getQuantity()) + " VND");
            total += item.getPrice() * item.getQuantity();
        }
        
        System.out.println("Tổng tiền: " + total + " VND");
        
        // Xác nhận tạo đơn hàng
        System.out.print("\nXác nhận tạo đơn hàng? (y/n): ");
        String confirm = scanner.nextLine();
        if (!confirm.equalsIgnoreCase("y")) {
            System.out.println("Đã hủy tạo đơn hàng!");
            return;
        }
        
        // Tạo đơn hàng
        int orderId = service.createOrder(customerId, orderItems);
        System.out.println("Đã tạo đơn hàng thành công với ID: " + orderId);
    }
    
    // Hàm xem lịch sử đơn hàng
    private static void viewOrderHistory() throws SQLException {
        System.out.println("\n=== XEM LỊCH SỬ ĐƠN HÀNG ===");
        
        // Hiển thị danh sách khách hàng
        List<Customer> customers = service.getAllCustomers();
        System.out.println("\nDanh sách khách hàng:");
        for (Customer customer : customers) {
            System.out.println(customer.getId() + ". " + customer.getName() + " - " + customer.getPhone());
        }
        
        // Chọn khách hàng
        System.out.print("\nNhập ID khách hàng: ");
        int customerId = Integer.parseInt(scanner.nextLine());
        
        // Kiểm tra khách hàng tồn tại
        Customer customer = service.getCustomerById(customerId);
        if (customer == null) {
            System.out.println("Khách hàng không tồn tại!");
            return;
        }
        
        // Lấy lịch sử đơn hàng
        List<Order> orders = service.getOrderHistory(customerId);
        
        if (orders.isEmpty()) {
            System.out.println("Khách hàng chưa có đơn hàng nào!");
            return;
        }
        
        // Hiển thị lịch sử đơn hàng
        System.out.println("\nLịch sử đơn hàng của " + customer.getName() + ":");
        
        for (Order order : orders) {
            System.out.println("\nĐơn hàng #" + order.getId());
            System.out.println("Ngày đặt: " + order.getOrderDate());
            System.out.println("Trạng thái: " + order.getStatus());
            System.out.println("Các sản phẩm:");
            
            for (OrderItem item : order.getOrderItems()) {
                System.out.println("- " + item.getProductName() + " x " + item.getQuantity() + 
                                  " = " + (item.getPrice() * item.getQuantity()) + " VND");
            }
            
            System.out.println("Tổng tiền: " + order.calculateTotal() + " VND");
        }
    }
    
    // Hàm tính tổng tiền đơn hàng
    private static void calculateOrderTotal() throws SQLException {
        System.out.println("\n=== TÍNH TỔNG TIỀN ĐƠN HÀNG ===");
        
        System.out.print("Nhập ID đơn hàng: ");
        int orderId = Integer.parseInt(scanner.nextLine());
        
        try {
            double total = service.calculateOrderTotal(orderId);
            System.out.println("Tổng tiền đơn hàng #" + orderId + ": " + total + " VND");
        } catch (IllegalArgumentException e) {
            System.out.println("Lỗi: " + e.getMessage());
        }
    }
    
    // Hàm xem danh sách khách hàng
    private static void viewAllCustomers() throws SQLException {
        System.out.println("\n=== DANH SÁCH KHÁCH HÀNG ===");
        
        List<Customer> customers = service.getAllCustomers();
        
        if (customers.isEmpty()) {
            System.out.println("Không có khách hàng nào!");
            return;
        }
        
        System.out.println("ID\tTên\t\tEmail\t\tSĐT\t\tĐịa chỉ");
        for (Customer customer : customers) {
            System.out.println(customer.getId() + "\t" + 
                              customer.getName() + "\t" + 
                              customer.getEmail() + "\t" + 
                              customer.getPhone() + "\t" + 
                              customer.getAddress());
        }
    }
    
    // Hàm xem danh sách sản phẩm
    private static void viewAllProducts() throws SQLException {
        System.out.println("\n=== DANH SÁCH SẢN PHẨM ===");
        
        List<Product> products = service.getAllProducts();
        
        if (products.isEmpty()) {
            System.out.println("Không có sản phẩm nào!");
            return;
        }
        
        System.out.println("ID\tTên\t\tGiá\t\tTồn kho\t\tMô tả");
        for (Product product : products) {
            System.out.println(product.getId() + "\t" + 
                              product.getName() + "\t" + 
                              product.getPrice() + "\t" + 
                              product.getStockQuantity() + "\t\t" + 
                              product.getDescription());
        }
    }
}