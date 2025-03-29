package ui;

import javax.swing.*;
import javax.swing.border.BevelBorder;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.Random;

//游戏界面
public class GameJFrame extends JFrame implements KeyListener, ActionListener {
    //创建一个二维数组,里面的数据相当于加载图片的序号
    int[][] arr = new int[4][4];//定义在成员位置的原因是有两个方法会用到它

    //因为移动图片会与序号为0的图片(即空白图片)产生关系,定义x,y两个变量记录图片的位置
    int x = 0;
    int y = 0;

    //定义一个变量,记录当前展示图片的路径(更换拼图图片时会用到)
    String path = "puzzlegame_test\\image\\animal\\animal3\\";

    //定义一个正确顺序的二维数组
    int[][] rightArr = {{1, 2, 3, 4}, {5, 6, 7, 8}, {9, 10, 11, 12}, {13, 14, 15, 0}};

    //定义一个变量,记录步数,不可定义在方法里,因为方法每调用一次,该变量就会被重新定义并赋值为0
    int count = 0;

    //创建各个选项中的子选项的对象(5个:更换图片,重新游戏,重新登录,关闭游戏;公众号)
    //功能
    JMenuItem replayItem = new JMenuItem("重新游戏");
    JMenuItem reLoginItem = new JMenuItem("重新登录");
    JMenuItem closeGameItem = new JMenuItem("关闭游戏");
    JMenu changeImage = new JMenu("更换图片");
    //更换图片里的子选项
    JMenuItem girlItem = new JMenuItem("美女");
    JMenuItem animalItem = new JMenuItem("动物");
    JMenuItem sportItem = new JMenuItem("运动");

    //关于我们
    JMenuItem accountItem = new JMenuItem("公众号");


    //构造方法
    public GameJFrame() {
        //初始化界面
        initJFrame();
        //初始化菜单
        initJMenuBar();
        //打乱图片
        messUpImage();
        //加载图片
        initImage();


        //显示界面,一般放最后
        this.setVisible(true);
    }

