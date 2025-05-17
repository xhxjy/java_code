package a01mystream;

import java.util.Arrays;
import java.util.stream.Stream;

public class StreamDemo4 {
    public static void main(String[] args) {
        // 数组          public static <T> Stream<T> stream(T[] array)        Arrays工具类中的静态方法

        int[] arr1={1,4,6,8};
        String[] arr2={"a","c","d"};
        Arrays.stream(arr1).forEach(s-> System.out.println(s));
        Arrays.stream(arr2).forEach(s-> System.out.println(s));
        //数组获取stream流也可以用Stream接口中的静态方法
        //前提是数组的数据类型为引用数据类型;反之,则会得到数组的地址值
        Stream.of(arr1).forEach(s-> System.out.println(s));
        Stream.of(arr2).forEach(s-> System.out.println(s));



























       /* //1.创建数组
        int[] arr1 = {1,2,3,4,5,6,7,8,9,10};

        String[] arr2 = {"a","b","c"};


        //2.获取stream流
        // Arrays.stream(arr1).forEach(s-> System.out.println(s));

        //System.out.println("============================");

        //Arrays.stream(arr2).forEach(s-> System.out.println(s));


        //System.out.println("============================");


        //注意：
        //Stream接口中静态方法of的细节
        //方法的形参是一个可变参数，可以传递一堆零散的数据，也可以传递数组
        //但是数组必须是引用数据类型的，如果传递基本数据类型，是会把整个数组当做一个元素，放到Stream当中。
        Stream.of(arr1).forEach(s-> System.out.println(s));//[I@41629346*/




    }
}
