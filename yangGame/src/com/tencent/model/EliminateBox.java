package com.tencent.model;

import javax.swing.*;
import java.util.*;
import java.util.Map;
import java.util.stream.Collectors;

/*
* 消除区域:牌消除的地方*/
public class EliminateBox {
    //创建一个集合,存放消除牌
    private static List<Brand> list=new ArrayList<>();

    //消除牌
    public void delete(Brand brand){
        list.add(brand);
        //将消除区域的牌根据牌的名称进行排序
        //法1
        list.sort(Comparator.comparing(Brand::getName));
        //法2
        //上面的语句使用了方法引用的语法,与下面这个方法类似
        /*list.sort(new Comparator<Brand>() {
            @Override
            public int compare(Brand b1, Brand b2) {
                return b1.getName().compareTo(b2.getName());
            }
        });*/
        //获取牌的名称,并将长度为3的牌进行删除
        //按牌名分组收集
        //法1
        Map<String, List<Brand>> map = list.stream().collect(Collectors.groupingBy(Brand::getName));
        //法2
        /*// 替换分组方式
        //牌名为键,牌的集合为值
        Map<String, List<Brand>> map = new HashMap<>();
        for (Brand b : list) {
            String name = b.getName();
            if (!map.containsKey(name)) {
                map.put(name, new ArrayList<>());
            }
            map.get(name).add(b);
        }*/
        //遍历牌的集合,即map集合
        Set<String> key = map.keySet();
        for (String s : key) {
            List<Brand> brands = map.get(s);
//不写为==3是因为可能会出现数据加载过慢,或加载错误的意外情况,即可能会出现4张或以上相同牌的情况;写为>=3更安全
            if(brands.size()>=3){
                //消除长度为3的相同牌
                deleteByBrandName(s);
                break;
            }
        }
        paint();
        gameOver(brand);
    }

    //迭代器清空集合
    //用迭代器遍历list集合删除超过3张的同名的牌
    void deleteByBrandName(String name){
        Iterator<Brand> it = list.iterator();
        while (it.hasNext()){
            Brand brand = it.next();
            if(brand.getName().equals(name)){
                //通过调用父级容器来删除自己,一般树型结构的对象会用这种方式来删除自己.父级容器就是当前的游戏界面
                brand.getParent().remove(brand);
                //集合中删除数据
                it.remove();
            }
        }
    }

    void gameOver(Brand brand){
        //设置未消除的牌多达7个时就游戏结束(这个数字可以自行调整)
        if(list.size()>=7){
            JOptionPane.showMessageDialog(brand,"游戏结束");
            System.exit(0);
        }
    }

    //将点击的牌绘制到消除框
    void paint(){
        //
        for (int i = 0; i < list.size(); i++) {
            Brand brand = list.get(i);
            //x表示在消除框中的水平位置,每张牌间隔10像素(表达式类似于一次函数)
            int x=i*brand.getWidth()+10;
            //设置牌的位置,将y轴写死是因为要保证消除框处于同一垂直面
            brand.setBounds(x,600,50,50);
        }
    }
}
