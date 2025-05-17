package test;

import java.util.TreeSet;

public class excise2 {
    public static void main(String[] args) {
        /*HashSet<Book> hs=new HashSet<>();
        hs.add(new Book(1,12.4,"xjy"));
        hs.add(new Book(1,12.4,"xjy"));
        hs.add(new Book(2,12.6,"jjj"));
        hs.add(new Book(3,12.5,"lll"));
        for (Book b : hs) {
            System.out.println(b);
        }*/

        TreeSet<Book> ts=new TreeSet<>();
        ts.add(new Book(1,12.4,"xjy"));
        ts.add(new Book(3,12.5,"lll"));
        ts.add(new Book(2,12.6,"jjj"));
        for (Book b : ts) {
            System.out.println(b);
        }
    }
}
