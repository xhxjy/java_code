package opExtendDemo1;

public class Animal {
    //行为
    //注意:子类只能访问父类中非私有的成员
    public void eat(){
        System.out.println("吃饭");
    }
    public void drink(){
        System.out.println("喝水");
    }
}

