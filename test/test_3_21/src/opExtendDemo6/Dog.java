package opExtendDemo6;

public class Dog extends Animal{
    public Dog() {
    }

    public Dog(String color, int age) {
        super(color, age);
    }

    //行为


    @Override
    public void eat(String sth) {
        System.out.println("颜色为"+getColor()+"色的"+getAge()
                +"岁的狗,"+"在吃"+sth);
    }

    public void lookHome(){
        System.out.println("看家");
    }
}
