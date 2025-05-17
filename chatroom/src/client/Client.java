package client;

import java.io.*;
import java.net.Socket;
import java.util.Scanner;

public class Client {
    static Socket socket;
    public static void main(String[] args) throws IOException {
        socket = new Socket("127.0.0.1", 10086);
        //连接服务器成功(显示对应的菜单)
        Scanner sc = new Scanner(System.in);
        System.out.println("服务器已经连接成功");
        while (true) {
            //菜单
            menu();
            //细节:键盘录入选项时直接用nextLine更好
            //若为下面这种转为int类型的,若录入的是abc,则会出现数字转换失败,导致程序报错
//            int choice = Integer.parseInt(sc.nextLine());
            String choice = sc.nextLine();
            switch (choice) {
                case "1" -> login(socket);
                case "2" -> register();
                default -> System.out.println("输入错误,请重新输入");
            }
        }
    }

    //注册
    private static void register() throws IOException {
        Scanner sc = new Scanner(System.in);
        System.out.println("请输入用户名");
        String username = sc.nextLine();
        System.out.println("请输入密码");
        String password = sc.nextLine();
        //对用户信息进行拼接
        StringBuilder sb=new StringBuilder();
        String str = sb.append("username=").append(username).append("&password=").append(password).toString();

        //向服务端写入了两次信息
        //1.告诉服务端,我要进行注册操作了
        sendMessage("register");
        //2.向服务器发送用户信息
        sendMessage(str);

        //接收服务端的反馈
        BufferedReader br = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        String message = br.readLine();
        //根据反馈做对应的事
        //状态码:4--->用户名重复;5--->用户名不合法;6--->密码不合法;7--->注册成功
        if("7".equals(message)){
            //注册成功
            System.out.println("注册成功,开始聊天");
//由于聊天是死循环,为保证接收消息和聊天不发生冲突,所以需要单独开一条线程用来接收服务端发送的信息
            //接收服务端的消息
            new Thread(new clientMyRunnable(br)).start();
            //聊天
            talk2All();
        }else if("4".equals(message)){
            //用户名重复
            System.out.println("用户名重复");
        } else if("5".equals(message)){
            //用户名不合法
            System.out.println("用户名不合法");
        }else{
            //密码不合法
            System.out.println("密码不合法");
        }
    }

    //登录
    private static void login(Socket socket) throws IOException {
        Scanner sc = new Scanner(System.in);
        System.out.println("请输入用户名");
        String username = sc.nextLine();
        System.out.println("请输入密码");
        String password = sc.nextLine();
        //对用户信息进行拼接
        StringBuilder sb=new StringBuilder();
        String str = sb.append("username=").append(username).append("&password=").append(password).toString();

        //向服务端写入了两次信息
        //细节:服务端和客户端的输入和输出流,都用BufferedWriter和BufferedReader,读取写入更方便,效率也给更高
        //两者的输入和输出流要是一组的(如BufferedWriter和BufferedReader,BufferedInputStream和BufferedOutputStream)
        //1.告诉服务端,我要进行登录操作了
        sendMessage("login");
        //2.向服务器发送用户信息
        sendMessage(str);

        //接收服务端的反馈
        BufferedReader br = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        String message = br.readLine();
        //根据反馈做对应的事
        //状态码:1--->登陆成功;2--->密码有误;3--->用户不存在
        if("1".equals(message)){
            //登陆成功
            System.out.println("登陆成功,开始聊天");
//由于聊天是死循环,为保证接收消息和聊天不发生冲突,所以需要单独开一条线程用来接收服务端发送的信息
            //接收服务端的消息
            new Thread(new clientMyRunnable(br)).start();
            //聊天
            talk2All();
        }else if("2".equals(message)){
            //密码有误
            System.out.println("密码有误");
        }else{
            System.out.println("用户不存在");
        }
    }

    private static void talk2All() throws IOException {
        Scanner sc=new Scanner(System.in);
        //不知道要说多少句话,所以用死循环
        while (true){
            System.out.println("请输入你想说的话");
            String words = sc.nextLine();
            sendMessage(words);
        }
    }

    //向服务端发送消息
    public static void sendMessage(String message) throws IOException {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
        bw.write(message);
        bw.newLine();
        bw.flush();
    }

    public static void menu() {
        System.out.println("------------------欢迎来到聊天室------------------");
        System.out.println("1.登录");
        System.out.println("2.注册");
        System.out.println("请输入你的选项");
    }
}
