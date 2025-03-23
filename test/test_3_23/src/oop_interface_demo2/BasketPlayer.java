package oop_interface_demo2;

public class BasketPlayer extends Player{
    public BasketPlayer() {
    }

    public BasketPlayer(String name, int age) {
        super(name, age);
    }

    @Override
    public void stuPlay() {
        System.out.println("学习篮球");
    }
}
