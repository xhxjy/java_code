package test1;

import java.util.Arrays;

public class Excise1 {
    public static void main(String[] args) {
        // 定义原始数组的字符串形式
        String a1Str = "1,6,8,10,12,14,16,18";
        String a2Str = "3,5,7,9,11";

        // 将字符串转换为整数数组
        int[] a1 = Arrays.stream(a1Str.split(","))
                .mapToInt(Integer::parseInt).toArray();
        int[] a2 = Arrays.stream(a2Str.split(","))
                .mapToInt(Integer::parseInt).toArray();

        // 合并数组
        int[] merged = new int[a1.length + a2.length];
        System.arraycopy(a1, 0, merged, 0, a1.length);
        System.arraycopy(a2, 0, merged, a1.length, a2.length);

        // 排序
        Arrays.sort(merged);

        // 输出结果
        System.out.println("合并后的数组: " + Arrays.toString(merged));
    }
}
