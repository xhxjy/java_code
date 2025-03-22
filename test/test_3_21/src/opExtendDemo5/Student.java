package opExtendDemo5;

public class Student extends Person{
    private String school;
    private String stuId;

    public Student() {
    }

    public Student(String name, String gender, String school, String stuId) {
        super(name, gender);
        this.school = school;
        this.stuId = stuId;
    }

    public String getSchool() {
        return school;
    }

    public void setSchool(String school) {
        this.school = school;
    }

    public String getStuId() {
        return stuId;
    }

    public void setStuId(String stuId) {
        this.stuId = stuId;
    }

    //行为

    @Override
    public void work() {
        System.out.println("学习");
    }
}
