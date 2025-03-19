package test_3_19;

import java.util.ArrayList;
import java.util.Scanner;

public class UserTest {
    public static void main(String[] args) {
        ArrayList<User> list=new ArrayList<>();
        Scanner sc=new Scanner(System.in);

        //创建对象,并给对象赋值,将它们添加进集合中
//        for (int i = 0; i < 3; i++) {
//            //创建对象

//
//            System.out.println("请输入你的id");
//            String id = sc.next();
//            user.setId(id);
//            System.out.println("请输入你的用户名");
//            String username = sc.next();
//            user.setUserName(username);
//            System.out.println("请输入你的密码");
//            String password = sc.next();
//            user.setPassword(password);
//
//            list.add(user);
//        }
        User user1=new User("101","xhxjy1","xhxjy5201");
        User user2=new User("102","xhxjy2","xhxjy5202");
        User user3=new User("103","xhxjy3","xhxjy5203");

        list.add(user1);
        list.add(user2);
        list.add(user3);

        System.out.println("请输入你要查询的id");
        String id = sc.next();
        System.out.println(check(list,id));
        System.out.println(getIndex(list,id));
    }
    public static int getIndex(ArrayList<User> list,String id){//id和集合
        //遍历集合
        for (int i = 0; i < list.size(); i++) {
            if(list.get(i).getId().equals(id)){
                return i;
            }
        }
        return -1;
    }
    public static boolean check(ArrayList<User> list,String id){//id和集合
        //遍历集合
//        for (int i = 0; i < list.size(); i++) {
//            if(list.get(i).getId().equals(id)){
//                return i;
//            }
//        }
//        return -1;
        return getIndex(list,id)>=0;
    }
}
