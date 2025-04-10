import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class LoginFrame extends JFrame {
    private UserManager userManager;

    public LoginFrame(UserManager userManager) {
        this.userManager = userManager;

        // Cấu hình cửa sổ
        setTitle("Login");
        setSize(300, 200);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLayout(null);

        // Các thành phần giao diện
        JLabel usernameLabel = new JLabel("Username:");
        usernameLabel.setBounds(30, 30, 80, 25);
        add(usernameLabel);

        JTextField usernameField = new JTextField();
        usernameField.setBounds(120, 30, 150, 25);
        add(usernameField);

        JLabel passwordLabel = new JLabel("Password:");
        passwordLabel.setBounds(30, 70, 80, 25);
        add(passwordLabel);

        JPasswordField passwordField = new JPasswordField();
        passwordField.setBounds(120, 70, 150, 25);
        add(passwordField);

        JButton loginButton = new JButton("Login");
        loginButton.setBounds(100, 120, 100, 30);
        add(loginButton);

        // Xử lý sự kiện đăng nhập
        loginButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String username = usernameField.getText();
                String password = new String(passwordField.getPassword());

                if (userManager.login(username, password)) {
                    JOptionPane.showMessageDialog(LoginFrame.this, "Login successful!");
                    dispose(); // Đóng cửa sổ đăng nhập
                    XmlManagerFrame xmlManagerFrame = new XmlManagerFrame(userManager);
                    xmlManagerFrame.setVisible(true); // Mở giao diện xuất/nhập XML
                } else {
                    JOptionPane.showMessageDialog(LoginFrame.this, "Invalid credentials. Try again.");
                }
            }
        });
    }
}
