package mylog;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Scanner;

public class LogDemo1 {
    //获取日志对象
    public static final Logger LOGGER = LoggerFactory.getLogger(LogDemo1.class);

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("请输入用户名");
        String name = sc.nextLine();
        System.out.println("请输入密码");
        String password = sc.nextLine();
        if ("zhangsan".equals(name) && "123".equals(password)) {
            System.out.println("登陆成功");
            LOGGER.info("用户在..点登陆成功,用户名为" + name + "密码为" + password);
        } else {
            System.out.println("登陆失败");
            LOGGER.info("用户在..点登陆失败,用户名为" + name + "密码为" + password);
        }
    }
}
