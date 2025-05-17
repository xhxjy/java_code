package com.tencent.model;

import java.util.Random;

/*
 * 图层类
 * 二维表格(由单元格组成)*/
public class Layer {
    //水平和垂直偏移量
    private int offsetX;
    private int offsetY;
    //行和列
    private int row;//行
    private int col;//列

    //当前图层的最大容量和实际容量
    private int capacity;//最大容量
    private int size;//实际容量.当牌添加/减少时需要改变值
    //图层的尺寸由行和列决定
    private Cell[][] cells = null;

    private Layer parent;//图层的上一层

    //由于图层的尺寸,最大容量和实际容量都是由行和列决定的,所以构造方法只要行和列两个参数
    public Layer(int row, int col) throws Exception {
        this.row = row;
        this.col = col;
        this.capacity = this.row * this.col;
        //通过自定义异常来保证图层容量是3的倍数
        if (this.capacity % 3 != 0) {
            throw new Exception("图层容量不是3的倍数!!!");
        }
        this.cells = new Cell[this.row][this.col];
        this.size = 0;//当前默认为0

        //每个图层都有自己的随机偏移量
        this.offsetX=new Random().nextInt(100);
        this.offsetY=new Random().nextInt(100);
    }

    public Layer getParent() {
        return parent;
    }

    public void setParent(Layer parent) {
        this.parent = parent;
    }

    public int getOffsetX() {
        return offsetX;
    }

    public void setOffsetX(int offsetX) {
        this.offsetX = offsetX;
    }

    public int getOffsetY() {
        return offsetY;
    }

    public void setOffsetY(int offsetY) {
        this.offsetY = offsetY;
    }

    /**
     * 获取
     *
     * @return row
     */
    public int getRow() {
        return row;
    }

    /**
     * 设置
     *
     * @param row
     */
    public void setRow(int row) {
        this.row = row;
    }

    /**
     * 获取
     *
     * @return col
     */
    public int getCol() {
        return col;
    }

    /**
     * 设置
     *
     * @param col
     */
    public void setCol(int col) {
        this.col = col;
    }

    /**
     * 获取
     *
     * @return capacity
     */
    public int getCapacity() {
        return capacity;
    }

    /**
     * 设置
     *
     * @param capacity
     */
    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    /**
     * 获取
     *
     * @return size
     */
    public int getSize() {
        return size;
    }

    /**
     * 设置
     *
     * @param size
     */
    public void setSize(int size) {
        this.size = size;
    }

    /**
     * 获取
     *
     * @return cells
     */
    public Cell[][] getCells() {
        return cells;
    }

    /**
     * 设置
     *
     * @param cells
     */
    public void setCells(Cell[][] cells) {
        this.cells = cells;
    }

    public String toString() {
        return "Layer{row = " + row + ", col = " + col + ", capacity = " + capacity + ", size = " + size + ", cells = " + cells + "}";
    }

    //展示图层数据
    public void showCells(){
        //遍历二维数组的结果
        for (int i = 0; i < cells.length; i++) {//行
            for (int j = 0; j < cells[i].length; j++) {
                System.out.print(cells[i][j].getBrand().getName()+"-");
            }
            System.out.println();
        }
    }
}
