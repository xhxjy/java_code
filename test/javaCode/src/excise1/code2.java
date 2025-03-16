package excise1;

//求商和余数(不用/、*、%)
//int a=90,b=10;
//90-10=80
//80-10=70
//70-10=60
//.....
//10-10=0(余数),运算次数为商
public class code2 {
    public static void main(String[] args){
        int a = 80;
        int b = 10;
        int count = 0;
        while (a >= b) {
            a -= b;
            count++;
        }
        System.out.println("商为:" + count);
        System.out.println("余数为:" + a);
    }
}
