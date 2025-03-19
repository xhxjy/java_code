package test_3_19;

import java.util.ArrayList;

public class PhoneTest {
    public static void main(String[] args) {
        ArrayList<Phone> list = new ArrayList<>();

        Phone p1 = new Phone("小米", 1000);
        Phone p2 = new Phone("苹果", 8000);
        Phone p3 = new Phone("锤子", 2999);

        list.add(p1);
        list.add(p2);
        list.add(p3);

        ArrayList<Phone> newList = judgePrice(list);
        //遍历即可
    }
//返回多个数据时,可以将这些数据存入一个容器(集合或数组)中,最后将容器返回即可
    public static ArrayList<Phone> judgePrice(ArrayList<Phone> list) {
        ArrayList<Phone> newList = new ArrayList<>();
        for (int i = 0; i < list.size(); i++) {
            Phone phone = list.get(i);
            if (phone.getPrice() < 3000) {
                newList.add(phone);//返回数据与直接打印数据不一样,若返回数据主方法中可以得到并利用那些数据
            }
        }
        return newList;
    }
}
