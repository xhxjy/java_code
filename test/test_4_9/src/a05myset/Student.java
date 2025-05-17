package a05myset;

public class Student implements Comparable<Student>{
    private String name;
    private int age;


    public Student() {
    }

    public Student(String name, int age) {
        this.name = name;
        this.age = age;
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

    public String toString() {
        return "Student{name = " + name + ", age = " + age + "}";
    }

    //排序规则

    //this:当前要添加的元素
    //o:红黑树中存在的元素
    //返回值:
    //1.正数:表示大于,存右边
    //2.负数:表示小于,存左边
    //3.0:表示相等,舍弃
    @Override
    public int compareTo(Student o) {
        return this.getAge()-o.getAge();
    }
}
