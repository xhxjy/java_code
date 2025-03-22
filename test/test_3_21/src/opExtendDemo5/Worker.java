package opExtendDemo5;

public class Worker extends Person{
    private String unit;
    private String workAge;

    public Worker() {
    }

    public Worker(String name, String gender, String unit, String workAge) {
        super(name, gender);
        this.unit = unit;
        this.workAge = workAge;
    }

    public String getUnit() {
        return unit;
    }

    public void setUnit(String unit) {
        this.unit = unit;
    }

    public String getWorkAge() {
        return workAge;
    }

    public void setWorkAge(String workAge) {
        this.workAge = workAge;
    }

    //行为
    @Override
    public void work() {
        System.out.println("上班");
    }
}
