package excise1;

//回文数的判断
//将原数与倒过来的数进行对比
public class code1 {
    public static void main(String[] args) {
        int x = 121;
        //定义一个变量记录x的初始值
        int tem = x;
        //记录倒过来的数字
        int num = 0;
        //将数字倒过来
        //用类似递归的思想,每次取x的个位
        while (x != 0) {
            int b = x % 10;
            x /= 10;
            num = num * 10 + b;//关键(不好理解)
        }
        System.out.println(num);
        System.out.println(tem == num);//里面是判断式,所以输出的结果只有真或假
    }
}
