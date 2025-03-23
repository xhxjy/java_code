package oop_interface_demo2;

public class BasketCoach extends Coach{
    public BasketCoach() {
    }

    public BasketCoach(String name, int age) {
        super(name, age);
    }

    @Override
    public void stuCoach() {
        System.out.println("学教篮球");
    }
}
