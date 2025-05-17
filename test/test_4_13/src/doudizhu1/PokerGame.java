package doudizhu1;

import java.util.ArrayList;
import java.util.Collections;

public class PokerGame {

    //创建一个集合来存储牌(牌盒)
    //语句放在这个位置,是因为多个地方要用到牌盒
    //添加static是因为只有静态才能调用静态
    static ArrayList<String> pokerList=new ArrayList<>();

    static{
        //准备牌(写在静态代码块中是因为无论开始多少次游戏,牌是不变的)
        // "♦", "♣", "♥", "♠"
        // "3", "4", "5", "6", "7", "8", "9", "10", "J", "Q", "K", "A", "2"

        //牌的花色
        String[] color={"♦", "♣", "♥", "♠"};
        //牌的数字
        String[] number={"3", "4", "5", "6", "7", "8", "9", "10", "J", "Q", "K", "A", "2"};

        //牌是由花色和数字组成的--->将牌的花色和数字分别组合来进行字符串的拼接(双重循环)
        //(没必要用StringBuilder进行拼接,因为拼接元素较少)
        for (String c : color) {
            for (String num : number) {
                pokerList.add(c+num);
            }
        }

        //添加大小王
        pokerList.add("小王");
        pokerList.add("大王");
    }

    public PokerGame(){
        //洗牌
        //打乱牌盒即可
        Collections.shuffle(pokerList);

        //发牌
        //将牌分为4组(54--->3+(3*17))
        //创建4(底牌和3个玩家的牌)个集合
        ArrayList<String> lord=new ArrayList<>();
        ArrayList<String> player1=new ArrayList<>();
        ArrayList<String> player2=new ArrayList<>();
        ArrayList<String> player3=new ArrayList<>();

        for (int i = 0; i < pokerList.size(); i++) {
            String poker = pokerList.get(i);
            //法1:依次遍历的方式会导致:3个玩家的牌存在偶然性
            /*if(i<3){
                lord.add(poker);
            }else if(i<20){
                player1.add(poker);
            }else if(i<37){
                player2.add(poker);
            }else{
                player3.add(poker);
            }*/
            //法2
            if(i<3){
                lord.add(poker);
                continue;
            }
            //给3个玩家轮流发牌
            if(i%3==0){
                player1.add(poker);
            }else if(i%3==1){
                player2.add(poker);
            }else{
                player3.add(poker);
            }
        }

        //看牌
        lookPoker("底牌",lord);
        lookPoker("xjy",player1);
        lookPoker("zqg",player2);
        lookPoker("xhn",player3);
    }


    //看牌
    //参数:玩家名称,对应的牌组
    public void lookPoker(String name,ArrayList<String> poker){
        System.out.print(name+"--->");
        for (String s : poker) {
            System.out.print(s+" ");
        }
        System.out.println();
    }



































    /*//牌盒
    //♥3 ♣3
    static ArrayList<String> list = new ArrayList<>();


    //静态代码块
    //特点：随着类的加载而在加载的，而且只执行一次。
    static {
        //准备牌
        // "♦", "♣", "♥", "♠"
        // "3", "4", "5", "6", "7", "8", "9", "10", "J", "Q", "K", "A", "2"
        String[] color = {"♦", "♣", "♥", "♠" };
        String[] number = {"3", "4", "5", "6", "7", "8", "9", "10", "J", "Q", "K", "A", "2"};

        for (String c : color) {
            //c依次表示每一种花色
            for (String n : number) {
                //n 依次表示每一个数字
                list.add(c + n);
            }
        }
        list.add("小王");
        list.add("大王");
    }


    public PokerGame(){
        //洗牌
        Collections.shuffle(list);

        //发牌
        ArrayList<String> lord = new ArrayList<>();
        ArrayList<String> player1 = new ArrayList<>();
        ArrayList<String> player2 = new ArrayList<>();
        ArrayList<String> player3 = new ArrayList<>();

        //遍历牌盒得到每一张牌
        for (int i = 0; i < list.size(); i++) {
            //i：索引
            String poker = list.get(i);
            if(i <= 2){
                lord.add(poker);
                continue;
            }

            //给三个玩家轮流发牌
            if(i % 3 == 0){
                player1.add(poker);
            }else if(i % 3 == 1){
                player2.add(poker);
            }else{
                player3.add(poker);
            }
        }
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

    }*/


}
