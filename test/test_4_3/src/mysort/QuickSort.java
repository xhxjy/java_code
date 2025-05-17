package mysort;

public class QuickSort {
    public static void main(String[] args) {
      /*
        快速排序：
            第一轮：以0索引的数字为基准数，确定基准数在数组中正确的位置。
            比基准数小的全部在左边，比基准数大的全部在右边。
            后面以此类推。
      */

        int[] arr = {6, 1, 2, 7, 9, 3, 4, 5, 10, 8};
        quickSort(arr, 0, arr.length - 1);

        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
    }

    public static void quickSort(int[] arr, int i, int j) {
        //定义两个变量记录要查找的
        int start = i;
        int end = j;

//当start和end相等时,在最后确定基准数左右两边的范围时,会导致i>j即start > end,就会导致递归结束
        if (start > end) {
            return;
        }
        //1.从小到大
        //基准数
        int basicNum = arr[j];

        while (start < end) {//一般不可能出现start>end的情况
            //为什么要先从后往前找end,才去找start
            //因为选的是最左边的元素为基准数,所以要先移动end即最右边的(自己画图分析)

            //从前往后开始找大于基准数或两个索引下标重合的情况
            while (true) {
                if (end == start || basicNum < arr[start]) {
                    break;
                }
                start++;
            }

            //从后往前开始找小于基准数或两个索引下标重合的情况
            while (true) {
                if (end == start || basicNum > arr[end]) {
                    break;
                }
                end--;
            }
            //对两个符合条件的索引所对应的元素进行交换
            //注意:当两个索引下标重合时没必要进行以下交换操作,纯属多余
            if (end != start) {
                int temp = arr[start];
                arr[start] = arr[end];
                arr[end] = temp;
            }
        }
        //程序走到这时两个索引下标相等,进行基准数归位的操作
        int temp = arr[j];
        arr[j] = arr[end];
        arr[end] = temp;

        //2.从大到小(与上面类似)
        /*//基准数
        int basicNum = arr[j];

        while (start != end) {

            //为什么要先从后往前找end,才去找start
            //因为选的是最左边的元素为基准数,所以要先找end即最右边的

            while (true) {
                if (end == start || basicNum > arr[start]) {
                    break;
                }
                start++;
            }

            while (true) {
                if (end == start || basicNum < arr[end]) {
                    break;
                }
                end--;
            }

            int temp = arr[start];
            arr[start] = arr[end];
            arr[end] = temp;
        }
        //两者相等
        int temp = arr[j];
        arr[j] = arr[start];
        arr[start] = temp;*/
        //确定6左边和右边的范围,重复刚刚的操作
        quickSort(arr, i, start - 1);
        quickSort(arr, start + 1, j);
    }
}
/*//int[] arr = new int[1000000];

 *//* Random r = new Random();
        for (int i = 0; i < arr.length; i++) {
            arr[i] = r.nextInt();
        }*//*


        long start = System.currentTimeMillis();
        quickSort(arr, 0, arr.length - 1);
        long end = System.currentTimeMillis();

        System.out.println(end - start);//149

        System.out.println(Arrays.toString(arr));
        //课堂练习：
        //我们可以利用相同的办法去测试一下，选择排序，冒泡排序以及插入排序运行的效率
        //得到一个结论：快速排序真的非常快。

       *//* for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }*//*

    }


    *//*
 *   参数一：我们要排序的数组
 *   参数二：要排序数组的起始索引
 *   参数三：要排序数组的结束索引
 * *//*
    public static void quickSort(int[] arr, int i, int j) {
        //定义两个变量记录要查找的范围
        int start = i;
        int end = j;

        if(start > end){
            //递归的出口
            return;
        }



        //记录基准数
        int baseNumber = arr[i];
        //利用循环找到要交换的数字
        while(start != end){
            //利用end，从后往前开始找，找比基准数小的数字
            //int[] arr = {1, 6, 2, 7, 9, 3, 4, 5, 10, 8};
            while(true){
                if(end <= start || arr[end] < baseNumber){
                    break;
                }
                end--;
            }
            System.out.println(end);
            //利用start，从前往后找，找比基准数大的数字
            while(true){
                if(end <= start || arr[start] > baseNumber){
                    break;
                }
                start++;
            }



            //把end和start指向的元素进行交换
            int temp = arr[start];
            arr[start] = arr[end];
            arr[end] = temp;
        }

        //当start和end指向了同一个元素的时候，那么上面的循环就会结束
        //表示已经找到了基准数在数组中应存入的位置
        //基准数归位
        //就是拿着这个范围中的第一个数字，跟start指向的元素进行交换
        int temp = arr[i];
        arr[i] = arr[start];
        arr[start] = temp;

        //确定6左边的范围，重复刚刚所做的事情
        quickSort(arr,i,start - 1);
        //确定6右边的范围，重复刚刚所做的事情
        quickSort(arr,start + 1,j);
    }*/
