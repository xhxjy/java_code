package test2;

import java.util.Scanner;

public class Test {
    public static void main(String[] args) {
        /*
            需求：
                键盘录入自己心仪的女朋友姓名和年龄。
                姓名的长度在 3 - 10之间，
                年龄的范围为 18 - 40岁,
                超出这个范围是异常数据不能赋值，需要重新录入,一直录到正确为止。
            提示：
                需要考虑用户在键盘录入时的所有情况。
                比如：录入年龄时超出范围，录入年龄时录入了abc等情况
        */
        //自定义异常类的目的是为了:得到具体的异常类名,其类中只要写出两个构造方法即可
        //如:创建NameFormatException异常类,是为了表明出现这个异常是因为名字格式化的问题

        //1.创建键盘录入的对象
        Scanner sc = new Scanner(System.in);
        //2.创建女朋友的对象
        GirlFriend gf = new GirlFriend();
        while (true) {
            //3.接收女朋友的姓名
            try {
                System.out.println("请输入你心仪的女朋友的名字");
                String name = sc.nextLine();
                gf.setName(name);
                //4.接收女朋友的年龄
                System.out.println("请输入你心仪的女朋友的年龄");
                String ageStr = sc.nextLine();
                int age = Integer.parseInt(ageStr);
                gf.setAge(age);
                //如果所有的数据都是正确的，那么跳出循环
                break;
            } catch (NumberFormatException e) {
                e.printStackTrace();
            }catch (NameFormatException e) {
                e.printStackTrace();
            }catch (AgeOutOfBoundsException e) {
                e.printStackTrace();
            }
        }
        //5.打印
        System.out.println(gf);

        //思路:
        // 在对应的构造方法中进行判断并抛出异常
        //然后在录入语句中对异常进行捕获


    }
}
