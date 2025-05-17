package source;

// 定义手机功能接口
interface MobileFunction {
    void sendMessage();
    void call();
    void playMedia();
}

// 普通手机类，继承手机功能接口
class NormalMobile implements MobileFunction {
    private String brand;
    private String model;

    public NormalMobile(String brand, String model) {
        this.brand = brand;
        this.model = model;
    }

    @Override
    public void sendMessage() {
        System.out.println("发送文字信息……");
    }

    @Override
    public void call() {
        System.out.println("语音通话……");
    }

    @Override
    public void playMedia() {
        System.out.println("播放歌曲《东方红》");
    }

    public void displayInfo() {
        System.out.println("这是一款型号为" + model + "的" + brand + "的手机！");
    }
}

// 智能手机类，继承手机功能接口并扩展功能
class SmartMobile implements MobileFunction {
    private String brand;
    private String model;

    public SmartMobile(String brand, String model) {
        this.brand = brand;
        this.model = model;
    }

    @Override
    public void sendMessage() {
        System.out.println("发送图文彩信……");
    }

    @Override
    public void call() {
        System.out.println("视频通话……");
    }

    @Override
    public void playMedia() {
        System.out.println("正在播放电视剧:《漂洋过海来看你》……");
    }

    public void connectNetwork() {
        System.out.println("成功接入网络……");
    }

    public void takePhoto() {
        System.out.println("咔嚓……拍照成功！");
    }

    public void displayInfo() {
        System.out.println("这是一款型号为" + model + "的" + brand + "的手机！");
    }
}

public class Test1 {
    public static void main(String[] args) {
        System.out.println("----------------普通手机----------------");
        NormalMobile normalMobile = new NormalMobile("飞利浦", "E316");
        normalMobile.displayInfo();
        normalMobile.sendMessage();
        normalMobile.call();
        normalMobile.playMedia();

        System.out.println("\n----------------智能手机----------------");
        SmartMobile smartMobile = new SmartMobile("Apple", "8 Plus");
        smartMobile.displayInfo();
        smartMobile.sendMessage();
        smartMobile.call();
        smartMobile.connectNetwork();
        smartMobile.takePhoto();
        smartMobile.playMedia();
    }
}
