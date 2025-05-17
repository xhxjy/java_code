package keylistener;

import javax.swing.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

//键盘监听
//按到对应的键盘
public class MyFrame2 extends JFrame implements KeyListener {

    public MyFrame2() {
        //初始化界面
        initJFrame();
//        //初始化菜单
//        initJMenuBar();
//        //打乱图片
//        messUpImage();
//        //初始化图片
//        intiImage();


        //显示界面,一般放最后
        this.setVisible(true);
    }
    //初始化界面
    private void initJFrame() {
        //设置界面的宽高
        this.setSize(603, 680);
        //设置界面的标题
        this.setTitle("拼图游戏(单机版)  V1.0");
        //设置界面置顶,即在屏幕的最外层(点击游戏界面以外区域,游戏界面不会消失)
        this.setAlwaysOnTop(true);
        //设置界面居中
        this.setLocationRelativeTo(null);
        //设置游戏的关闭模式
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);//表示关掉一个界面,其它全部界面都关闭
        //取消默认的居中方式,按照我们想要的x,y轴的形式添加组件
        this.setLayout(null);

        //给整个窗口添加键盘监听
        this.addKeyListener(this);
    }

    @Override
    public void keyTyped(KeyEvent e) {

    }

    //细节1:如果我们按下按键不松,则会反复调用keyPressed的方法
    @Override
    public void keyPressed(KeyEvent e) {
        System.out.println("按住不松");
    }

    @Override
    public void keyReleased(KeyEvent e) {
        System.out.println("松开");
        //获取键盘上每个按键的编号,从而来辨别按下的是哪个键
        int code = e.getKeyCode();
        if(code==65){
            System.out.println("A");
        } else if (code == 66) {
            System.out.println("B");
        }
    }
}
