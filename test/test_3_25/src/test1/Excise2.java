package test1;


// 定义交通信号灯颜色的枚举类型
enum TrafficLightColor {
    RED, YELLOW, GREEN
}

class Car {
    // 根据信号灯颜色执行相应操作的方法
    public void operate(TrafficLightColor color) {
        switch (color) {
            case RED:
                System.out.println("汽车停车");
                break;
            case YELLOW:
                System.out.println("汽车慢行");
                break;
            case GREEN:
                System.out.println("汽车行驶");
                break;
            default:
                break;
        }
    }
}

public class Excise2 {
    public static void main(String[] args) {
        Car car = new Car();
        // 模拟不同信号灯颜色下汽车的操作
        car.operate(TrafficLightColor.RED);
        car.operate(TrafficLightColor.YELLOW);
        car.operate(TrafficLightColor.GREEN);
    }
}
