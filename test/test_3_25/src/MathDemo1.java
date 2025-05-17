public class MathDemo1 {
    public static void main(String[] args) {
        int count =0;
        double sum =0;
        for (int i = 1000; i <= 9999; i++) {
            int ge=i%10;
            int shi=(i/10)%10;
//            int bai=(i/100)%10;
//            int qian=(i/1000)%10;
            sum=Math.pow(ge,2)+Math.pow(shi,2);//pow返回的值是double类型的
            if(sum==i){
                count++;
                System.out.println(sum);
            }
        }
        System.out.println(count);
    }
}
