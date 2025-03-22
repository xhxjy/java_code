package opExtendDemo3;

public class Test {
    public static void main(String[] args) {
        Manager m = new Manager("001", "zqg", 18000, 5000);
        System.out.println(m.getId() + "," + m.getName() + "," +
                m.getSalary() + "," + m.getManageBonus());
    }
}
