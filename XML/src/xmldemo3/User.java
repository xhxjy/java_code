package xmldemo3;

public class User {
    private String id;
    private String username;
    private String password;
    private String phoneId;
    private boolean admin;

    public User() {
    }

    public User(String id, String username, String password, String phoneId, boolean admin) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.phoneId = phoneId;
        this.admin = admin;
    }

    /**
     * 获取
     * @return id
     */
    public String getId() {
        return id;
    }

    /**
     * 设置
     * @param id
     */
    public void setId(String id) {
        this.id = id;
    }

    /**
     * 获取
     * @return username
     */
    public String getUsername() {
        return username;
    }

    /**
     * 设置
     * @param username
     */
    public void setUsername(String username) {
        this.username = username;
    }

    /**
     * 获取
     * @return password
     */
    public String getPassword() {
        return password;
    }

    /**
     * 设置
     * @param password
     */
    public void setPassword(String password) {
        this.password = password;
    }

    /**
     * 获取
     * @return phoneId
     */
    public String getPhoneId() {
        return phoneId;
    }

    /**
     * 设置
     * @param phoneId
     */
    public void setPhoneId(String phoneId) {
        this.phoneId = phoneId;
    }

    /**
     * 获取
     * @return admin
     */
    public boolean isAdmin() {
        return admin;
    }

    /**
     * 设置
     * @param admin
     */
    public void setAdmin(boolean admin) {
        this.admin = admin;
    }

    public String toString() {
        return "User{id = " + id + ", username = " + username + ", password = " + password + ", phoneId = " + phoneId + ", admin = " + admin + "}";
    }
}
