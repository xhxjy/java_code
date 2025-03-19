package test_3_18;

public class Person {
    private String name;
    private String password;
    private String address;
    private String gender;
    private double height;

    public Person() {
    }

    public Person(String name, String password, String address, String gender, double height) {
        this.name = name;
        this.password = password;
        this.address = address;
        this.gender = gender;
        this.height = height;
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

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public double getHeight() {
        return height;
    }

    public void setHeight(double height) {
        this.height = height;
    }
}
