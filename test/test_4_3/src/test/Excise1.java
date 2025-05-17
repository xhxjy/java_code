package test;

import java.util.Random;

public class Excise1 {
    public static void main(String[] args) {
        Random r=new Random();
        for (int i = 0; i < 5; i++) {
            int num = r.nextInt(30)+1;
            System.out.print(num+" ");
        }
    }
}
