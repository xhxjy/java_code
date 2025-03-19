package test_3_19;

public class Worker {
    private String name;
    private int wages;

    public Worker() {
    }

    public Worker(String name, int wages) {
        this.name = name;
        this.wages = wages;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getWages() {
        return wages;
    }

    public void setWages(int wages) {
        this.wages = wages;
    }
}
