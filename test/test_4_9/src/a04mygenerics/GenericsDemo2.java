package a04mygenerics;

public class GenericsDemo2 {
    public static void main(String[] args) {
       /* MyArrayList<String> list = new MyArrayList<>();

        list.add("aaa");
        list.add("bbb");
        list.add("ccc");


        System.out.println(list);*/


        MyArrayList<Integer> list=new MyArrayList<>();
        list.add(111);
        list.add(222);
        list.add(333);

        System.out.println(list.get(0));
        System.out.println(list.toString());














        /*MyArrayList<Integer> list2 = new MyArrayList<>();
        list2.add(123);
        list2.add(456);
        list2.add(789);


        int i = list2.get(0);
        System.out.println(i);


        System.out.println(list2);*/
    }
}
