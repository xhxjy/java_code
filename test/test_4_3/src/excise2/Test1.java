package excise2;

public class Test1 {
    public static void main(String[] args) {
        /*
        //数组赋值
        int[] arr=new int[12];
        arr[0]=arr[1]=1;
        for (int i = 2; i < arr.length; i++) {
            arr[i]=arr[i-1]+arr[i-2];
        }
        System.out.println(arr[11]);*/
        //递归
        int num=12;
        System.out.println(getFeb(num));
    }
    public static int getFeb(int index){
        if(index==1||index==2){
            return 1;
        }else{
            return  getFeb(index-1)+getFeb(index-2);
        }
    }
}
