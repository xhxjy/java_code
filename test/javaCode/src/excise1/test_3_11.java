package excise1;

public class test_3_11 {
    public static void main(String[] args) {
        int originalNum = 13579;
        int real_Num = 0;
        //加密
        while (originalNum != 0) {
            int b = originalNum % 10;
            b = (b + 5) % 10;
            originalNum /= 10;
            real_Num = real_Num * 10 + b;
        }
        System.out.println(real_Num);
    }
}
