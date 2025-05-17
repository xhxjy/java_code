package test;

import java.util.ArrayList;

public class excise1 {
    public static void main(String[] args) {
        ArrayList<Book> list=new ArrayList<>();
        list.add(new Book(1,12.4,"xjy"));
        list.add(new Book(2,12.6,"zqg"));
        list.add(new Book(3,12.5,"sjj"));
        for (int i = 0; i < list.size(); i++) {
            System.out.println(list.get(i));
        }
    }
}
