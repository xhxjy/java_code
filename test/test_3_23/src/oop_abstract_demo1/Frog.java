package oop_abstract_demo1;

public class Frog extends Animal{
    public Frog() {
    }

    public Frog(String name, int age) {
        super(name, age);
    }

    @Override
    public void eat() {
        System.out.println("吃虫子");
    }

    public void show(){
        System.out.println(getName()+","+getAge());
    }
}
