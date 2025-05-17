package com.tencent.test;

import com.tencent.model.Layer;
import com.tencent.model.Map;
import com.tencent.util.LayerUtil;

import java.util.Collections;
import java.util.List;

public class TestBuildMap {
    public static void main(String[] args) throws Exception {
        //创建map对象,得到对应的集合并设置对应的图层高度
        Map map = new Map();
        List<Layer> layers = map.getLayers();
        map.setFloorHeight(3);

        //创建图层,并添加进图层集合中
        Layer layer1 = LayerUtil.build(3, 3);
        Layer layer2 = LayerUtil.build(6, 6);
        Layer layer3 = LayerUtil.build(9, 9);

        Collections.addAll(layers,layer1,layer2,layer3);
        //遍历集合
        for (int i = 0; i < layers.size(); i++) {
            System.out.println("第"+(i+1)+"个图层");
            layers.get(i).showCells();
        }
    }
}
