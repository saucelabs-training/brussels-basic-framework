package test.java.com.saucelabs.data;

public class User {
    private String username;
    private String password;

    public static User valid() {
        User user = new User();
        user.username = "standard_user";
        user.password = "secret_sauce";
        return user;
    }

    public static User invalid() {
        User user = new User();
        user.username = "locked_out_user";
        user.password = "secret_sauce";
        return user;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }
}
