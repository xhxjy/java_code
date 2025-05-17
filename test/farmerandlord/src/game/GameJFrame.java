package game;

import domain.Poker;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Collections;

public class GameJFrame extends JFrame implements ActionListener {

    //统一获取界面的隐藏容器,省的后面多次调用this.getContentPane()来获得该容器
    public static Container container = null;

    //抢地主和不抢的两个按键
    JButton[] landlord = new JButton[2];

    //出牌和不出的两个按键
    JButton[] publishCard = new JButton[2];

    //地主的图标
    JLabel dizhu;

    //集合嵌套
    //玩家要出的牌
    ArrayList<ArrayList<Poker>> currentList = new ArrayList<>();

    //集合嵌套
    //玩家手上的牌
    ArrayList<ArrayList<Poker>> playerList = new ArrayList<>();

    //底牌
    ArrayList<Poker> lordList = new ArrayList<>();

    //牌盒,装所有的牌(组件)
    ArrayList<Poker> pokerList = new ArrayList();

    //3个倒计时组件
    JTextField time[] = new JTextField[3];

    public GameJFrame() {
        //设置任务栏的图标
        setIconImage(Toolkit.getDefaultToolkit().getImage("farmerandlord\\image\\poker\\dizhu.png"));
        //设置界面
        initJframe();
        //添加组件
        initView();
        //界面显示出来
        //先展示界面再发牌，因为发牌里面有动画，界面不展示出来，动画无法展示
        this.setVisible(true);

        //初始化牌
        //准备牌，洗牌，发牌，排序
        initCard();

        //打牌之前的准备工作
        //展示抢地主和不抢地主两个按钮并且再创建三个集合用来装三个玩家准备要出的牌
        initGame();
    }

    //初始化牌（准备牌，洗牌，发牌，排序）
    public void initCard() {
        //1.准备牌
        //双重循环添加即可
        for (int i = 1; i <= 5; i++) {
            for (int j = 1; j <= 13; j++) {
                //结束条件:大小王之后
                if (i == 5 && j > 2) {
                    break;
                }
                Poker poker = new Poker(i + "-" + j, false);//一开始发牌时牌面是反面
                pokerList.add(poker);
                //给牌创建位置,并将它添加到界面中
                poker.setLocation(350,150);
                container.add(poker);
            }
        }

        //2.洗牌
        Collections.shuffle(pokerList);

        //3.发牌
        //3.1 分为3个玩家的牌盒
        ArrayList<Poker> player0 = new ArrayList<>();
        ArrayList<Poker> player1 = new ArrayList<>();
        ArrayList<Poker> player2 = new ArrayList<>();
        //3.2 遍历牌盒,开始发牌
        for (int i = 0; i < pokerList.size(); i++) {
            Poker poker = pokerList.get(i);
            if (i < 3) {
                lordList.add(poker);
                //移动牌的效果
                Common.move(poker, poker.getLocation(), new Point(270 + (75 * i), 10));
                continue;
            }
            if (i % 3 == 0) {
                //左边的人机
                player0.add(poker);
                Common.move(poker, poker.getLocation(), new Point(50, 60 + i * 5));
            } else if (i % 3 == 1) {
                //自己
                player1.add(poker);
                Common.move(poker, poker.getLocation(), new Point(180 + i * 7, 450));
                //将自己的牌展示为正面
                poker.turnFront();
            } else {
                //右边的人机
                player2.add(poker);
                Common.move(poker, poker.getLocation(), new Point(700, 60 + i * 5));
            }
            //把当前的牌至于最顶端，这样就会有牌依次错开且叠起来的效果
            container.setComponentZOrder(poker, 0);
        }
        //3.3 将3个玩家的牌盒添加进玩家手上的大牌盒中,便于管理
        playerList.add(player0);
        playerList.add(player1);
        playerList.add(player2);

        //4.排序
        for (int i = 0; i < 3; i++) {
            ArrayList<Poker> playerPoker = playerList.get(i);
            //在后台数据中排序
            order(playerPoker);
            //使界面和后台同步排序
            Common.rePosition(this,playerPoker,i);
        }
    }

