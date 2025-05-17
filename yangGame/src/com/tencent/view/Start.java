package com.tencent.view;

import com.tencent.model.Brand;

import javax.swing.*;

//游戏的启动入口
public class Start extends JFrame {
    private Brand brand=new Brand("刷子");

    //创建一个构造方法对游戏启动入口进行设置
    public Start() {
        //初始化界面
        initJFrame();
    }

    private void initJFrame() {
        this.setTitle("OvOjava版---羊了个羊");
        this.setSize(400,800);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);//关闭窗口同时并结束程序
        this.setLocationRelativeTo(null);//界面居中
        this.setVisible(true);
        // brand类(牌)继承Component类的原因:可以添加牌到当前窗口当中
        this.getContentPane().add(brand);
        //启动自动刷新线程
        //作用:不用将界面显示放到添加组件之后了;即不用将this.setVisible(true)语句放到this.getContentPane().add(brand)之后
        autoReflush();
    }

    //该方法就是开启一个线程去隔一段时间自动刷新界面
    private void autoReflush(){
        //保证刷新的是当前界面
        Start start=this;
        new Thread(new Runnable() {
            @Override
            public void run() {
                while (true){
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

    public static void main(String[] args) {
        new Start();
    }
}
