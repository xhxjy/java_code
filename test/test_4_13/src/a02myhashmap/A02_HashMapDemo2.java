package a02myhashmap;

import java.util.*;

public class A02_HashMapDemo2 {
    public static void main(String[] args) {
        /*
            某个班级80名学生，现在需要组成秋游活动，
            班长提供了四个景点依次是（A、B、C、D）,
            每个学生只能选择一个景点，请统计出最终哪个景点想去的人数最多。
        */
        //1.先让同学们投票,获取到投票数据
        //1.1 定义一个数组存储四个景点
        String[] arr = {"A", "B", "C", "D"};
        //1.2 定义一个集合存储学生投票的结果
        ArrayList<String> list = new ArrayList<>();
        //1.3 利用随机数来模拟同学投票
        Random r = new Random();
        for (int i = 0; i < 80; i++) {
            int index = r.nextInt(arr.length);
            list.add(arr[index]);
        }

        //若统计的东西(景点)比较多,不方便用计数器思想,因为每个统计的东西都要定义对应的计数器
        //此时用map集合统计更好.
        // K:景点;V:票数

        //2.定义一个hashmap集合
        HashMap<String, Integer> hm = new HashMap<>();

        //3.将数据添加进map集合中
        //对list集合进行遍历
        for (String name : list) {
            //判断当前景点在map集合中是否存在
            //存在
            if (hm.containsKey(name)) {
                //获取该景点原来的票数,并对它++
                Integer count = hm.get(name);
                count++;
                //关键点:
                //将新的票数再次添加进map集合中,否则修改的票数未将map集合中的原票数覆盖,从而修改不成功
                hm.put(name, count);
            }
            //不存在
            else {
                hm.put(name, 1);
            }
        }

        System.out.println(hm);

        //4.对map集合进行遍历,找出最大的票数
        //1.根据键找值
        Set<String> keys = hm.keySet();
        int maxCount = 0;
        for (String name : keys) {
            Integer count = hm.get(name);
            if (count >= maxCount) {
                maxCount = count;
            }
        }
        //5.对map集合进行遍历,找出最大的票数对应的景点
        for (String name : keys) {
            if (maxCount == hm.get(name)) {
                System.out.println(name);
            }
        }

        //2.键值对
        /*Set<Map.Entry<String, Integer>> entries = hm.entrySet();
        int maxCount = 0;
        for (Map.Entry<String, Integer> entry : entries) {
            Integer count = entry.getValue();
            if (count >= maxCount) {
                maxCount = count;
            }
        }
        for (Map.Entry<String, Integer> entry : entries) {
            if (maxCount == entry.getValue()) {
                System.out.println(entry.getKey());
            }
        }*/



























        /*//1.需要先让同学们投票
        //定义一个数组，存储4个景点
        String[] arr = {"A","B","C","D"};
        //利用随机数模拟80个同学的投票，并把投票的结果存储起来
        ArrayList<String> list = new ArrayList<>();
        Random r = new Random();
        for (int i = 0; i < 80; i++) {
            int index = r.nextInt(arr.length);
            list.add(arr[index]);
        }
        //2.如果要统计的东西比较多，不方便使用计数器思想
        //我们可以定义map集合，利用集合进行统计。
        HashMap<String,Integer> hm = new HashMap<>();
        for (String name : list) {
            //判断当前的景点在map集合当中是否存在
            if(hm.containsKey(name)){
                //存在
                //先获取当前景点已经被投票的次数
                int count = hm.get(name);
                //表示当前景点又被投了一次
                count++;
                //把新的次数再次添加到集合当中
                hm.put(name,count);
            }else{
                //不存在
                hm.put(name,1);
            }
        }

        System.out.println(hm);

        //3.求最大值
        int max = 0;
        Set<Map.Entry<String, Integer>> entries = hm.entrySet();
        for (Map.Entry<String, Integer> entry : entries) {
            int count = entry.getValue();
            if(count > max){
                max = count;
            }
        }
        System.out.println(max);
        //4.判断哪个景点的次数跟最大值一样，如果一样，打印出来
        for (Map.Entry<String, Integer> entry : entries) {
            int count = entry.getValue();
            if(count == max){
                System.out.println(entry.getKey());
            }
        }*/


    }
}
