package test_3_20;

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class UserTestApp {
    public static void main(String[] args) {
        //创建一个集合存储用户对象
        ArrayList<User> list = new ArrayList<>();
        Scanner sc = new Scanner(System.in);
        while (true) {
            menu();
            System.out.println("请输入你的选项:");
//用nextInt也可以,但是若用户不小心输入了ab之类的其他语句,程序会报错
//用next的容错率更高
            String choice = sc.next();
            switch (choice) {
                //jdk12的新写法,case后自带break
                case "1" -> signIn(list);
                case "2" -> signUp(list);
                case "3" -> forgotCode(list);
                case "4" -> {
                    System.out.println("系统已退出");
                    System.exit(0);
                }
                default -> System.out.println("输入错误,请重新输入");
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
            //开发细节:先验证格式是否正确,再验证是否唯一
            //判断格式
            boolean flag1 = judgeName(list, name);
            if (!flag1){
                System.out.println("用户名格式不正确,请重新输入");
                continue;
            }
            else{
                //判断用户的唯一性
                boolean b = contain(list, name);
                if (!b) {
                    user.setName(name);
                } else {
                    System.out.println("用户名重复,请重新输入");
                    continue;//返回循环重新输入
                }
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
            boolean flag2 = judgeIdNum(idNum);
            if (flag2) {
                user.setIdNum(idNum);
            } else {
                System.out.println("身份证号码不合法,请重新输入");
                continue;
            }

            //手机号
            System.out.println("请输入手机号:");
            String phoneNum = sc.next();
            boolean flag3 = judgePhoneNum(phoneNum);
            if (flag3) {
                user.setPhoneNum(phoneNum);
                break;
            } else {
                System.out.println("手机号不合法,请重新输入");
            }
        }
        list.add(user);
        System.out.println("注册成功");
        //遍历查看注册名单
        printUser(list);
    }

    //登录
    public static void signIn(ArrayList<User> list) {
        Scanner sc = new Scanner(System.in);
        int i;
        loop:
        for (i = 0; i < 3; i++) {
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
                    System.out.println("请输入验证码(字母不分大小写):");
                    String codeTest = sc.next();
                    //先判断验证码
                    if (code.equalsIgnoreCase(codeTest)) {//验证码字母不分大小写
//法2:此处需要虽然只需要判断密码,但若在之后需要判断更多信息,例如:需要验证除了用户名以外的全部信息
//首先:需要写为一个方法,而传递的参数,可以将它包装为一个残缺的用户对象,将这个对象当作参数传过去
//将零散的数据封装为一个对象
//封装思想的应用
//                        User userInFo=new User(null,password, idNum,phoneNum);
//                        checkInFo(list,userInFo);
                        if (password.equals(u.getPassword())) {//无需判断用户名,因为前面已经判断了
                            System.out.println("登录成功,可以开始使用图书管理系统");
                            BookTest bb = new BookTest();
                            bb.startBookSystem();
                            return;
//                            break loop;//另一种方式
                        } else {
                            System.out.println("密码输入错误,请重新输入");
                            break;//跳出当前循环,重新输入用户名和密码
                        }
                    } else {
                        System.out.println("验证码错误,请重新输入");
                    }
                }
            }
            if (i == 2) {
                System.out.println("当前账号已被锁定,请联系zqg");
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
        } else {
            //找到用户名对应的对象在集合中的索引
            int index = getIndex(list, name);
            User u = list.get(index);//找到对应的对象

            System.out.println("请输入身份证号码:");
            String idNum = sc.next();
            System.out.println("请输入手机号:");
            String phoneNum = sc.next();
            if (idNum.equals(u.getIdNum()) && phoneNum.equals(u.getPhoneNum())) {
                //输入两次新密码,确认修改成功
                while (true) {
                    System.out.println("请输入新密码:");
                    String password1 = sc.next();
                    System.out.println("请再次输入新密码:");
                    String password2 = sc.next();
                    if (password2.equals(password1)) {
                        u.setPassword(password1);
                        System.out.println("修改成功");
                        break;
                    } else {
                        System.out.println("密码不一致,请重新输入");
                    }
                }
            } else {
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

    //判断用户名格式合法性
    public static boolean judgeName(ArrayList<User> list, String name) {
        //长度判断
        int length = name.length();
        if (!(length >= 3 && length <= 15)) {
            return false;
        }
        //先判断用户名不包含数字和字母以外的符号
        for (int i = 0; i < name.length(); i++) {
            char c = name.charAt(i);
            if (!((c >= '0' && c <= '9') || (c >= 'a' && c <= 'z') || (c >= 'A' && c <= 'Z'))) {
                return false;
            }
        }
        //程序走到这里时,意味着前面的条件都满足了,现在只需判断是否有字母和数字即可
        //统计字母数量是否大于0
        int charCount = 0;
        int numCount = 0;
        for (int i = 0; i < name.length(); i++) {
            char c = name.charAt(i);
            if (c >= '0' && c <= '9') {
                numCount++;
            }
            if ((c >= 'a' && c <= 'z') || (c >= 'A' && c <= 'Z')) {
                charCount++;//不能加break,虽然只需判断有无,无需计算字母数量;但是后续还需判断是否有数字
            }
        }
        return charCount > 0 && numCount > 0;//利用程序会向下读写的特性,前面故意给出错误条件return false
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
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < 4; i++) {
            int index = r.nextInt(arr.length);
            sb.append(arr[index]);//遇到拼接时首先想到StringBuilder
        }
        //之后再随机一个数字,再拼接在一起
        int num = r.nextInt(10);
        sb.append(num);
        //最后将字符串转为字符数组进行随机交换,打乱字符串
        char[] newArr = sb.toString().toCharArray();
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

    //判断身份证是否合法
    public static boolean judgeIdNum(String idNum) {
        //长度为18
        int length1 = idNum.length();
        if (length1 != 18) {
            return false;
        }
        //前17位都是数字
        String idNumTest = idNum.substring(0, length1 - 1);//为了测试前17位是否都为数字的临时变量
        boolean flag = judgeNum(idNumTest);
        if (!flag) {
            return false;
        }
        //最后一位可以是数字或X,x
        char last = idNum.charAt(idNum.length() - 1);
        if (!(last == 'X' || last == 'x' || (last >= '0' && last <= '9'))) {
            return false;
        }
        //不能以0开头(将它放在最后判断,是因为判断简单,书写简洁)
        char c = idNum.charAt(0);
        return c != '0';//直接返回这个表达式,可以简化代码(否则它将会写成下面这样)
//        if(c=='0'){
//            return true;
//        }
//            return false;//else也没有必要加

    }

    //判断手机号是否合法
    public static boolean judgePhoneNum(String phoneNum) {
        //长度为11
        int length2 = phoneNum.length();
        if (length2 != 11) {
            return false;
        }
        char ch = phoneNum.charAt(0);
        if (ch == 0) {
            return false;
        }
        //必须都为数字
        return judgeNum(phoneNum);
    }

    //遍历注册名单
    public static void printUser(ArrayList<User> list) {
        //无需判断集合是否为空,因为程序走到这时,已经注册了,所以集合不会为空
        for (int i = 0; i < list.size(); i++) {
            User u = list.get(i);
            System.out.println(u.getName() + "," + u.getPassword() + ","
                    + u.getIdNum() + "," + u.getPhoneNum());
        }
    }
}
