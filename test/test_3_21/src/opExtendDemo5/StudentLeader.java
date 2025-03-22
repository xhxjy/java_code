package opExtendDemo5;

public class StudentLeader extends Student{
    private String job;

    public StudentLeader() {
    }

    public StudentLeader(String name, String gender, String school, String stuId, String job) {
        super(name, gender, school, stuId);
        this.job = job;
    }

    public String getJob() {
        return job;
    }

    public void setJob(String job) {
        this.job = job;
    }

    //行为
    public void meeting() {
        System.out.println("开会");
    }
}
