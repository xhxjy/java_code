package test_3_19;

import java.util.ArrayList;
import java.util.Scanner;

public class BookTest {
    public static void main(String[] args) {
        //创建一个集合存储图书对象
        ArrayList<Book> list=new ArrayList<>();
        while (true) {
            menu();
            System.out.println("请输入你的选项:");
            Scanner sc = new Scanner(System.in);
            int choice = sc.nextInt();
            switch (choice) {
                case 1:
                    add(list);
                    break;
                case 2:
                    checkAll(list);
                    break;
                case 3:
                    checkSingle(list);
                    break;
                case 4:
                    remove(list);
                    break;
                case 5:
                    set(list);
                    break;
                case 6:
                    System.out.println("系统已退出");
                    System.exit(0);
                    break;
                default:
                    System.out.println("输入错误,请重新输入");
                    break;
            }
        }
    }

    //菜单
    public static void menu() {
        System.out.println("------------------------图书管理系统---------------------");
        System.out.println("1.添加  2.查询(所有)  3.查询(单本)  4.删除  5.修改  6.退出");
        System.out.println("--------------------------------------------------------");
    }

    //添加图书
    public static void add(ArrayList<Book> list) {
        Book book=new Book();
        Scanner sc=new Scanner(System.in);
        System.out.println("请输入书的编号:");
        String id = sc.next();
        book.setId(id);
        //编号是否存在
        //存在
        if (isExit(list,id)){
            System.out.println("编号重复,请重新添加");
            return;
        }
        System.out.println("请输入书的名字:");
        String name = sc.next();
        book.setName(name);
        System.out.println("请输入书的作者:");
        String writer = sc.next();
        book.setWriter(writer);
        list.add(book);
        System.out.println("添加成功");
    }

    //查询全部
    public static void checkAll(ArrayList<Book> list) {
        for (int i = 0; i < list.size(); i++) {
            Book book = list.get(i);
            System.out.println(book.getId()+","+book.getName()+","+book.getWriter());
        }
    }

    //查询单本
    public static void checkSingle(ArrayList<Book> list) {
            System.out.println("请输入你要查询的图书的id:");
            Scanner sc=new Scanner(System.in);
            String id = sc.next();
            int index = getIndex(list, id);
            Book book = list.get(index);
            if(book.getId().equals(id)){
                System.out.println(book.getId()+","+book.getName()+","+book.getWriter());
                return;
            }
            System.out.println("id不存在,请重新输入");
    }

    //删除图书
    public static void remove(ArrayList<Book> list) {
        System.out.println("请输入你要删除的图书的id:");
        Scanner sc=new Scanner(System.in);
        String id = sc.next();
        int index = getIndex(list, id);
        if(isExit(list,id)){//不可在该处使用isExit方法,因为会使i--失效,达不到删除的效果
            list.remove(index);//若后续不会用到后面的元素则无需--,直接输入i即可
            System.out.println("删除成功");
        }
        else{
            System.out.println("id不存在,请重新输入");
        }
    }

    //修改
    public static void set(ArrayList<Book> list) {
        System.out.println("请输入你要修改的图书的id:");
        Scanner sc=new Scanner(System.in);
        String id = sc.next();
        int index = getIndex(list, id);
        if(isExit(list,id)){
            Book book=list.get(index);//要修改图书的对象
            bookMenu();
            System.out.println("请输入你的选项:");
            int choice = sc.nextInt();
            switch (choice) {
                case 1:
                    System.out.println("请输入书的名字:");
                    String name = sc.next();
                    book.setName(name);
                    break;
                case 2:
                    System.out.println("请输入书的作者:");
                    String writer = sc.next();
                    book.setWriter(writer);
                    break;
                default:
                    System.out.println("输入错误,重新输入");
                    break;
            }
            System.out.println("修改成功");
        }
        else{
            System.out.println("id不存在,请重新输入");
        }
    }

    //修改菜单
    public static void bookMenu(){
        System.out.println("1.修改书名");
        System.out.println("2.修改作者");
    }

    //编号是否存在(多个地方使用)
    public static boolean isExit(ArrayList<Book> list,String id){

//        for (int i = 0; i < list.size(); i++) {
//            Book book = list.get(i);
//            if(book.getId().equals(id)){
//                return true;
//            }
//        }
//        return false;
        return getIndex(list, id) >= 0;//与getIndex代码重合,为true表示存在,反之不存在
    }

    //返回存在的编号的索引
    public static int getIndex(ArrayList<Book> list,String id){
        for (int i = 0; i < list.size(); i++) {
            Book book = list.get(i);
            if(book.getId().equals(id)){
                return i;
            }
        }
        return -1;//当list.size()为0时,也可以判断,表示不存在
    }
}
//没必要在过于细枝末节的地方纠结
