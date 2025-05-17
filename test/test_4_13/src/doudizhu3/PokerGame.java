package doudizhu3;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;

public class PokerGame {
    static ArrayList<String> pokerList = new ArrayList<>();
    //创建一个集合，用来添加牌的价值
    static HashMap<String, Integer> hm = new HashMap<>();

    static {
        //准备牌(写在静态代码块中是因为无论开始多少次游戏,牌是不变的)
        // "♦", "♣", "♥", "♠"
        // "3", "4", "5", "6", "7", "8", "9", "10", "J", "Q", "K", "A", "2"

        //牌的花色
        String[] color = {"♦", "♣", "♥", "♠"};
        //牌的数字
        String[] number = {"3", "4", "5", "6", "7", "8", "9", "10", "J", "Q", "K", "A", "2"};

        //牌是由花色和数字组成的--->将牌的花色和数字分别组合来进行字符串的拼接(双重循环)
        //(没必要用StringBuilder进行拼接,因为拼接元素较少)
        for (String c : color) {
            for (String num : number) {
                pokerList.add(c + num);
            }
        }

        //添加大小王
        //注意前面有一个空格,防止大小王在根据牌的数字获取价值中从牌中获取牌的数字时,因为字符串的截取而发生意外
        pokerList.add(" 小王");
        pokerList.add(" 大王");

        //指定牌的价值
        //牌上的数字到Map集合中判断是否存在
        //存在，获取价值
        //不存在，本身的数字就是价值
        hm.put("J", 11);
        hm.put("Q", 12);
        hm.put("K", 13);
        hm.put("A", 14);
        hm.put("2", 15);
        hm.put("小王", 50);
        hm.put("大王", 100);
    }

    public PokerGame() {
        //洗牌
        //打乱牌盒即可
        Collections.shuffle(pokerList);

        //发牌
        //将牌分为4组(54--->3+(3*17))
        //创建4(底牌和3个玩家的牌)个集合
        ArrayList<String> lord = new ArrayList<>();
        ArrayList<String> player1 = new ArrayList<>();
        ArrayList<String> player2 = new ArrayList<>();
        ArrayList<String> player3 = new ArrayList<>();

        for (int i = 0; i < pokerList.size(); i++) {
            String poker = pokerList.get(i);
            //法2
            if (i < 3) {
                lord.add(poker);
                continue;
            }
            //给3个玩家轮流发牌
            if (i % 3 == 0) {
                player1.add(poker);
            } else if (i % 3 == 1) {
                player2.add(poker);
            } else {
                player3.add(poker);
            }
        }

        //排序
        order(lord);
        order(player1);
        order(player2);
        order(player3);

        //看牌
        lookPoker("底牌", lord);
        lookPoker("xjy", player1);
        lookPoker("zqg", player2);
        lookPoker("xhn", player3);
    }

    //排序
    public void order(ArrayList<String> poker) {
        poker.sort((o1, o2) -> {
            //o1:要插入无序序列中的元素
            //o2:存在于无序序列中的元素

            //获取牌的价值和花色
            //o1
            String color1 = o1.substring(0, 1);
            int value1 = getValue(o1);
            //o2
            String color2 = o2.substring(0, 1);
            int value2 = getValue(o2);

            int result = value1 - value2;
            result = result == 0 ? color1.compareTo(color2) : result;
            return result;
        });
    }

    //根据牌的数字来获得牌的价值
    public int getValue(String poker) {
        //从牌中获得牌的数字
        String num = poker.substring(1);
        //判断牌的数字是否在map集合中
        //若在,则直接从map集合中获得对应价值;否则直接将数字转为对应的价值
        if (hm.containsKey(num)) {
            return hm.get(num);
        } else {
            return Integer.parseInt(num);//将字符串转为整型
        }
    }

    //看牌
    //参数:玩家名称,对应的牌组
    public void lookPoker(String name, ArrayList<String> poker) {
        System.out.print(name + "--->");
        for (String s : poker) {
            System.out.print(s + " ");
        }
        System.out.println();
    }
































    /*//牌盒
    static ArrayList<String> list = new ArrayList<>();

    //创建一个集合，用来添加牌的价值
    static HashMap<String, Integer> hm = new HashMap<>();

    static {
        //准备牌
        String[] color = {"♦", "♣", "♥", "♠"};
        String[] number = {"3", "4", "5", "6", "7", "8", "9", "10", "J", "Q", "K", "A", "2"};

        for (String c : color) {
            for (String n : number) {
                list.add(c + n);
            }
        }
        list.add(" 小王");
        list.add(" 大王");


        //指定牌的价值
        //牌上的数字到Map集合中判断是否存在
        //存在，获取价值
        //不存在，本身的数字就是价值
        hm.put("J", 11);
        hm.put("Q", 12);
        hm.put("K", 13);
        hm.put("A", 14);
        hm.put("2", 15);
        hm.put("小王", 50);
        hm.put("大王", 100);


    }

    public PokerGame() {
        //洗牌
        Collections.shuffle(list);

        //发牌
        ArrayList<String> lord = new ArrayList<>();
        ArrayList<String> player1 = new ArrayList<>();
        ArrayList<String> player2 = new ArrayList<>();
        ArrayList<String> player3 = new ArrayList<>();

        for (int i = 0; i < list.size(); i++) {
            String poker = list.get(i);
            //发底牌
            if (i <= 2) {
                lord.add(poker);
                continue;
            }

            //给三个玩家轮流发牌
            if (i % 3 == 0) {
                player1.add(poker);
            } else if (i % 3 == 1) {
                player2.add(poker);
            } else {
                player3.add(poker);
            }
        }


        //排序
        order(lord);
        order(player1);
        order(player2);
        order(player3);


        //看牌
        lookPoker("底牌",lord);
        lookPoker("钢脑壳",player1);
        lookPoker("大帅比",player2);
        lookPoker("蛋筒",player3);
    }


    *//*
     * 参数一：玩家的名字
     * 参数二：每位玩家的牌
     * *//*
    public void lookPoker(String name, ArrayList<String> list){
        System.out.print(name + ": ");
        for (String poker : list) {
            System.out.print(poker + " ");
        }
        System.out.println();

    }


    //利用牌的价值进行排序
    //参数：集合
    //♥5 ♥3 ♥6 ♥7 ♥9
    public void order(ArrayList<String> list){
        Collections.sort(list, new Comparator<String>() {
            //Array.sort （插入排序 + 二分查找）
            @Override
            public int compare(String o1, String o2) {
                //o1：表示当前要插入到有序序列中的牌
                //o2：表示已经在有序序列中存在的牌

                //负数：o1小 插入到前面
                //正数：o1大 插入到后面
                //0：o1的数字跟o2的数字是一样的，需要按照花色再次排序

                //1.计算o1的花色和价值   大王
                String color1 = o1.substring(0, 1);
                int value1 = getValue(o1);

                //2.计算o2的花色和价值
                String color2 = o2.substring(0, 1);
                int value2 = getValue(o2);

                //3.比较o1和o2的价值    ♥3  ♠3
                int i = value1 - value2;
                return i == 0 ? color1.compareTo(color2) : i;

            }
        });
    }

    //计算牌的价值
    //参数：牌
    //返回值：价值
    public int getValue(String poker){//♥3
        //获取牌上的数字
        String number = poker.substring(1);//把这里截取出来的结果，让这个结果再Map集合中存在 “ 大王”
        //拿着数字到map集合中判断是否存在
        if(hm.containsKey(number)){
            //存在，获取价值
            return hm.get(number);
        }else{
            //不存在，类型转换
            return Integer.parseInt(number);
        }
    }*/
}