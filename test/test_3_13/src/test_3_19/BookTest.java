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
                    checkAll();
                    break;
                case 3:
                    checkSingle();
                    break;
                case 4:
                    remove();
                    break;
                case 5:
                    set();
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

    public static void add(ArrayList<Book> list) {
        Book book=new Book();
        Scanner sc=new Scanner(System.in);
        System.out.println("请输入书的编号:");

    }

    public static void checkAll() {

    }

    public static void checkSingle() {

    }

    public static void remove() {

    }

    public static void set() {

    }
}