    //排序
    public void order(ArrayList<Poker> list) {
        Collections.sort(list, (o1, o2) -> {
            //方法底层:Arrays.sort()方法:快速排序和二分查找
            //o1:要插入无序序列的元素
            //o2:无序序列的元素

            //比较方法:
            //先比牌的价值,再比花色
            //1.获得牌的花色和价值
            //o1:
            String color1 = o1.getName().substring(0, 1);
            int value1 = getValue(o1);
            //o2:
            String color2 = o2.getName().substring(0, 1);
            int value2 = getValue(o2);

            //2.进行比较
            int result = value2 - value1;//因为在实际页面中,大的是放左边反过来放的,所以需要反过来相减;下面的花色同理
            result = result == 0 ? color2.compareTo(color1) : result;
            return result;
        });
    }

    //获取每一张牌的价值
    public int getValue(Poker poker) {
        //获得牌的数字和花色
        int color = Integer.parseInt(poker.getName().substring(0, 1));
        int num = Integer.parseInt(poker.getName().substring(2));

        //因为大小王,A,2的特殊性,单独对大小王,A,2进行赋值
        if (poker.getName().equals("5-1")) {
            //小王
            num = 16;
        } else if (poker.getName().equals("5-2")) {
            //大王
            num = 17;
        }else if(color!=5&&num==1){
            //A
            num=14;
        }else if(color!=5&&num==2){
            //2
            num=15;
        }
        return num;
    }


    //打牌之前的准备工作
    private void initGame() {
        //创建三个集合用来装三个玩家准备要出的牌
        for (int i = 0; i < 3; i++) {
            ArrayList<Poker> list = new ArrayList<>();
            //添加到大集合中方便管理
            currentList.add(list);
        }

        //展示抢地主和不抢地主两个按钮
        landlord[0].setVisible(true);
        landlord[1].setVisible(true);

        //展示自己前面的倒计时文本
        for (JTextField field : time) {
            field.setText("倒计时30秒");
            field.setVisible(true);
        }

    }


    @Override
    public void actionPerformed(ActionEvent e) {

    }

    //添加组件
    public void initView() {
        //创建抢地主的按钮
        JButton robBut = new JButton("抢地主");
        //设置位置
        robBut.setBounds(320, 400, 75, 20);
        //添加点击事件
        robBut.addActionListener(this);
        //设置隐藏
        robBut.setVisible(false);
        //添加到数组中统一管理
        landlord[0] = robBut;
        //添加到界面中
        container.add(robBut);

        //创建不抢的按钮
        JButton noBut = new JButton("不抢");
        //设置位置
        noBut.setBounds(420, 400, 75, 20);
        //添加点击事件
        noBut.addActionListener(this);
        //设置隐藏
        noBut.setVisible(false);
        //添加到数组中统一管理
        landlord[1] = noBut;
        //添加到界面中
        container.add(noBut);

        //创建出牌的按钮
        JButton outCardBut = new JButton("出牌");
        outCardBut.setBounds(320, 400, 60, 20);
        outCardBut.addActionListener(this);
        outCardBut.setVisible(false);
        publishCard[0] = outCardBut;
        container.add(outCardBut);

        //创建不要的按钮
        JButton noCardBut = new JButton("不要");
        noCardBut.setBounds(420, 400, 60, 20);
        noCardBut.addActionListener(this);
        noCardBut.setVisible(false);
        publishCard[1] = noCardBut;
        container.add(noCardBut);


        //创建三个玩家前方的提示文字：倒计时
        //每个玩家一个
        //左边的电脑玩家是0
        //中间的自己是1
        //右边的电脑玩家是2
        for (int i = 0; i < 3; i++) {
            time[i] = new JTextField("倒计时:");
            time[i].setEditable(false);
            time[i].setVisible(false);
            container.add(time[i]);
        }
        time[0].setBounds(140, 230, 60, 20);
        time[1].setBounds(374, 360, 60, 20);
        time[2].setBounds(620, 230, 60, 20);


        //创建地主图标
        dizhu = new JLabel(new ImageIcon("images/dizhu.png"));
        dizhu.setVisible(false);
        dizhu.setSize(40, 40);
        container.add(dizhu);


    }

    //设置界面
    public void initJframe() {
        //设置标题
        this.setTitle("斗地主");
        //设置大小
        this.setSize(830, 620);
        //设置关闭模式
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        //设置窗口无法进行调节
        this.setResizable(false);
        //界面居中
        this.setLocationRelativeTo(null);
        //获取界面中的隐藏容器，以后直接用无需再次调用方法获取了
        container = this.getContentPane();
        //取消内部默认的居中放置
        container.setLayout(null);
        //设置背景颜色
        container.setBackground(Color.LIGHT_GRAY);
    }


}