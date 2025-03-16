package excise2;

public class Manager {
    private String name;
    private int id;
    private int salary;
    private int bonus;
    public Manager(){

    }
    public Manager(String name,int id,int salary,int bonus){
        this.name = name;
        this.id = id;
        this.salary = salary;
        this.bonus = bonus;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }

    public int getSalary() {
        return salary;
    }

    public void setBonus(int bonus) {
        this.bonus = bonus;
    }

    public int getBonus() {
        return bonus;
    }
    //行为
    public void work(){
        System.out.println("工号为"+this.id+"基本工资为"+this.salary
                +"奖金为"+this.bonus+"项目经理"+this.name+"在工作");
    }
}
