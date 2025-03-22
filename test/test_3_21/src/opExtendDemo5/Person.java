package opExtendDemo5;

public class Person {
    private String name;
    private String gender;

    public Person() {
    }

    public Person(String name, String gender) {
        this.name = name;
        this.gender = gender;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    //行为
    public void eat(){
        System.out.println("吃饭");
    }
    public void work(){
        System.out.println("工作");
    }
}
