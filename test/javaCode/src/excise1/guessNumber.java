package excise1;


//public class guessNumber {
//    public static void main(String[] args) {
/// /        Random r = new Random();
/// /        int num = r.nextInt(100)+1;//1~100((0~99)+1)
//        //要生成a~b之间的随机数,可以用r.nextInt(b-a+1)+a
//        //eg:生成7~15之间的随机数,可以用r.nextInt(15-7+1)+7
//       int[] arr={12,3,1};
//
//        //打乱数组中的数据
//        //一个数据与随机与另外四个数据中的一个进行交换,循环进行

//            int arr[]={1,2,3,4,5};
//       Random r = new Random();
//       int i=0;
//       for(i=0;i<arr.length;i++){
//           int randomNumber = r.nextInt(arr.length);
//         两个数据进行交换,而并非简单地赋值
//          arr[i]=arr[randomNumber];
//            int temp=arr[i];
//            arr[i]=arr[randomNumber];
//           arr[randomNumber]=temp;
//      }
//        for(i=0;i<arr.length;i++){
//           System.out.print(arr[i]+" ");
//        }
//        showGF();
//        int arr[]={1,3,15,7,90};
//        Scanner sc=new Scanner(System.in);
//        int num = sc.nextInt();

//        无需再次判断,直接打印返回结果即可
//        if(isExit(arr,num))
//            System.out.println("存在");
//        else
//            System.out.println("不存在");
//        System.out.println(isExit(arr,num));
//    }
//    public static boolean isExit(int arr[],int num){//用boolean类型更好
//        for(int i=0;i<arr.length;i++){
//            if(num == arr[i])
//                return true;
//        }
//        //当数组里的全部数据比较完之后才可以判断num在数组中不存在
//        return false;
//    }
// }
public class guessNumber {
    public static void main(String[] args) {
        int arr[] = {1, 3, 4, 2, 8};
        int right = 4;
        int left = 1;
        int[] copyArr = copyRange(arr, left, right);
        for (int i = 0; i < copyArr.length; i++)
            System.out.print(copyArr[i]+" ");
    }

    public static int[] copyRange(int arr[], int from, int to) {
        int[] newArr = new int[to - from];//java中数组的动态初始化,可以将数组的长度定义为变量;C语言不可以
        //伪造索引(下标)
        int index = 0;
        for (int i = from; i < to; i++) {
            //不可以用newArr[i],例如当form=1,to=5时,newArr的最大索引值为3(4-1),而to>4,当i>3时,newArr数组下标会越界
            newArr[index] = arr[i];
            index++;
        }
        return newArr;
    }
}
//public class guessNumber {
//    public static int sum(int a, int b){
//        return a+b;
//    }
//    public static int sum(int a, int b, int c){
//        return a+b+c;//个数
//    }
//    public static double sum(double a, double b){
//        return a+b;//类型
//    }
//
//    //顺序不同,改个顺序即可,意义不大,不推荐
//    public static double sum(double a, int b){
//        return a+b;
//    }
//    public static double sum(int a, double b){
//        return a+b;
//    }
//}