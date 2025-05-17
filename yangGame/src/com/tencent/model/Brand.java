package com.tencent.model;

import com.tencent.test.TestRenderMap;

import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

//Brand是游戏中的一张牌
public class Brand extends Component{
    //属性

    private String name;//牌名
    private boolean isGray;//是否为灰色
    private Image image;//正常的图片
    private Image grayImage;//灰色的图片

    //坐标(牌在渲染的时候,左上角的坐标)
    private int x;
    private int y;

    //宽高
    private int width;
    private int height;
    //牌对应的的单元格对象
    private Cell cell;
    //创建消除区域类的对象
    EliminateBox eb= new EliminateBox();

    //构造方法只需传入name一个参数即可,通过name来实现图片的初始化
    public Brand(String name) {
        this.name = name;
        //根据图片的名字来创建图片
        this.image=Toolkit.getDefaultToolkit().getImage("imgs\\"+name+".png");
        this.grayImage=Toolkit.getDefaultToolkit().getImage("imgs\\"+name+"_gray.png");

        this.isGray=false;//默认牌是亮的
        //设置宽高
        this.width=50;
        this.height=50;

        //添加鼠标监听事件
        // 通过创建内部类重写被点击后方法的代码
        //另一个方法就是让本类实现MouseListener接口来重写全部方法,但因为我们只要用其中的一个方法所以用内部类的方式更简洁
        this.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                Brand brand = (Brand) e.getSource();//获取当前被点击的对象
                if(brand.isIsGray()){
                    //灰色
                    System.out.println("牌为灰色,不可被点击");
                }else{
                    //正常色
                    System.out.println("牌被点击了");
            //通过调用父级容器来删除自己,一般树型结构的对象会用这种方式来删除自己.父级容器就是当前的游戏界面
//                    brand.getParent().remove(brand);
                    eb.delete(brand);
            //细节:上一步只是在界面中将brand删除了,实际上其对应的单元格中的brand对象和牌的状态stage并未发生改变/删除
                    //所以还要删除数据模型中的数据和对应的状态
                    cell.setBrand(null);
                    cell.setStage(false);
                    //牌删掉后,需要判断整个map地图中哪些需要置灰
                    //需要调用map对象的方法(将map改为静态的,共享它)
                    TestRenderMap.map.compareAll();
                }
            }
        });
    }



    //绘制图片(继承Component类的原因)
    @Override
    public void paint(Graphics g) {
        if(this.isGray){
            //绘制灰色的图片
            g.drawImage(this.grayImage,this.x,this.y,null);
        }else{
            //绘制正常的图片
            g.drawImage(this.image,this.x,this.y,null);
        }
    }

    public Cell getCell() {
        return cell;
    }

    public void setCell(Cell cell) {
        this.cell = cell;
    }

    /**
     * 获取
     * @return name
     */
    public String getName() {
        return name;
    }

    /**
     * 设置
     * @param name
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * 获取
     * @return isGray
     */
    public boolean isIsGray() {
        return isGray;
    }

    /**
     * 设置
     * @param isGray
     */
    public void setIsGray(boolean isGray) {
        this.isGray = isGray;
    }

    /**
     * 获取
     * @return image
     */
    public Image getImage() {
        return image;
    }

    /**
     * 设置
     * @param image
     */
    public void setImage(Image image) {
        this.image = image;
    }

    /**
     * 获取
     * @return grayImage
     */
    public Image getGrayImage() {
        return grayImage;
    }

    /**
     * 设置
     * @param grayImage
     */
    public void setGrayImage(Image grayImage) {
        this.grayImage = grayImage;
    }

    //问题:本地自动生成的坐标和宽高的get和set方法与Component类中自带的重复了,所以要将所有的自动生成的get/set方法删除

    public String toString() {
        return "Brand{name = " + name + ", isGray = " + isGray + ", image = " + image + ", grayImage = " + grayImage + ", x = " + x + ", y = " + y + ", width = " + width + ", height = " + height + "}";
    }

}
