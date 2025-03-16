package excise1;

public class Dog {
    //属性
    private String color;
    private String breed;
    public Dog(){

    }
    public Dog(String color,String breed){
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
        System.out.println(color+"的"+breed+"在吃史");
    }
    public void lookHome(){
        System.out.println(color+"的"+breed+"在看家");
    }
}
