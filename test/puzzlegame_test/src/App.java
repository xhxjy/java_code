import ui.GameJFrame;

public class App {
    public static void main(String[] args) {

        //空参构造,对对象进行初始化
        //先登录或注册后,才会显示游戏界面,所以游戏界面放最后
//        new RegisterJFrame();
//        new LoginJFrame();
        new GameJFrame();
    }
}
