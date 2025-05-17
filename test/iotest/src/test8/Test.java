package test8;

import java.io.*;
import java.util.Scanner;

public class Test {
    public static void main(String[] args) throws IOException {
        /*
        需求：写一个登陆小案例（添加锁定账号功能）

        步骤：
        	将正确的用户名和密码手动保存在本地的userinfo.txt文件中。
        	保存格式为:username=zhangsan&password=123&count=0
        	让用户键盘录入用户名和密码
        	比较用户录入的和正确的用户名密码是否一致
        	如果一致则打印登陆成功
        	如果不一致则打印登陆失败，连续输错三次被锁定

        */
        //读取文件中正确的用户名和密码
        BufferedReader br = new BufferedReader(new FileReader("iotest\\src\\test8\\userinfo.txt"));
        String content = br.readLine();
        br.close();
        String[] info = content.split("&");
        String userName = info[0].split("=")[1];
        String password = info[1].split("=")[1];
        int count = Integer.parseInt(info[2].split("=")[1]);
        //将正确的用户名和密码封装为一个用户对象
        test8.User rightUser = new test8.User(userName, password);
        //键盘录入用户名和密码
        Scanner sc = new Scanner(System.in);

        System.out.println("请输入用户名");
        String name = sc.nextLine();
        System.out.println("请输入密码");
        String code = sc.nextLine();
        //将用户名和密码封装为一个用户对象
        User user = new User(name, code);
        if (count < 3) {
            if (rightUser.equals(user)) {//此处需要重写equals方法
                System.out.println("登陆成功");
                //输对一次,将次数清零
                count = 0;
                String s = rightUser.toString() + "&count=" + count;
                BufferedWriter bw = new BufferedWriter(new FileWriter("iotest\\src\\test8\\userinfo.txt"));
                bw.write(s);
                bw.close();
            } else {
                count++;
                //将修改的次数重新写入文件中
                //整理文本格式
                //细节:重写了user类的tostring方法
                String s = rightUser.toString() + "&count=" + count;
                BufferedWriter bw = new BufferedWriter(new FileWriter("iotest\\src\\test8\\userinfo.txt"));
                bw.write(s);
                bw.close();
                System.out.println("登陆失败,请重新输入,还剩下"+(3-count)+"次机会");
            }
        } else {
            System.out.println("账号已被锁定");
        }
    }
}
