package excise3;

public class GF {
    private String name;
    private int age;
    private char gender;
    private String hobby;

    public GF() {
    }

    public GF(String name, int age, char gender, String hobby) {
        this.name = name;
        this.age = age;
        this.gender = gender;
        this.hobby = hobby;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public char getGender() {
        return gender;
    }

    public void setGender(char gender) {
        this.gender = gender;
    }

    public String getHobby() {
        return hobby;
    }

    public void setHobby(String hobby) {
        this.hobby = hobby;
    }

    //行为
    //打印信息
    public void showInfo() {
        System.out.println("姓名:" + name + ",年龄:" + age + "," +
                "性别:" + gender + ",爱好:" + hobby);
    }
}
