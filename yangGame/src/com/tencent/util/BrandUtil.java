package com.tencent.util;

import com.tencent.model.Brand;

import java.util.Random;

/*
* 工具类:实现牌相关的功能
* */
public class BrandUtil {

    //随机类,因为经常用到所以设为静态
    public static Random r=new Random();
    //定义一个包含所有牌的数组
    public static String[] brandNames={
            "刷子","剪刀","叉子","手套",
            "水桶","火","玉米","球",
            "瓶子","白菜","稻草","肉腿",
            "胡萝卜","苹果","铃铛","青草"
    };

    //每次调用都随机获取一张牌的名称
    public static String getBrandName(){
        int index = r.nextInt(brandNames.length);
        return brandNames[index];
    }

    //创建随机牌的数组
    public static Brand[] build(int capacity){
        //创建一个牌的数组
        Brand[] brands = new Brand[capacity];//牌的长度和图层的最大容量一样
        //随机的一个牌名,创建三张牌,赋值给数组中的牌
//细节:一次创建三张牌的原因:游戏的逻辑就是三张相同的牌消除,以推进游戏进程,若出现的牌不是三张三张的成对出现,则游戏无法胜利
        //一次创建3张牌导致的问题:必须保证图层容量为3的倍数
        for (int i = 0; i < brands.length; i+=3) {
            String brandName = getBrandName();
            brands[i]= new Brand(brandName);
            brands[i+1]= new Brand(brandName);
            brands[i+2]= new Brand(brandName);
        }
        //打乱牌组,即打乱数组
        //遍历数组,随机元素依次交换
        for (int i = 0; i < brands.length; i++) {
            //随机抽取一张牌
            int index = r.nextInt(brands.length);
//这样借助第三方变量进行交换,并未对随机的那张牌的值进行修改.例如:随机的那张牌为"铃铛",第一张牌为"刷子";一开始brands[index]和randomBrand都为"铃铛"
//交换后brands[i]为"铃铛",randomBrand变为"刷子",而实际的随机牌 brands[index]没变,还是"铃铛",这会导致牌的异常
            //所以无需借助第三方变量进行交换,直接进行交换即可
            //Brand randomBrand = brands[index];
            //交换牌
            /*Brand temp=brands[i];
            brands[i]=randomBrand;
            randomBrand=temp;*/

            //交换牌
            Brand temp=brands[i];
            brands[i]=brands[index];
            brands[index]=temp;
        }
        return brands;
    }
}
