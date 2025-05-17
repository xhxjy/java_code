package test;

public class Excise2 {
    public static void main(String[] args) {
        StringBuffer sb=new StringBuffer();
        for (int i = 0; i < 26; i++) {
            char c=(char)(i+97);
            sb.append(c);
        }
        sb.reverse();
        sb.delete(0,5);
        System.out.println(sb);
    }
}
