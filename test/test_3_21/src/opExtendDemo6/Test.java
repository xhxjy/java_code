package opExtendDemo6;

public class Test {
    public static void main(String[] args) {
        Person p=new Person();
        Dog dog=new Dog("黄",18);
        Cat cat=new Cat("黑",10);
        p.keepPet(dog,"骨头");
        p.keepPet(cat,"猫粮");
    }
}
