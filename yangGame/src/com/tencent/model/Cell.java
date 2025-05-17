package com.tencent.model;

//单元格类:
// true:有牌;false:无牌
public class Cell {
    private boolean stage;//当前的状态有牌/无牌,即单元格是否为空.true:有牌;反之无牌
    private Brand brand;//牌的对象

    public Cell() {
    }

    public Cell(Brand brand,boolean stage) {
        this.brand = brand;
        this.stage=stage;
    }

    /**
     * 获取
     * @return stage
     */
    public boolean isStage() {
        return stage;
    }

    /**
     * 设置
     * @param stage
     */
    public void setStage(boolean stage) {
        this.stage = stage;
    }

    /**
     * 获取
     * @return brand
     */
    public Brand getBrand() {
        return brand;
    }

    /**
     * 设置
     * @param brand
     */
    public void setBrand(Brand brand) {
        this.brand = brand;
    }

    public String toString() {
        return "Cell{stage = " + stage + ", brand = " + brand + "}";
    }

    //展示

}
