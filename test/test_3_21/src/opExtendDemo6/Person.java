package opExtendDemo6;

public class Person {
    private String name;
    private int age;

    //应用场景:自定义数据类型的初始化值
    public Person() {
        //这里的this表示调用本类中的其它构造方法,即带参构造方法
        //细节:jvm不会再添加super()
        this(null,18);
    }

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
    //行为
    public void keepPet(Dog dog,String sth){
        dog.eat(sth);
    }
    public void keepPet(Cat cat,String sth){
        cat.eat(sth);
    }
}
