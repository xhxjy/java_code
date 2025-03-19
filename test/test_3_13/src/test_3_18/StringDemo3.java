package test_3_18;

import java.util.Scanner;

public class StringDemo3 {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        String str = sc.next();
        int count=0;
        for (int i = str.length()-1; i >= 0; i--) {
            if(str.charAt(i)==' '){
                break;
            }else{
                count++;
            }
        }
    }
}
