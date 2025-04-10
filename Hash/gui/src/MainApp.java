import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MainApp {
    private static UserManager userManager = new UserManager();

    public static void main(String[] args) {
        JFrame frame = new JFrame("User Registration");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 300);
        frame.setLayout(null);

        JLabel registerLabel = new JLabel("Register User:");
        registerLabel.setBounds(30, 30, 100, 25);
        frame.add(registerLabel);

        JTextField registerUsername = new JTextField();
        registerUsername.setBounds(150, 30, 200, 25);
        frame.add(registerUsername);

        JPasswordField registerPassword = new JPasswordField();
        registerPassword.setBounds(150, 70, 200, 25);
        frame.add(registerPassword);

        JButton registerButton = new JButton("Register");
        registerButton.setBounds(150, 110, 100, 30);
        frame.add(registerButton);

        JButton openLoginButton = new JButton("Open Login");
        openLoginButton.setBounds(150, 160, 120, 30);
        frame.add(openLoginButton);

        registerButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String username = registerUsername.getText();
                String password = new String(registerPassword.getPassword());
                userManager.register(username, password);
                JOptionPane.showMessageDialog(frame, "User registered successfully!");
            }
        });

        openLoginButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                LoginFrame loginFrame = new LoginFrame(userManager);
                loginFrame.setVisible(true);
                frame.dispose(); // Đóng cửa sổ đăng ký
            }
        });

        frame.setVisible(true);
    }
}
