package domain;


import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

//牌是一个组件
public class Poker extends JLabel implements MouseListener {
    //属性
    //1.名字
    private String name;
    //2.正反面(不知道是正还是反,需要外界赋值)
    private boolean up;
    //3.是否可以被点击(根据正反面,默认是不可以,因为只有自己的牌可以被点击,别人的都不可以)
    private boolean canClick = false;//即使boolean类型的默认值是false,但仍然需要主动赋值给它,这样可以提高代码的可读性
    //4.是否已经被点击(默认是未被点击)
    private boolean clicked = false;


    public Poker(String name, boolean up) {
        this.name = name;
        this.up = up;
        //判断当前的牌是正面还是反面
        if (this.up) {
            //1.正面
            this.turnFront();
        } else {
            //2.反面
            this.turnRear();
        }
        //设置牌的宽高
        this.setSize(71, 96);
        //将牌显示出来
        this.setVisible(true);
        //给每张牌设置鼠标监听
        this.addMouseListener(this);
    }

    //方法
    //1.显示正面
    public void turnFront() {
        //给牌设置正面的图片
        this.setIcon(new ImageIcon("farmerandlord\\image\\poker\\" + name + ".png"));
        //修改成员变量
        this.up = true;
    }

    //2.显示反面
    public void turnRear() {
        this.setIcon(new ImageIcon("farmerandlord\\image\\poker\\rear.png"));
        this.up = false;
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        //点击
        //可以被点击
        if (canClick) {
            //y轴的像素变化
            int step = 0;
            if (clicked) {
                //未被点击
                //牌上升
                step = -20;
            } else {
                //被点击
                //牌下降
                step = 20;
            }
            //将牌的位置进行修改
            //1.获得牌的起始位置
            Point from = this.getLocation();
            //2.创建point对象,获得牌的结束位置
            Point to = new Point(from.x, from.y + step);
            //3.将结束位置赋值给牌
            this.setLocation(to);

            //被点击之后,状态发生改变,要取反
            clicked = !clicked;
        }
    }

    @Override
    public void mousePressed(MouseEvent e) {

    }

    @Override
    public void mouseReleased(MouseEvent e) {

    }

    @Override
    public void mouseEntered(MouseEvent e) {

    }

    @Override
    public void mouseExited(MouseEvent e) {

    }

    /**
     * 获取
     *
     * @return name
     */
    public String getName() {
        return name;
    }

    /**
     * 设置
     *
     * @param name
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * 获取
     *
     * @return up
     */
    public boolean isUp() {
        return up;
    }

    /**
     * 设置
     *
     * @param up
     */
    public void setUp(boolean up) {
        this.up = up;
    }

    /**
     * 获取
     *
     * @return canClick
     */
    public boolean isCanClick() {
        return canClick;
    }

    /**
     * 设置
     *
     * @param canClick
     */
    public void setCanClick(boolean canClick) {
        this.canClick = canClick;
    }

    /**
     * 获取
     *
     * @return clicked
     */
    public boolean isClicked() {
        return clicked;
    }

    /**
     * 设置
     *
     * @param clicked
     */
    public void setClicked(boolean clicked) {
        this.clicked = clicked;
    }

    public String toString() {
        return "Poker{name = " + name + ", up = " + up + ", canClick = " + canClick + ", clicked = " + clicked + "}";
    }
}
