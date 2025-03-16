package excise1;

public class Cat {
    //属性
    private String color;
    private String breed;
    public Cat(){

    }
    public Cat(String color,String breed){
        this.color=color;
        this.breed=breed;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getColor() {
        return color;
    }

    public void setBreed(String breed) {
        this.breed = breed;
    }

    public String getBreed() {
        return breed;
    }
    //行为
    public void eat(){
        System.out.println(color+"的"+breed+"在吃鱼");
    }
    public void catchMouse(){
        System.out.println(color+"的"+breed+"在抓老鼠");
    }
}
