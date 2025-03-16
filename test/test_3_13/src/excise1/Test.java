package excise1;

public class Test {
    public static void main(String[] args) {
        //定义猫
        Cat a=new Cat();
        a.setColor("花色");
        a.setBreed("狸花猫");
        a.eat();
        a.catchMouse();
        //定义狗
        Dog b=new Dog("黄色","柯基");
        b.eat();
        b.lookHome();
    }
}
