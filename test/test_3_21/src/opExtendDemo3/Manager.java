package opExtendDemo3;

public class Manager extends Employee{
    private int manageBonus;

    public Manager() {
    }

    public Manager(String id, String name, int salary, int manageBonus) {
        super(id, name, salary);
        this.manageBonus = manageBonus;
    }

    public int getManageBonus() {
        return manageBonus;
    }

    public void setManageBonus(int manageBonus) {
        this.manageBonus = manageBonus;
    }

    @Override
    public void work() {
        System.out.println("管理别人");
    }
}
