-- Tạo database
CREATE DATABASE IF NOT EXISTS order_management;
USE order_management;

-- Tạo bảng customers
CREATE TABLE IF NOT EXISTS customers (
    id INT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(100) NOT NULL,
    email VARCHAR(100) UNIQUE,
    phone VARCHAR(20),
    address VARCHAR(255)
);

-- Tạo bảng products
CREATE TABLE IF NOT EXISTS products (
    id INT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(100) NOT NULL,
    description TEXT,
    price DOUBLE NOT NULL,
    stock_quantity INT NOT NULL DEFAULT 0
);

-- Tạo bảng orders
CREATE TABLE IF NOT EXISTS orders (
    id INT AUTO_INCREMENT PRIMARY KEY,
    customer_id INT NOT NULL,
    order_date DATETIME NOT NULL,
    status VARCHAR(50) NOT NULL,
    FOREIGN KEY (customer_id) REFERENCES customers(id)
);

-- Tạo bảng order_items
CREATE TABLE IF NOT EXISTS order_items (
    id INT AUTO_INCREMENT PRIMARY KEY,
    order_id INT NOT NULL,
    product_id INT NOT NULL,
    quantity INT NOT NULL,
    price DOUBLE NOT NULL,
    FOREIGN KEY (order_id) REFERENCES orders(id),
    FOREIGN KEY (product_id) REFERENCES products(id)
);

-- Thêm dữ liệu mẫu
INSERT INTO customers (name, email, phone, address) VALUES
('Nguyễn Văn A', 'nguyenvana@email.com', '0901234567', 'Hà Nội'),
('Trần Thị B', 'tranthib@email.com', '0909876543', 'Hồ Chí Minh'),
('Lê Văn C', 'levanc@email.com', '0912345678', 'Đà Nẵng');

INSERT INTO products (name, description, price, stock_quantity) VALUES
('Laptop Dell XPS 13', 'Laptop cao cấp, Core i7, RAM 16GB', 30000000, 10),
('iPhone 15 Pro', 'Điện thoại cao cấp của Apple', 28000000, 15),
('Tai nghe Sony WH-1000XM5', 'Tai nghe chống ồn cao cấp', 7500000, 20),
('Bàn phím cơ Logitech G Pro', 'Bàn phím gaming', 2500000, 30),
('Chuột Logitech MX Master 3', 'Chuột không dây cao cấp', 1800000, 25);