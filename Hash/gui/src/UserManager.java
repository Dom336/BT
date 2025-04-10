import org.mindrot.jbcrypt.BCrypt;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.*;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import org.w3c.dom.*;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class UserManager {
    private List<User> users = new ArrayList<>();

    // Đăng ký người dùng
    public void register(String username, String password) {
        String hashedPassword = BCrypt.hashpw(password, BCrypt.gensalt());
        users.add(new User(username, hashedPassword));
    }

    // Đăng nhập
    public boolean login(String username, String password) {
        for (User user : users) {
            if (user.getUsername().equals(username)) {
                return BCrypt.checkpw(password, user.getHashedPassword());
            }
        }
        return false;
    }

    // Xuất thông tin người dùng ra XML
    public void exportToXML(String filePath) throws Exception {
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder = factory.newDocumentBuilder();
        Document doc = builder.newDocument();

        // Root element
        Element root = doc.createElement("Users");
        doc.appendChild(root);

        for (User user : users) {
            Element userElement = doc.createElement("User");
            root.appendChild(userElement);

            Element username = doc.createElement("Username");
            username.appendChild(doc.createTextNode(user.getUsername()));
            userElement.appendChild(username);
        }

        // Write to file
        TransformerFactory transformerFactory = TransformerFactory.newInstance();
        Transformer transformer = transformerFactory.newTransformer();
        DOMSource source = new DOMSource(doc);
        StreamResult result = new StreamResult(new File(filePath));
        transformer.setOutputProperty(OutputKeys.INDENT, "yes");
        transformer.transform(source, result);
    }

    // Nhập dữ liệu từ XML
    public void importFromXML(String filePath) throws Exception {
        users.clear();

        File xmlFile = new File(filePath);
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder = factory.newDocumentBuilder();
        Document doc = builder.parse(xmlFile);

        NodeList nodeList = doc.getElementsByTagName("User");
        for (int i = 0; i < nodeList.getLength(); i++) {
            Node node = nodeList.item(i);
            if (node.getNodeType() == Node.ELEMENT_NODE) {
                Element element = (Element) node;
                String username = element.getElementsByTagName("Username").item(0).getTextContent();
                // Bỏ qua mật khẩu
                users.add(new User(username, ""));
            }
        }
    }

    public List<User> getUsers() {
        return users;
    }
}
