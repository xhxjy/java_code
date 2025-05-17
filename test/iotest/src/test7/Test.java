package test7;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class Test {
    public static void main(String[] args) throws IOException {
        /*
        需求：写一个登陆小案例。

        步骤：
            将正确的用户名和密码手动保存在本地的userinfo.txt文件中。
            保存格式为:username=zhangsan&password=123
            让用户键盘录入用户名和密码
                    比较用户录入的和正确的用户名密码是否一致
            如果一致则打印登陆成功
                    如果不一致则打印登陆失败
        */
        //读取文件中正确的用户名和密码
        BufferedReader br=new BufferedReader(new FileReader("iotest\\src\\test7\\userinfo.txt"));
        String content = br.readLine();
        String[] info = content.split("&");
        String userName = info[0].split("=")[1];
        String password = info[1].split("=")[1];
        //将正确的用户名和密码封装为一个用户对象
        User rightUser = new User(userName, password);
        //键盘录入用户名和密码
        Scanner sc=new Scanner(System.in);
        while (true) {
            System.out.println("请输入用户名");
            String name = sc.nextLine();
            System.out.println("请输入密码");
            String code = sc.nextLine();
            //将用户名和密码封装为一个用户对象
            User user = new User(name, code);
            if(rightUser.equals(user)){//此处需要重写equals方法
                System.out.println("登陆成功");
                break;
            }else{
                System.out.println("登陆失败,请重新输入");
            }
        }

    }
}
