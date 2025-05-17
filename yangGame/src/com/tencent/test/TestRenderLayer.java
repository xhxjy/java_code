package com.tencent.test;

import com.tencent.model.Brand;
import com.tencent.model.Cell;
import com.tencent.model.Layer;
import com.tencent.util.LayerUtil;
import com.tencent.view.Start;

import javax.swing.*;
import java.awt.*;

/*
 * 测试渲染图层的数据
 * */
public class TestRenderLayer extends JFrame {
    //创建一个图层
    private Layer layer = LayerUtil.build(6, 6);

    public TestRenderLayer() throws Exception {
        //1.初始化窗口的基本信息
        init();
        //2.渲染图层
        renderLayer();
        //3.自动刷新
        autoReflush();
    }

    private void renderLayer() {
        Cell[][] cells = layer.getCells();
        for (int row = 0; row < cells.length; row++) {
            for (int col = 0; col < cells[row].length; col++) {
                Brand brand = cells[row][col].getBrand();
                int x = col * 50;
                int y = row * 50;
                brand.setBounds(x, y, 50, 50);
                this.getContentPane().add(brand);
            }
        }
    }

    //该方法就是开启一个线程去隔一段时间自动刷新界面
    private void autoReflush() {
        //保证刷新的是当前界面
        JFrame start = this;
        new Thread(new Runnable() {
            @Override
            public void run() {
                while (true) {
                    //重新绘制界面
                    start.repaint();
                    try {
                        //每隔50ms刷新一次
                        Thread.sleep(50);
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                }
            }
        }).start();
    }

    private void init() {
        this.setTitle("OvOjava版---羊了个羊");
        this.setSize(450, 800);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);//关闭窗口同时并结束程序
        this.setLocationRelativeTo(null);//界面居中
        //设置绝对布局的布局方式
        this.setLayout(null);
        // 移除setBounds调用以避免覆盖居中设置
        // this.setBounds(0, 0, 450, 800);
        this.setVisible(true);

    }

    public static void main(String[] args) throws Exception {
        new TestRenderLayer();
    }
}