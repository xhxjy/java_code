package com.tencent.util;

import com.tencent.model.Brand;
import com.tencent.model.Cell;
import com.tencent.model.Layer;

/*
* 工具类:和图层相关的操作
* */
public class LayerUtil {

    //创建图层
    public static Layer build(int row, int col) throws Exception {
        Layer layer=new Layer(row,col);
        //创建一个牌的数组
        Brand[] brands = BrandUtil.build(layer.getCapacity());

        //将牌填充到对应的图层中
        Cell[][] cells=layer.getCells();
        //将牌变为单元格,添加进对应的图层.
        // 本质:将一维数组赋值给二维数组
        //法1(更简洁)
        for (int i = 0; i < brands.length; i++) {
            //将牌变为单元格
            Cell cell = new Cell();
            cell.setStage(true);
            //通过下面这两步,单元格和牌能互相找到对方(主要目的:让牌能找到单元格,因为单元格相当于是牌的父类)
            //子类对象找对应的父类对象的方法
            //将牌塞给单元格
            cell.setBrand(brands[i]);
            //将单元格塞给牌
            brands[i].setCell(cell);

            cells[i/col][i%col]=cell;
        }
        //将更改后的单元格设置给图层的单元格
        layer.setCells(cells);
        //法2
        /*int k=0;
        for (int i = 0; i < arr2.length; i++) {
            for (int j = 0; j < arr2[i].length; j++,k++) {
                arr2[i][j]=arr1[k];
            }
        }*/
        return layer;
    }
}
