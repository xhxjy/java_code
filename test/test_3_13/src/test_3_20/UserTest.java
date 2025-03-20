package test_3_20;

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class UserTest {
    public static void main(String[] args) {
        //创建一个集合存储用户对象
        ArrayList<User> list = new ArrayList<>();
        while (true) {
            menu();
            System.out.println("请输入你的选项:");
            Scanner sc = new Scanner(System.in);
            int choice = sc.nextInt();
            switch (choice) {
                case 1:
                    signIn(list);
                    break;
                case 2:
                    signUp(list);
                    break;
                case 3:
                    forgotCode(list);
                    break;
                case 4:
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
        System.out.println("--------------图书管理系统-----------------");
        System.out.println("1.登录    2.注册    3.忘记密码    4.退出系统");
        System.out.println("------------------------------------------");
    }

    //3个大方法

    //注册
    public static void signUp(ArrayList<User> list) {
        //创建一个用户对象
        User user = new User();
        while (true) {
            //用户名
            //输入
            System.out.println("请输入用户名:");
            Scanner sc = new Scanner(System.in);
            String name = sc.next();
            //1.用户的唯一性
            boolean flag1 = contain(list, name);
            //2.长度判断
            int length = name.length();
            //3.字母与数字的组合,不能是纯数字
            boolean flag2 = judgeName(name);
            if ((length >= 3 && length <= 15) && !flag1 && flag2)
                user.setName(name);
            else {
                System.out.println("用户名不合法,请重新输入");
                continue;//返回循环重新输入
            }
            //密码
            System.out.println("请输入密码:");
            String password1 = sc.next();
            System.out.println("请再次输入密码:");
            String password2 = sc.next();
            if (password2.equals(password1)) {
                user.setPassword(password1);
            } else {
                System.out.println("密码不一致,请重新输入");
                continue;
            }
            //身份证号码
            System.out.println("请输入身份证号码:");
            String idNum = sc.next();
            //长度为18
            int length1 = idNum.length();
            //不能以0开头

            //前17位都是数字
            //最后一位可以是数字或X,x
            String idNumTest = idNum.substring(0, length1 - 1);//为了测试前17位是否都为数字的临时变量
            boolean flag3 = judgeNum(idNumTest);
            char c = idNum.charAt(0);
            if ((c != '0') && length1 == 18 && flag3) {
                user.setIdNum(idNum);
            } else {
                System.out.println("身份证号码不合法,请重新输入");
                continue;
            }

            //手机号
            System.out.println("请输入手机号:");
            String phoneNum = sc.next();
            //长度为11
            int length2 = phoneNum.length();
            char ch = phoneNum.charAt(0);
            //必须都为数字
            boolean flag4 = judgeNum(phoneNum);//将相似的代码复制过来时,记得改相应的方法名和系数
            if ((ch != '0') && length2 == 11 && flag4) {
                user.setPhoneNum(phoneNum);
                break;
            } else {
                System.out.println("手机号不合法,请重新输入");
            }
        }
        list.add(user);
        System.out.println("注册成功");
//        for (int i = 0; i < list.size(); i++) {
//            User u = list.get(i);
//            System.out.println(u.getName() + "," + u.getPassword() + ","
//                    + u.getIdNum() + "," + u.getPhoneNum());
//        }
    }

    //登录
    public static void signIn(ArrayList<User> list) {
        Scanner sc = new Scanner(System.in);
    loop:for (int i = 0; i < 3; i++) {
            System.out.println("请输入用户名:");
            String name = sc.next();
            boolean flag = contain(list, name);
            if (!flag) {
                System.out.println("用户名未注册,请先注册");
                return;
            }
            //此处已经判断了用户名输入正确
            else {
                //找到用户名对应的对象在集合中的索引
                int index = getIndex(list, name);
                User u = list.get(index);//找到对应的对象

                System.out.println("请输入密码:");
                String password = sc.next();
                while (true) {
                    //生成验证码()
                    String code = getCode();
                    System.out.println(code);
                    //输入验证码
                    System.out.println("请输入验证码:");
                    String codeTest = sc.next();
                    //先判断验证码
                    if (code.equals(codeTest)) {
                        if (password.equals(u.getPassword())){//无需判断用户名,因为前面已经判断了
                            System.out.println("登录成功");
                            return;
//                            break loop;//另一种方式
                        }
                        else{
                            System.out.println("密码输入错误,请重新输入");
                            break;//跳出当前循环,重新输入用户名和密码
                        }
                    } else {
                        System.out.println("验证码错误,请重新输入");
                    }
                }
            }
        }
    }

    //忘记密码
    public static void forgotCode(ArrayList<User> list) {
        Scanner sc = new Scanner(System.in);
        System.out.println("请输入用户名:");
        String name = sc.next();
        boolean flag = contain(list, name);
        if (!flag) {
            System.out.println("用户名未注册,请先注册");
        }
        else{
            //找到用户名对应的对象在集合中的索引
            int index = getIndex(list, name);
            User u = list.get(index);//找到对应的对象

            System.out.println("请输入身份证号码:");
            String idNum = sc.next();
            System.out.println("请输入手机号:");
            String phoneNum = sc.next();
            if(idNum.equals(u.getIdNum())&&phoneNum.equals(u.getPhoneNum())){
                System.out.println("请输入新密码:");
                String password = sc.next();
                u.setPassword(password);
                System.out.println("修改成功");
            }
            else{
                System.out.println("账号信息不匹配,修改失败");
            }
        }
    }

    //辅助方法

    //验证用户名的唯一性
    public static boolean contain(ArrayList<User> list, String name) {
//        for (int i = 0; i < list.size(); i++) {
//            User user = list.get(i);
//            if (name.equals(user.getName())) {
//                return true;//重复,不唯一
//            }
//        }
//        return false;//唯一
        return getIndex(list, name) >= 0;
    }

    //判断用户名:字母与数字的组合,不能是纯数字
    public static boolean judgeName(String name) {
        int numCount = 0;
        int charCount = 0;
        for (int i = 0; i < name.length(); i++) {
            char c = name.charAt(i);
            if (c >= '0' && c <= '9') {
                numCount++;
            } else if ((c >= 'a' && c <= 'z') || (c >= 'A' && c <= 'Z')) {
                charCount++;
            }
        }
        if (charCount > 0 && numCount > 0)
            return true;
        else
            return false;
    }

    //判断字符串是否都为数字
    public static boolean judgeNum(String str) {
        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);
            if (c < '0' || c > '9')
                return false;
        }
        return true;
    }

    //生成验证码
    public static String getCode() {
        //创建包含大小写字母的数组
        char[] arr = new char[52];
        for (int i = 0; i < arr.length; i++) {
            if (i < 26) {
                arr[i] = (char) (97 + i);//a~z
            } else {
                arr[i] = (char) (65 + i - 26);//A~Z
            }
        }
        //随机索引,将它们拼接在一起
        Random r = new Random();
        String result = "";
        for (int i = 0; i < 4; i++) {
            int index = r.nextInt(arr.length);
            result += arr[index];
        }
        //之后再随机一个数字,再拼接在一起
        int num = r.nextInt(10);
        result += num;
        //最后将字符串转为字符数组进行随机交换,打乱字符串
        char[] newArr = result.toCharArray();
        for (int i = 0; i < newArr.length; i++) {
            int index = r.nextInt(newArr.length);
            char temp = newArr[i];
            newArr[i] = newArr[index];
            newArr[index] = temp;
        }
        String s = new String(newArr);
        return s;
    }

    //通过用户名找到对应的用户并返回对应的索引
    public static int getIndex(ArrayList<User> list, String name) {
        for (int i = 0; i < list.size(); i++) {
            User user = list.get(i);
            if (name.equals(user.getName())) {
                return i;
            }
        }
        return -1;
    }
}
