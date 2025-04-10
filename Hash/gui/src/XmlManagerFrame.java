import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class XmlManagerFrame extends JFrame {
    private UserManager userManager;

    public XmlManagerFrame(UserManager userManager) {
        this.userManager = userManager;

        // Cấu hình cửa sổ
        setTitle("XML Manager");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(null);

        // Các nút chức năng
        JButton exportButton = new JButton("Export to XML");
        exportButton.setBounds(100, 50, 200, 30);
        add(exportButton);

        JButton importButton = new JButton("Import from XML");
        importButton.setBounds(100, 100, 200, 30);
        add(importButton);

        JButton viewUsersButton = new JButton("View Users");
        viewUsersButton.setBounds(100, 150, 200, 30);
        add(viewUsersButton);

        // Xử lý sự kiện cho nút Export
        exportButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    userManager.exportToXML("users.xml");
                    JOptionPane.showMessageDialog(XmlManagerFrame.this, "Data exported to users.xml");
                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(XmlManagerFrame.this, "Error exporting data: " + ex.getMessage());
                }
            }
        });

        // Xử lý sự kiện cho nút Import
        importButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    userManager.importFromXML("users.xml");
                    JOptionPane.showMessageDialog(XmlManagerFrame.this, "Data imported from users.xml");
                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(XmlManagerFrame.this, "Error importing data: " + ex.getMessage());
                }
            }
        });

        // Xử lý sự kiện cho nút View Users
        viewUsersButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                StringBuilder userList = new StringBuilder("Users:\n");
                for (User user : userManager.getUsers()) {
                    userList.append(user.toString()).append("\n");
                }
                JOptionPane.showMessageDialog(XmlManagerFrame.this, userList.toString());
            }
        });
    }
}
