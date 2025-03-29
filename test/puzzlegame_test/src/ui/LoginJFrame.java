package ui;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

//登录界面
public class LoginJFrame extends JFrame implements ActionListener {
    JButton jtb1 = new JButton("登录");
    JButton jtb2 = new JButton("注册");

    //用户名,密码,验证码的输入框对象
    JTextField userName=new JTextField();
    JPasswordField password=new JPasswordField();
    JTextField code = new JTextField();
    //正确的验证码
    JLabel rightCode = new JLabel();
    //因为暂时没有注册功能,只能先初始化一些注册信息
    static ArrayList<User> list=new ArrayList<>();
    static{
        list.add(new User("xjy","20000624"));
        list.add(new User("zqg","20060727"));
    }

    //展示界面,并在界面上设置相关信息
    public LoginJFrame(){//空参构造
        //初始化界面
        initJFrame();
        //丰富界面
        enrichJFrane();
        //显示界面
        this.setVisible(true);
    }

    private void initJFrame() {
        this.setSize(488,430);
        //设置界面的标题
        this.setTitle("拼图游戏 登录");
        //设置界面置顶,即在屏幕的最外层(点击游戏界面以外区域,游戏界面不会消失)
        this.setAlwaysOnTop(true);
        //设置界面居中
        this.setLocationRelativeTo(null);
        //设置游戏的关闭模式
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);//表示关掉一个界面,其它全部界面都关闭
    }

    private void enrichJFrane() {
        //对下面空白区域进行补充

        //1.添加用户名,密码,验证码
        //创建用户名及其文本框
        JLabel userNameJLabel = new JLabel(new ImageIcon("puzzlegame_test\\image\\login\\用户名.png"));
        //调整其位置和大小
        userNameJLabel.setBounds(116, 135, 51, 19);
        userName.setBounds(195, 134, 200, 30);
        //添加到界面中
        this.getContentPane().add(userNameJLabel);
        this.getContentPane().add(userName);

        //创建密码及其文本框
        JLabel passwordJLabel = new JLabel(new ImageIcon("puzzlegame_test\\image\\login\\密码.png"));
        //调整其位置和大小
        passwordJLabel.setBounds(130, 195, 35, 18);
        password.setBounds(195, 195, 200, 30);
        //添加到界面中
        this.getContentPane().add(passwordJLabel);
        this.getContentPane().add(password);

        //验证码及其输入框
        JLabel codeText = new JLabel(new ImageIcon("puzzlegame_test\\image\\login\\验证码.png"));
        //调整其位置和大小
        codeText.setBounds(133, 256, 50, 30);
        code.setBounds(195, 256, 100, 30);
        //添加到界面中
        this.getContentPane().add(codeText);
        this.getContentPane().add(code);

        //设置内容
        String codeStr =CodeUtil.getCode();
        rightCode.setText(codeStr);
        //位置和宽高
        rightCode.setBounds(300, 256, 50, 30);
        //添加到界面
        this.getContentPane().add(rightCode);

        //创建登录和注册按钮
        jtb1.setBounds(123, 310, 128, 47);
        jtb2.setBounds(256, 310, 128, 47);
        jtb1.setIcon(new ImageIcon("puzzlegame_test\\image\\login\\登录按钮.png"));
        jtb2.setIcon(new ImageIcon("puzzlegame_test\\image\\login\\注册按钮.png"));
        //去除按钮的默认边框
        jtb1.setBorderPainted(false);
        jtb2.setBorderPainted(false);
        //去除按钮的默认背景
        jtb1.setContentAreaFilled(false);
        jtb2.setContentAreaFilled(false);
        //将两个按钮添加进界面中
        this.getContentPane().add(jtb1);
        this.getContentPane().add(jtb2);
        //给两个按钮绑定动作事件
        jtb1.addActionListener(this);
        jtb2.addActionListener(this);


        //创建背景色
//        JLabel bcColor=new JLabel();

        //2.添加登录的背景(要放到最后添加)
        //添加背景图片(先添加的图片在上面,后添加的在下面)
        JLabel jLabel = new JLabel(new ImageIcon("puzzlegame_test\\image\\login\\background.png"));
        //调整其位置和大小
        jLabel.setBounds(0, 0, 470, 390);
        this.getContentPane().add(jLabel);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        Object source = e.getSource();
        if(source==jtb1){
            //登录
            //获取两个文本框输入的内容,和验证码(若为空,返回的值为"",而并非为初始化的null)
            String name = userName.getText();
            char[] input = password.getPassword();
            String password = new String(input);
            String codeText  = code.getText();
            //创建一个User对象,用来存储输入的用户名和密码(用到了封装思想)
            User u=new User(name,password);

            //先判断验证码是否为空,后面再判断其是否正确
            if(codeText.isEmpty()){
                showWarning("验证码不可为空");
            }else if(!codeText.equalsIgnoreCase(rightCode.getText())){
                showWarning("验证码错误");
            }else if(name.isEmpty()||password.isEmpty()){//先判断用户名或密码是否为空,后面再判断其是否正确
                    //设置一个弹窗提示:用户名或密码不可为空
                    showWarning("用户名或密码不可为空");
            }else if(isRight(u)){
                    //登录成功
                    //关闭当前登录界面
                    this.setVisible(false);
                    //打开游戏界面
                    new GameJFrame();
            } else{
                showWarning("用户名或密码错误");
            }
        } else if (source == jtb2) {
            System.out.println("注册");
        }else if(source == rightCode){
            System.out.println("更换验证码");
            //刷新验证码(里面存储的值和界面展示的内容)
            String code =CodeUtil.getCode();
            rightCode.setText(code);//设置界面的内容
        }
    }

    //判断用户名和密码是否正确
    private static boolean isRight(User user) {
        int i;
        for (i = 0; i < list.size(); i++) {
            User u = list.get(i);
            if(user.getName().equals(u.getName())){
                if(user.getPassword().equals(u.getPassword())){
                    //登录成功
                    return true;
                }
            }
        }
        return false;
    }

    //警告弹窗
    private static void showWarning(String content) {
        //添加弹窗
        JDialog jDialog = new JDialog();
        //设置弹窗大小
        jDialog.setSize(200,150);
        //让弹框置顶(在其他界面之上)
        jDialog.setAlwaysOnTop(true);
        //让弹框居中
        jDialog.setLocationRelativeTo(null);
        //弹框不关闭则无法操作下面的界面
        jDialog.setModal(true);
        //用JLabel对象管理文字,添加警告内容
        JLabel warning = new JLabel(content);
        //设置文字大小和位置(x,y是相对于弹窗的)
        warning.setBounds(0, 0, 200,150);
        //将图片对应的容器加入到弹窗中
        jDialog.getContentPane().add(warning);
        //显示弹窗
        jDialog.setVisible(true);
    }
}

