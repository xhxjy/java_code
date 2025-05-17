package test;

public class PersianCat extends Cat{
    @Override
    public void eat() {
        System.out.println("一只叫做"+getName()+getAge()+"波斯猫,在吃饼干");
    }
}
