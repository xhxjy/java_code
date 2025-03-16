package excise3;

public class Goods {
    private int id;
    private String name;
    private double price;
    private int remainNum;

    //构造方法
    public Goods() {
    }

    public Goods(int id, String name, double price, int remainNum) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.remainNum = remainNum;
    }

    //setter和getter

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getRemainNum() {
        return remainNum;
    }

    public void setRemainNum(int remainNum) {
        this.remainNum = remainNum;
    }
}
