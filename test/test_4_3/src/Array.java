import java.util.Arrays;
import java.util.Comparator;

public class Array {
    public static void main(String[] args) {
        int[] arr={1,2,3,4,5,6,7,8,9};
        //toString(...):将数组变成字符串
        //应用场景:要查看数组结果时,不用遍历数组了
        System.out.println(Arrays.toString(arr));
        //binarySearch(...,...):二分法查找元素
        //前提:升序
        //若元素不存在,返回的是:-插入点-1
        System.out.println(Arrays.binarySearch(arr,10));
        System.out.println(Arrays.binarySearch(arr,0));

        //copyOf(...,...):数组拷贝
        //参数:老数组,拷贝的长度
        //新数组的长度超过老数组,超过部分为初始化的值
        int[] arr1= java.util.Arrays.copyOf(arr,20);
        System.out.println(Arrays.toString(arr1));

        //copyOf(数组名,起始索引,结束索引):数组拷贝(指定范围)
        //细节:包头不包尾,包左不包右
        int[] arr2= Arrays.copyOfRange(arr,0,7);
        System.out.println(Arrays.toString(arr2));

        //fill(数组名,填充值):填充数组
        Arrays.fill(arr,10);
        System.out.println(Arrays.toString(arr));

        //sort(数组名):排序,默认是升序排列
        int[] arr3={9,5,3,2,6,8,4,7};
        Arrays.sort(arr3);
        System.out.println(Arrays.toString(arr3));

        //sort方法的重写
        //o2-o1:降序;o1-o2:升序
        //参数:o1:无序序列的元素;o2:有序序列的元素
        Integer[] arr4={2,3,4,1,9,7,5,6};
        Arrays.sort(arr4, new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o2-o1;
            }
        });
        System.out.println(Arrays.toString(arr4));
    }
}
