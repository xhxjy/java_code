package excise1;

import java.util.Scanner;

//计算平方根(只要整数)
public class code3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int x = sc.nextInt();
        for (int i = 1; i <= x / 2; i++) {
            if (i * i > x) {
                System.out.println(x + "的平方根是:" + (i - 1));
                break;
            }
        }
    }
}