    //打乱图片的序号
    private void messUpImage() {
        Random r = new Random();
        int[] tempArr = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 0};//从1开始也可以
        for (int i = 0; i < tempArr.length; i++) {
            int index = r.nextInt(tempArr.length);
            int temp = tempArr[i];
            tempArr[i] = tempArr[index];
            tempArr[index] = temp;
        }
        //法2:
//        遍历一维数组直接给二维数组赋值
        for (int i = 0; i < tempArr.length; i++) {
            //记录一开始空白位置的坐标
            if (tempArr[i] == 0) {
                x = i / 4;
                y = i % 4;
            }
            arr[i / 4][i % 4] = tempArr[i];//行和列的参数的妙用
        }
    }

    //加载图片
    private void initImage() {
        //需要清空原本已经出现的所有图片
        this.getContentPane().removeAll();

        //通过对比打乱的数组和正确顺序的数组是否相同来判断是否胜利
        if (compareArr()) {
            //添加胜利的图标
            JLabel jLabel = new JLabel(new ImageIcon("puzzlegame_test\\image\\win.png"));
            jLabel.setBounds(203, 283, 197, 73);
            this.getContentPane().add(jLabel);
        }
        //设置步数的图标
        JLabel stepCount = new JLabel("步数:" + count);
        stepCount.setBounds(50, 30, 100, 20);
        this.getContentPane().add(stepCount);

        //先将全部图片用循环的方式展示,最后再来修改图片的内容(循序渐进)

        //外循环:改变行数
        for (int i = 0; i < 4; i++) {
            //内循环:同一行添加四张图片(先看内循环再看外循环)
            for (int j = 0; j < 4; j++) {//num++表示下次加载下一张图片
                //创建一个图片ImageIcon的对象
                //创建一个JLabel的对象(管理容器)
                //根据ImageIcon对象来创建对应的容器

                //不能直接将里面的1改为num,否则会将它认定为字符串,需要用到变量在字符串中的拼接方式
                //当num=0时,因为不存在第0张,所以会加载出一张空白
                int num = arr[i][j];//将打乱的序号，依次赋值给num,从而达到打乱图片的目的
                JLabel jLabel = new JLabel(new ImageIcon(path + num + ".jpg"));
                //指定图片位置
                jLabel.setBounds(105 * j + 83, 105 * i + 134, 105, 105);
                //添加图片的边框
                jLabel.setBorder(new BevelBorder(BevelBorder.RAISED));
                //把管理容器添加到界面中
                this.getContentPane().add(jLabel);//先将游戏界面下面空白的隐藏容器拿出来,后面再来添加图片
            }
        }

        //添加背景图片(先添加的图片在上面,后添加的在下面)
        JLabel jLabel = new JLabel(new ImageIcon("puzzlegame_test\\image\\background.png"));
        //调整其位置和大小
        jLabel.setBounds(40, 40, 508, 560);
        this.getContentPane().add(jLabel);

        //刷新界面(为什么)
        this.getContentPane().repaint();
    }

    //初始化菜单
    private void initJMenuBar() {
        //创建整个菜单对象
        JMenuBar jMenuBar = new JMenuBar();
        //创建菜单上的选项的对象(两个:功能,关于我们)
        JMenu functionJMenu = new JMenu("功能");
        JMenu abooutJMenu = new JMenu("关于我们");

        //将各个子选项添加到对应的选项中
        //功能
        functionJMenu.add(changeImage);
        functionJMenu.add(replayItem);
        functionJMenu.add(reLoginItem);
        functionJMenu.add(closeGameItem);
        //更换图片
        changeImage.add(girlItem);
        changeImage.add(animalItem);
        changeImage.add(sportItem);

        //关于我们
        abooutJMenu.add(accountItem);

        //将两个选项添加到菜单中
        jMenuBar.add(functionJMenu);
        jMenuBar.add(abooutJMenu);
        //给整个界面设置菜单
        this.setJMenuBar(jMenuBar);

        //给四个子选项添加动作监听
        replayItem.addActionListener(this);
        reLoginItem.addActionListener(this);
        closeGameItem.addActionListener(this);
        accountItem.addActionListener(this);
        //给更换图片里的3个子选项添加动作监听
        girlItem.addActionListener(this);
        animalItem.addActionListener(this);
        sportItem.addActionListener(this);
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
        //给整个界面添加键盘监听事件
        this.addKeyListener(this);
    }

    //判断两个二维数组是否相同
    public boolean compareArr() {
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                if (arr[i][j] != rightArr[i][j])
                    return false;
            }
        }
        return true;
    }

    @Override
    public void keyTyped(KeyEvent e) {

    }

    //按住A显示完整图片
    @Override
    public void keyPressed(KeyEvent e) {
        int code = e.getKeyCode();
        if (code == 65) {

            //需要清空原本已经出现的所有图片
            this.getContentPane().removeAll();

            JLabel all = new JLabel(new ImageIcon(path + "all.jpg"));
            //指定图片位置
            all.setBounds(83, 134, 420, 420);
            //把管理容器添加到界面中
            this.getContentPane().add(all);//先将游戏界面下面空白的隐藏容器拿出来,后面再来添加图片

            //添加背景图片
            JLabel bc = new JLabel(new ImageIcon("puzzlegame_test\\image\\background.png"));
            //调整其位置和大小
            bc.setBounds(40, 40, 508, 560);
            this.getContentPane().add(bc);

            //刷新界面(为什么)
            this.getContentPane().repaint();
        }

    }

    //在此方法中进行按键判断的原因是:若在keyPressed方法中判断,
    // 若你一直按住某按键不松,它会一直调用该方法;而此方法是松开按键才会执行
    @Override
    public void keyReleased(KeyEvent e) {
        //如果胜利了,就直接结束该方法,不让我们再移动拼图
        if (compareArr()) {
            return;
        }

        //对上下左右的按键进行判断
        int code = e.getKeyCode();
//这里的向下移动,是非空白格相对于空白格的移动,即空白格的上面一格向下移动,其他方向同理
        if (code == 37) {
            if (y == arr.length - 1) {
                System.out.println("不可向左移动");
            } else {
                count++;
                System.out.println("向左移动");
                //空白方块下方的数字向上移动,空白:x,y;空白下方:x+1,y
                //两者数字交换即可(因为空白的数字一直为0,无需借助第三方变量)
                arr[x][y] = arr[x][y + 1];
                arr[x][y + 1] = 0;
                y++;//空白的坐标发生了变化,需要++
                //按照当前变化了的坐标,重新加载图片
                initImage();
            }
        } else if (code == 38) {
            if (x == arr.length - 1) {
                System.out.println("不可向上移动");
            } else {
                count++;
                System.out.println("向上移动");
                //空白方块下方的数字向上移动,空白:x,y;空白下方:x+1,y
                //两者数字交换即可(因为空白的数字一直为0,无需借助第三方变量)
                arr[x][y] = arr[x + 1][y];
                arr[x + 1][y] = 0;
                x++;//空白的坐标发生了变化,需要++
                //按照当前变化了的坐标,重新加载图片
                initImage();
            }
        } else if (code == 39) {
            if (y == 0) {
                System.out.println("不可向右移动");
            } else {
                count++;
                System.out.println("向右移动");
                //空白方块下方的数字向上移动,空白:x,y;空白下方:x+1,y
                //两者数字交换即可(因为空白的数字一直为0,无需借助第三方变量)
                arr[x][y] = arr[x][y - 1];
                arr[x][y - 1] = 0;
                y--;//空白的坐标发生了变化,需要++
                //按照当前变化了的坐标,重新加载图片
                initImage();
            }
        } else if (code == 40) {
            if (x == 0) {
                System.out.println("不可向下移动");
            } else {
                count++;
                System.out.println("向下移动");
                //空白方块下方的数字向上移动,空白:x,y;空白下方:x+1,y
                //两者数字交换即可(因为空白的数字一直为0,无需借助第三方变量)
                arr[x][y] = arr[x - 1][y];
                arr[x - 1][y] = 0;
                x--;//空白的坐标发生了变化,需要--
                //按照当前变化了的坐标,重新加载图片
                initImage();
            }
        } else if (code == 65) {
            //松开A显示随机打乱的图片
            initImage();
        } else if (code == 66) {
            //松开b,一键通关
            //对原来打乱的二维数组按照通关的顺序对应的数据进行重新赋值
            arr = new int[][]{{1, 2, 3, 4}, {5, 6, 7, 8}, {9, 10, 11, 12}, {13, 14, 15, 0}};
            initImage();
        }
    }

    //动作监听
    @Override
    public void actionPerformed(ActionEvent e) {
        //获取按到的按键
        Object source = e.getSource();
        //对按到的按键进行判断
        //重新游戏
        if (source == replayItem) {
            //重新游戏
            count = 0;//步数要归零
            messUpImage();
            initImage();
        } else if (source == reLoginItem) {
            //重新登录
            //关闭当前游戏界面
//            this.getContentPane().removeAll();//只能将将界面下方空白的区域清空
            this.setVisible(false);
            //加载登录界面
            new LoginJFrame();
        } else if (source == closeGameItem) {
            //关闭游戏
            System.exit(0);
        } else if (source == accountItem) {
            //显示公众号的弹窗
            showAccount();
        } else if (source == girlItem) {
            //更换美女图片
            //更换图片
            Random r=new Random();
            int randomIndex = r.nextInt(13)+1;
            path="puzzlegame_test\\image\\girl\\girl"+randomIndex+"\\";//相当于把原来的全局变量给覆盖了
            //重新游戏
            count = 0;//步数要归零
            messUpImage();
            initImage();
        } else if (source == animalItem) {
            //更换动物图片
            //更换图片后重新游戏
            //更换图片
            Random r=new Random();
            int randomIndex = r.nextInt(8)+1;
            path="puzzlegame_test\\image\\animal\\animal"+randomIndex+"\\";//相当于把原来的全局变量给覆盖了
            //重新游戏
            count = 0;//步数要归零
            messUpImage();
            initImage();
        } else if (source == sportItem) {
            //更换运动图片
            //更换图片后重新游戏
            //更换图片
            Random r=new Random();
            int randomIndex = r.nextInt(10)+1;
            path="puzzlegame_test\\image\\sport\\sport"+randomIndex+"\\";//相当于把原来的全局变量给覆盖了
            //重新游戏
            count = 0;//步数要归零
            messUpImage();
            initImage();
        }
    }

    //显示公众号的弹窗
    private static void showAccount() {
        //添加公众号的弹窗
        JDialog jDialog = new JDialog();
        //添加图片
        JLabel account = new JLabel(new ImageIcon("puzzlegame_test\\image\\account.png"));
        //设置图片大小和位置(x,y是相对于弹窗的)
        account.setBounds(0, 0, 824, 1068);
        //将图片对应的容器加入到弹窗中
        jDialog.getContentPane().add(account);
        //设置弹窗大小
        jDialog.setSize(924, 1168);
        //让弹框置顶(在其他界面之上)
        jDialog.setAlwaysOnTop(true);
        //让弹框居中
        jDialog.setLocationRelativeTo(null);
        //弹框不关闭则无法操作下面的界面
        jDialog.setModal(true);
        //显示弹窗
        jDialog.setVisible(true);
    }
}
