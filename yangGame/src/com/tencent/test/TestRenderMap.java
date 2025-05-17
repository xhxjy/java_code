package com.tencent.test;

import com.tencent.model.*;
import com.tencent.util.MapUtil;

import javax.swing.*;
import java.util.List;

/*
 * 测试渲染图层的数据
 * */
public class TestRenderMap extends JFrame {
    //创建一个图层
    public static Map map;

    static {
        try {
            map = MapUtil.build(3);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public TestRenderMap() throws Exception {
        //1.初始化窗口的基本信息
        init();
        //2.渲染图层
        //遍历地图中的图层集合,渲染其中的每一个图层
        List<Layer> layers = map.getLayers();
        for (int i = 0; i < layers.size(); i++) {
            renderLayer(layers.get(i));
        }
        //游戏开始时,判断当前牌哪些需要置灰
        map.compareAll();
        //3.自动刷新
        autoReflush();
        //播放背景音乐
        new Music().music();
    }

    private void renderLayer(Layer layer) {
        Cell[][] cells = layer.getCells();
        layer.showCells();
        //细节:渲染图层中的图片时,需要加上对应的x和y的偏移量
        for (int row = 0; row < cells.length; row++) {
            for (int col = 0; col < cells[row].length; col++) {
                Brand brand = cells[row][col].getBrand();
                int x = col * 50+layer.getOffsetX();
                int y = row * 50+layer.getOffsetY();
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
//        this.setBounds(0, 0, 450, 800);
        this.setVisible(true);
    }

    public static void main(String[] args) throws Exception {
        new TestRenderMap();
    }
}