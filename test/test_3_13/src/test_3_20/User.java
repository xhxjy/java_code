package test_3_20;

public class User {
    private String name;
    private String password;
    private String idNum;
    private String phoneNum;

    public User() {
    }

    public User(String name, String password, String idNum, String phoneNum) {
        this.name = name;
        this.password = password;
        this.idNum = idNum;
        this.phoneNum = phoneNum;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getIdNum() {
        return idNum;
    }

    public void setIdNum(String idNum) {
        this.idNum = idNum;
    }

    public String getPhoneNum() {
        return phoneNum;
    }

    public void setPhoneNum(String phoneNum) {
        this.phoneNum = phoneNum;
    }
}
