package doudizhu2;


import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.TreeSet;

public class PokerGame {

    //创建map集合,使牌与序号产生一一对应的关系
    static HashMap<Integer,String> hs=new HashMap<>();
    //创建一个list集合,存储对应的序号
    static ArrayList<Integer> serialNumberList=new ArrayList<>();

    static {
        //准备牌(写在静态代码块中是因为无论开始多少次游戏,牌是不变的)
        // "♦", "♣", "♥", "♠"
        // "3", "4", "5", "6", "7", "8", "9", "10", "J", "Q", "K", "A", "2"

        //牌的花色
        String[] color = {"♦", "♣", "♥", "♠"};
        //牌的数字
        String[] number = {"3", "4", "5", "6", "7", "8", "9", "10", "J", "Q", "K", "A", "2"};

        //定义序号
        int serialNumber=1;

        //细节:需要先遍历数字再遍历花色,这才能保证牌是由小到大依次添加进map集合中
        for (String n : number) {
            for (String c : color) {
                hs.put(serialNumber,c+n);
                serialNumberList.add(serialNumber);
                serialNumber++;
            }
        }

        hs.put(serialNumber,"小王");
        serialNumberList.add(serialNumber);
        serialNumber++;

        hs.put(serialNumber,"大王");
        serialNumberList.add(serialNumber);
    }

    public PokerGame(){
        //洗牌
        Collections.shuffle(serialNumberList);
        //发牌
        TreeSet<Integer> lord=new TreeSet<>();
        TreeSet<Integer> player1=new TreeSet<>();
        TreeSet<Integer> player2=new TreeSet<>();
        TreeSet<Integer> player3=new TreeSet<>();

        for (int i = 0; i < serialNumberList.size(); i++) {
            Integer serialNumber = serialNumberList.get(i);
            if(i<3){
                lord.add(serialNumber);
                continue;
            }

            if(i%3==0){
                player1.add(serialNumber);
            }else if(i%3==1){
                player2.add(serialNumber);
            }else{
                player3.add(serialNumber);
            }
        }

        //看牌
        lookPoker("底牌",lord);
        lookPoker("xjy",player1);
        lookPoker("zqg",player2);
        lookPoker("kkk",player3);
    }

    public void lookPoker(String name,TreeSet<Integer> serialNumber){
        System.out.print(name+"--->");
        for (Integer sn : serialNumber) {
            String poker = hs.get(sn);
            System.out.print(poker+" ");
        }
        System.out.println();
    }
}
