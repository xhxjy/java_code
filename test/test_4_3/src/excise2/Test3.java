package excise2;

//递归经典算法:爬楼梯
public class Test3 {
    public static void main(String[] args) {
        System.out.println(getCount(20));
    }
    public static int getCount(int num){
        if(num==1){
            return 1;
        }
        if(num==2){
            return 2;
        }
        if(num==3){
            return 4;
        }
        return getCount(num-1)+getCount(num-2)+getCount(num-3);
    }
}
