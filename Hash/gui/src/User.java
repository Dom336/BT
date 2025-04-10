public class User {
    private String username;
    private String hashedPassword;

    // Constructor
    public User(String username, String hashedPassword) {
        this.username = username;
        this.hashedPassword = hashedPassword;
    }

    // Getters and setters
    public String getUsername() {
        return username;
    }

    public String getHashedPassword() {
        return hashedPassword;
    }

    @Override
    public String toString() {
        return "User{username='" + username + "'}";
    }
}
