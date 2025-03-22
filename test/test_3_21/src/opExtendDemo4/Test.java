package opExtendDemo4;

public class Test {
    public static void main(String[] args) {
        Lecturer l=new Lecturer("001","zqg");
        System.out.println(l.getId()+","+l.getName());
        l.work();
    }
}
