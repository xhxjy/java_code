package a01mymap;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class A02_MapDemo2 {
    public static void main(String[] args) {
        //Map集合的第一种遍历方式

        //三个课堂练习：
        //
        //练习一：  利用键找值的方式遍历map集合，要求：装着键的单列集合使用增强for的形式进行遍历
        //练习二：  利用键找值的方式遍历map集合，要求：装着键的单列集合使用迭代器的形式进行遍历
        //练习三：  利用键找值的方式遍历map集合，要求：装着键的单列集合使用lambda表达式的形式进行遍历


        //1.创建Map集合的对象
        Map<String, String> m = new HashMap<>();

        //2.添加元素
        m.put("尹志平", "小龙女");
        m.put("郭靖", "穆念慈");
        m.put("欧阳克", "黄蓉");

        //3.通过键找值(key可以看作数组中的索引,而value则为索引对应的元素)
        //3.1 调用方法获取所有的键并将它们放到一个单列集合中
        Set<String> keys = m.keySet();
        //三个方法遍历
        //1.增强for
        /*for (String key : keys) {
            String value = m.get(key);
            System.out.println(value);
        }*/
        //2.迭代器
        /*Iterator<String> it = keys.iterator();
        while (it.hasNext()){
            String value = m.get(it.next());
            System.out.println(value);
        }*/
        //3.lambda表达式
        keys.forEach(key -> System.out.println(key + "=" + m.get(key)));





















        /*//3.通过键找值

        //3.1获取所有的键，把这些键放到一个单列集合当中
        Set<String> keys = map.keySet();
        //3.2遍历单列集合，得到每一个键
        for (String key : keys) {
            //System.out.println(key);
            //3.3 利用map集合中的键获取对应的值  get
            String value = map.get(key);
            System.out.println(key + " = " + value);
        }*/


    }
}
