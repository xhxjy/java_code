package com.tencent.model;

import com.tencent.util.MapUtil;

import java.util.ArrayList;
import java.util.List;

/*
 * 地图:一个地图包含多个图层,层层遮盖*/
public class Map {
    private int floorHeight;//层高,即有几张图层.与游戏难度相关
    private List<Layer> layers = new ArrayList<>();//创建集合,存放图层数据

    public int getFloorHeight() {
        return floorHeight;
    }

    public void setFloorHeight(int floorHeight) {
        this.floorHeight = floorHeight;
    }

    public List<Layer> getLayers() {
        return layers;
    }

    public void setLayers(List<Layer> layers) {
        this.layers = layers;
    }

    //判断当前map中的牌(除了最顶层)是否置灰
    //多层循环:性能差
    //使用场景:
    //1.游戏开始时
    //2.牌被点击后(判断被点击的牌消失后,有些牌是否还需要置灰)
    public void compareAll() {
        //细节:i=1.因为i=0表示最顶层,无需判断,所以索引从1开始
        for (int i = 1; i < layers.size(); i++) {
            //获得图层和图层的单元格
            Layer layer = layers.get(i);
            Cell[][] cells = layer.getCells();
            //遍历图层
            for (int row = 0; row < cells.length; row++) {//行
                for (int col = 0; col < cells[row].length; col++) {
                    Cell cell = cells[row][col];
                    if(cell.isStage()){
                        //该单元格有牌
                        Brand brand = cell.getBrand();
                        //判断这张牌与所有上层的所有牌是否有交集
                        boolean result = MapUtil.compare(brand, layer.getParent());
                        //无交集,即false:为正常色
                        brand.setIsGray(result);
                    }
                }
            }
        }
    }
}
