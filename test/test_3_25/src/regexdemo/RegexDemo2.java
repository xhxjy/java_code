package regexdemo;

public class RegexDemo2 {
    public static void main(String[] args) {
//        String regex1="1[3-9]\\d{9}";
//        Scanner sc=new Scanner(System.in);
//        String str=sc.next();
//        System.out.println(str.matches(regex1));

        //3232323@qq.com zhangsan@itcast.cnn dlei0009@163.com dlei0009@pci.com.cn
        //思路:
        //1.@左边的:\\w+
        //2.@本身:@
        //3.@右边的,'.'左边的:[a-z0-9]{2,6}
        //4.'.'本身:\.
        //5.'.'右边的c[a-z]{1,2}.?[a-z]*
        String regex2="\\w+@[a-z0-9]{2,6}\\.c[a-z]{1,2}.?[a-z]*";
        System.out.println("zhangsan@itcast.cnn".matches(regex2));
        System.out.println("3232323@qq.com".matches(regex2));
        System.out.println("dlei0009@163.com".matches(regex2));
        System.out.println("dlei0009@pci.com.cn".matches(regex2));

//        //020-2324242 02122442 027-42424 0712-3242434
//        String regex3="0\\d{2,3}-?[1-9]\\d{4,6}";
//        System.out.println("020-2324242".matches(regex3));
//        System.out.println("02122442".matches(regex3));
//        System.out.println("027-42424".matches(regex3));
//        System.out.println("0712-3242434".matches(regex3));

        String regex4="(?:[01]\\d|2[0-3]):[0-5]\\d:[0-5]\\d";
    }
}
