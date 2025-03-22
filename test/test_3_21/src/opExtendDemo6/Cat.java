package opExtendDemo6;

public class Cat extends Animal{
    public Cat() {
    }

    public Cat(String color, int age) {
        super(color, age);
    }
    //行为
//    public void eat(String sth){
//    }

    @Override
    public void eat(String sth) {
        System.out.println("颜色为"+getColor()+"色的"+getAge()
                +"岁的猫,"+"在吃"+sth);
    }

    public void catchMouse(){
        System.out.println("捉老鼠");
    }
}
