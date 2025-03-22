package a01staticDemo1;

public class ArrUtil {
    //私有化构造方法
    //目的:为了不让外界创建它的对象,因为该对象无意义
    private ArrUtil() {
    }

    public static String printArr(int[] arr) {
        StringBuilder sb = new StringBuilder();
        sb.append("[");
        for (int i = 0; i < arr.length; i++) {
            if (i == arr.length - 1) {
                sb.append(arr[i]).append("]");
            } else {
                sb.append(arr[i]).append(", ");
            }
        }
        return sb.toString();
    }

    public static double getAverage(double[] arr) {
        double sum = 0;
        for (int i = 0; i < arr.length; i++) {
            sum += arr[i];
        }
        return sum / arr.length;
    }
}
