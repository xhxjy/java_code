package myobjectstream;

import java.io.Serial;
import java.io.Serializable;

//对象可以被序列化的两个前提:
/*
* 1.对象要实现标记接口:Serializable,表示该对象可被序列化和反序列化
* 2.对象的所有属性可被序列化;若有属性不想被序列化,需要用transient修饰,该属性最后被序列化得到的值是对应类型的初始值
* */
public class Student implements Serializable {
    //serialVersionUID:该类对应的版本号
    //防止序列化后,修改该类再次序列化报错
    @Serial
    private static final long serialVersionUID = -6836389873013001547L;
    private String name;
    private int age;
    private transient String address;


    public Student() {
    }

    public Student(String name, int age, String address) {
        this.name = name;
        this.age = age;
        this.address = address;
    }

    /**
     * 获取
     * @return name
     */
    public String getName() {
        return name;
    }

    /**
     * 设置
     * @param name
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * 获取
     * @return age
     */
    public int getAge() {
        return age;
    }

    /**
     * 设置
     * @param age
     */
    public void setAge(int age) {
        this.age = age;
    }

    /**
     * 获取
     * @return address
     */
    public String getAddress() {
        return address;
    }

    /**
     * 设置
     * @param address
     */
    public void setAddress(String address) {
        this.address = address;
    }

    public String toString() {
        return "Student{name = " + name + ", age = " + age + ", address = " + address + "}";
    }
}
