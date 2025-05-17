package excise2;

public class Test2 {
    public static void main(String[] args) {
        System.out.println(getNum(1));
    }

    //反向递归
    private static int getNum(int day) {
        //对输入的时间进行合法性判断
        if(day<=0||day>10){
            System.out.println("输入错误");
            return -1;
        }
        if(day==10){
            return 1;
        }
        return (getNum(day+1)+1)*2;
    }
}
