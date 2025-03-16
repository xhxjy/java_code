package String;

import java.util.Scanner;

public class Excise1 {
    public static void main(String[] args) {
        String rightName = "xjy";
        String rightPassword = "ixhxjy1314";
        for (int i = 0; i < 3; i++) {
            Scanner sc = new Scanner(System.in);
            System.out.println("请输入用户名");
            String name = sc.next();
            System.out.println("请输入密码");
            String password = sc.next();
            if (name.equals(rightName) && password.equals(rightPassword)) {
                System.out.println("登录成功");
                break;
            } else
                System.out.println("用户名或密码输入错误,请重新输入!您还剩" + (3 - (i + 1)) + "次机会");
        }
    }
}
