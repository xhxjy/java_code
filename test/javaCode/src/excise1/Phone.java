package excise1;

public class Phone {
    //属性
    private String brand;
    private int price;
    private String color;
    public Phone(){

    }
    public Phone(String brand,int price,String color){
        this.brand=brand;
        this.price=price;
        this.color=color;
    }
    public void setBrand(String brand){
        this.brand=brand;
    }
    public void setPrice(int price){
        this.price=price;
    }
    public void setColor(String color){
        this.color=color;
    }
    public String getBrand(){
        return this.brand;
    }
    public int getPrice(){
        return this.price;
    }
    public String getColor(){
        return this.color;
    }
    //行为
    //打电话
    public void call(){
        System.out.println("使用价格为"+this.price+"颜色为"+this.color+"的"+this.brand+"手机打电话");
    }
    //发消息
    public void sendMessage(){
        System.out.println("使用价格为"+this.price+"颜色为"+this.color+"的"+this.brand+"手机发消息");

    }
}
