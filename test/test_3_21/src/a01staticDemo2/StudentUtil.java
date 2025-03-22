package a01staticDemo2;

import java.util.ArrayList;

public class StudentUtil {
    private StudentUtil() {
    }

    public static int getMaxAge(ArrayList<Student> list) {
        //定义一个参照物,即假定i==0时age为最大
        int maxAge = list.get(0).getAge();
        //遍历比较
        for (int i = 1; i < list.size(); i++) {
//当一个方法的返回值需要反复被调用时,用一个临时变量去记录返回值,每次循环只是将原来的值覆盖了;
// 并未创建新的空间,从而提高效率
            int age = list.get(i).getAge();
            if (age > maxAge) {
                maxAge = age;
            }
        }
        return maxAge;
    }
}
