package test;

import java.util.Random;

public class Code {
    public static void main(String[] args) {
//        code1();
//        code2();
        code3();
    }

    private static void code3() {
        //需求:产生一个验证码:包含大小写A-Z和数字0-9，总共长度为4或5，内容都是随机的，但是数字不能连续

        //获取52个大小写字母和0-9的数字
        char[] arr = new char[62];
        for (int i = 0; i < arr.length; i++) {
            if (i < 26) {
                arr[i] = (char) (97 + i);
            } else if (i < 52) {
                arr[i] = (char) (65 + i - 26);
            } else {
                arr[i] = (char) (48 + i - 52);
            }
        }

        Random r = new Random();
        while (true) {
            StringBuilder sb = new StringBuilder();
            //随机长度:各有一半的可能性长度为4/5
            //1.r.nextBoolean():随机布尔值(true/false)
            //2.三元运算符
            int targetLength= r.nextBoolean() ? 4 : 5;
            while (sb.length() < targetLength) {
                int index = r.nextInt(arr.length);
                char c = arr[index];
                sb.append(c);
            }
            String code = sb.toString();
            if (isValid(code)){
                System.out.println(code);
                break;
            }
        }
    }

    //判断验证码是否合法
    //1.包含大小写字母和数字
    //2.数字不连续
    private static boolean isValid(String code) {
        int i;
        if(!(isCode(code)))
            return false;
        for (i = 0; i < code.length(); i++) {
            char c = code.charAt(i);
            //Character.isDigit(c)等同于(c >= '0' && c <= '9')
            if (Character.isDigit(c)) {
                //使用索引时,需要考虑索引是否越界
                boolean flag1 = i > 0 && Character.isDigit(code.charAt(i - 1));
                boolean flag2 = i < code.length()-1 && Character.isDigit(code.charAt(i + 1));
                if (flag1||flag2)
                    return false;
            }
        }
        return true;
    }

    private static void code2() {
        //获取52个大小写字母和0-9的数字
        char[] arr = new char[62];
        for (int i = 0; i < arr.length; i++) {
            if (i < 26) {
                arr[i] = (char) (97 + i);
            } else if (i < 52) {
                arr[i] = (char) (65 + i - 26);
            } else {
                arr[i] = (char) (48 + i - 52);
            }
        }

        Random r = new Random();

        while (true) {
            StringBuilder sb = new StringBuilder();
            //for循环次数固定,不可行
            /*for (int i = 0; i < 5; i++) {
                int index = r.nextInt(arr.length);
                char c = arr[index];
                if(c=='o'||c=='O'){
                    continue;//会直接进入下一次循环,而循环次数仍然再计数,但是循环的总次数没有改变,从而会导致验证码的长度不足5位
                }
                sb.append(c);
            }*/
            //保证验证码的长度为5位
            while (sb.length() < 5) {
                int index = r.nextInt(arr.length);
                char c = arr[index];
                if (c == 'o' || c == 'O') continue;//会直接进入下一次循环,而循环次数仍然再计数,但是循环的总次数没有改变,从而会导致验证码的长度不足5位
                sb.append(c);
            }
            if (isCode(sb.toString())) {
                System.out.println(sb.toString());
                break;
            }
        }
    }

    //判断验证码是否包含字母和数字
    private static boolean isCode(String code) {
        int count = 0;
        for (int i = 0; i < code.length(); i++) {
            char c = code.charAt(i);
            if (c >= '0' && c <= '9') {
                count++;
            }
        }
        if (count == 0 || count == code.length()) {
            return false;
        } else {
            return true;
        }
    }

    private static void code1() {
        //获取52个大小写字母
        char[] arr = new char[52];
        for (int i = 0; i < arr.length; i++) {
            if (i < 26) {
                arr[i] = (char) (97 + i);
            } else {
                arr[i] = (char) (65 + i - 26);
            }
        }
        //随机获取4个大小写字母,用字符串将它们拼接起来,最后再拼接数字
        StringBuilder sb = new StringBuilder();
        Random r = new Random();

        for (int i = 0; i < 4; i++) {
            int randomIndex = r.nextInt(arr.length);
            sb.append(arr[randomIndex]);
        }
        int number = r.nextInt(10);
        sb.append(number);

        //将字符串打乱
        // 将字符串转为字符数组
        char[] code = sb.toString().toCharArray();
        for (int i = 0; i < code.length; i++) {
            //每循环一次,该字符与随机的索引进行交换
            int randomIndex = r.nextInt(code.length);
            char temp = code[randomIndex];
            code[randomIndex] = code[i];
            code[i] = temp;
        }
        System.out.println(new String(code));
    }

}
