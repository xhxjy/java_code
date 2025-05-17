package excise1;

import java.util.Arrays;

public class GFTest {
    public static void main(String[] args) {
        //需求:对女朋友对象进行排序:先比年龄;若一样,再比身高;若仍然一样,再比姓名的字母排序
        //创建一些女朋友对象
        GF g1 = new GF("xhn", 22, 185.0);
        GF g2 = new GF("hjy", 22, 165.0);
        GF g3 = new GF("zqg", 18, 175.0);
        GF g4 = new GF("man", 18, 175.0);
        //将它们添加进数组中
        GF[] arr = {g1, g2, g3, g4};
        /*
        //匿名内部类
        //进行排序
        Arrays.sort(arr, new Comparator<GF>() {
            @Override
            public int compare(GF o1, GF o2) {
                *//*if (o1.getAge() != o2.getAge()) {
                    return o1.getAge() - o2.getAge();
                } else if (o1.getHeight() != o2.getHeight()) {
                    return (int) (o1.getHeight() - o2.getHeight());
                } else if (o1.getName().equals(o2.getName())) {
                    return o1.getName().compareTo(o2.getName());
                }
                return 0;*//*
                //用三元表达式更加简洁
                double result = o1.getAge() - o2.getAge();
                result = result == 0 ? o1.getHeight() - o2.getHeight() : result;
                result = result == 0 ? o1.getName().compareTo(o2.getName()) : result;
                //因为结果可能有小数,如果直接强转int类型会出现问题,例如:0.1->0
                //所以需要额外进行判断
                //return (int)result;
                if(result>0){
                    return 1;
                } else if (result < 0) {
                    return -1;
                }else
                    return 0;//两者相同,后来的排后面
            }
        });
        */
        //lambda表达式
        Arrays.sort(arr, (o1, o2)-> {
                    //用三元表达式更加简洁
                    double result = o1.getAge() - o2.getAge();
                    result = result == 0 ? o1.getHeight() - o2.getHeight() : result;
                    result = result == 0 ? o1.getName().compareTo(o2.getName()) : result;
                    //因为结果可能有小数,如果直接强转int类型会出现问题,例如:0.1->0
                    //所以需要额外进行判断
                    //return (int)result;
                    if(result>0){
                        return 1;
                    } else if (result < 0) {
                        return -1;
                    }else
                        return 0;//两者相同,后来的排后面
                }
        );

        System.out.println(Arrays.toString(arr));
    }
}
//当字符串需要按照字母排列的顺序时,可用compareTo方法,如o1.getName().compareTo(o2.getName())
