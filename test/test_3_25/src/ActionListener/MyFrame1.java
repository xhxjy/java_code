package ActionListener;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

//动作监听
//点到对应的按钮,触发对应的事件
public class MyFrame1 extends JFrame implements ActionListener {
    JButton jtb1 = new JButton("xjy");
    JButton jtb2 = new JButton("xhxjy");

    public MyFrame1() {
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

        //设置一个按钮及其大小
        jtb1.setBounds(0, 0, 200, 100);
        //点击按钮
        jtb1.addActionListener(this);

        //设置一个按钮及其大小
        jtb2.setBounds(100, 0, 200, 100);
        //点击按钮
        jtb2.addActionListener(this);

        //将按钮添加进到界面中
        this.getContentPane().add(jtb1);
        this.getContentPane().add(jtb2);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        //获取被操作的按钮对象
        Object source = e.getSource();
        //对按键进行判断
        if (source == jtb1) {
            System.out.println("xnl");
        } else if (source == jtb2) {
            Random r = new Random();
            jtb2.setLocation(r.nextInt(400),r.nextInt(400));
        }
    }
}
