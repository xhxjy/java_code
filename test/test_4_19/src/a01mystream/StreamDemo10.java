package a01mystream;

import java.util.*;
import java.util.stream.Collectors;

public class StreamDemo10 {
    public static void main(String[] args) {

        /*
            collect(Collector collector)            收集流中的数据，放到集合中 (List Set Map)

            注意点：
                如果我们要收集到Map集合当中，键不能重复，否则会报错
       */

        ArrayList<String> list = new ArrayList<>();
        Collections.addAll(list, "张无忌-男-15","张三丰-男-100", "张翠山-女-40", "张良-男-35", "王二麻子-男-37", "谢广坤-男-41");

        //list和set同理
        //区别:set集合可以去重
        //equals使用细节:尽量让常量为该方法的调用者,若为变量,可能会出现空指针(null)的情况
        Set<String> set = list.stream()
                .filter(s -> "男".equals(s.split("-")[1]))
                .collect(Collectors.toSet());
        System.out.println(set);
        //map
        //细节:键不能重复,否则会报错
        Map<String, Integer> map = list.stream().filter(s -> "男".equals(s.split("-")[1]))
                //tomap中的两个参数:
                //参数1:获取键的规则(会直接返回)
                //参数2:获取值的规则(会直接返回)
                .collect(Collectors.toMap(s -> s.split("-")[0],
                        s -> Integer.parseInt(s.split("-")[2])));
        System.out.println(map);


        //收集List集合当中
        //需求：
        //我要把所有的男性收集起来
//        List<String> newList1 = list.stream()
//                .filter(s -> "男".equals(s.split("-")[1]))
//                .collect(Collectors.toList());
        //System.out.println(newList1);


        //收集Set集合当中
        //需求：
        //我要把所有的男性收集起来
//        Set<String> newList2 = list.stream().filter(s -> "男".equals(s.split("-")[1]))
//                .collect(Collectors.toSet());
        //System.out.println(newList2);


        //收集Map集合当中
        //谁作为键,谁作为值.
        //我要把所有的男性收集起来
        //键：姓名。 值：年龄
        /*Map<String, Integer> map = list.stream()
                .filter(s -> "男".equals(s.split("-")[1]))*/
                /*
                 *   toMap : 参数一表示键的生成规则
                 *           参数二表示值的生成规则
                 *
                 * 参数一：
                 *       Function泛型一：表示流中每一个数据的类型
                 *               泛型二：表示Map集合中键的数据类型
                 *
                 *        方法apply形参：依次表示流里面的每一个数据
                 *               方法体：生成键的代码
                 *               返回值：已经生成的键
                 *
                 *
                 * 参数二：
                 *        Function泛型一：表示流中每一个数据的类型
                 *                泛型二：表示Map集合中值的数据类型
                 *
                 *       方法apply形参：依次表示流里面的每一个数据
                 *               方法体：生成值的代码
                 *               返回值：已经生成的值
                 *
                 * */
                /*.collect(Collectors.toMap(new Function<String, String>() {
                                              @Override
                                              public String apply(String s) {
                                                  //张无忌-男-15
                                                  return s.split("-")[0];
                                              }
                                          },
                        new Function<String, Integer>() {
                            @Override
                            public Integer apply(String s) {
                                return Integer.parseInt(s.split("-")[2]);
                            }
                        }));


        Map<String, Integer> map2 = list.stream()
                .filter(s -> "男".equals(s.split("-")[1]))
                .collect(Collectors.toMap(
                        s -> s.split("-")[0],
                        s -> Integer.parseInt(s.split("-")[2])));

        System.out.println(map2);*/


    }
}
