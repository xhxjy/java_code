package com.tencent.util;

import com.tencent.model.Brand;
import com.tencent.model.Cell;
import com.tencent.model.Layer;
import com.tencent.model.Map;

import java.awt.*;
import java.util.Collections;
import java.util.List;

public class MapUtil {
    //根据图层高度创建图层
    public static Map build(int floorHeight) throws Exception {
        //创建map对象,得到对应的集合并设置对应的图层高度
        Map map = new Map();
        List<Layer> layers = map.getLayers();
        map.setFloorHeight(floorHeight);

        //创建图层,并添加进图层集合中
        //细节:先加入的图层集合的,即先加载到界面中的图层,先显示在最上层.并不是后加入的会将前面的覆盖
        Layer layer1 = LayerUtil.build(6, 6);
        Layer layer2 = LayerUtil.build(6, 6);
        Layer layer3 = LayerUtil.build(6, 6);

        //构建图层的链式关系
        layer3.setParent(layer2);
        layer2.setParent(layer1);
        layer1.setParent(null);//当parent==null时,表明此时图层已经是最顶层了.这是循环或递归的重要结束条件
        //添加进集合中后它们之间有线性关系
        Collections.addAll(layers, layer1, layer2, layer3);
        return map;
    }

    //判断当前牌和指定图层的所有牌是否有矩阵交集
    //矩阵交集:图层是由一个个牌组成的,一张牌有宽和长,x和y坐标.相当于一个矩形,所以称为矩阵交集
    //true:有交集,显示灰色;false:无交集,显示正常色
    public static boolean compare(Brand brand, Layer layer) {
        Cell[][] cells = layer.getCells();
        for (int row = 0; row < cells.length; row++) {
            for (int col = 0; col < cells[row].length; col++) {
                //判断是否有牌(单元格是否为空)
                //只需判断有牌的,无牌的无需比较
                if (cells[row][col].isStage()) {
                    //有牌
                    //获得图层中的任意一张牌的矩阵对象
                    Rectangle temp = cells[row][col].getBrand().getBounds();
                    //获得当前牌的矩阵对象
                    Rectangle rect = brand.getBounds();
                    //有交集
                    if (rect.intersects(temp)) {
                        return true;
                    }
                }
            }
        }
        //此时:当前牌与指定层无交集
        //先判断其更上层是否存在
        //若存在,我们要让当前牌和更上层中的牌进行比较(同上理,需用递归)
        if (layer.getParent() != null) {
            compare(brand, layer.getParent());
        }
        //若不存在,则无交集
        return false;
    }
}
