package test_3_18;

import java.util.Scanner;

public class PersonTest {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Person p=new Person();
        while(true){
            menu();
            System.out.println("请输入你的选项");
            int choice = sc.nextInt();
            switch(choice){
                case 1:signUp(p);
                        break;
                case 2:signIn(p);
                        break;
                case 3:System.out.println("退出");
                    System.exit(0);
                        break;
                default:
                    System.out.println("选项不存在，重新输入");
                    break;
            }
        }
    }
    public static void menu(){
        System.out.println("婚恋网站");
        System.out.println("---------------------------------------------------------");
        System.out.printf("\t1.注册\t2.登录\t3.退出\n");
        System.out.println("---------------------------------------------------------");
    }
    public static void signUp(Person p){
        Scanner sc = new Scanner(System.in);
        System.out.println("性别");
        String gender = sc.next();
        p.setGender(gender);
        System.out.println("常住地");
        String address = sc.next();
        p.setAddress(address);
        System.out.println("身高");
        double height = sc.nextDouble();
        p.setHeight(height);
        System.out.println("名字");
        String name = sc.next();
        p.setName(name);
        System.out.println("密码");
        String password = sc.next();
        p.setPassword(password);
    }
    public static void signIn(Person p){
        Scanner sc = new Scanner(System.in);
        while (true) {
            System.out.println("用户名：");
            String name = sc.next();
            System.out.println("密码：");
            String password = sc.next();
            if(p.getName().equals(name) && p.getPassword().equals(password)){
                System.out.println("登录成功");
                break;
            }else{
                System.out.println("密码或用户名错误，请重新输入");
            }
        }
    }
}
