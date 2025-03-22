package a01staticDemo1;

public class TestDemo {
    public static void main(String[] args) {
        int[] arr1 = {1, 3, 5, 7, 9};
        String s = ArrUtil.printArr(arr1);
        System.out.println(s);
        double[] arr2 = {1.0, 4.0, 7.0};
        double average = ArrUtil.getAverage(arr2);
        System.out.println(average);
    }
}
