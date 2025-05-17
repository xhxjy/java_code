package source;

// 定义抽象类MotoVehicle
abstract class MotoVehicle {
    protected String no;
    protected String brand;

    public MotoVehicle(String no, String brand) {
        this.no = no;
        this.brand = brand;
    }

    // 抽象方法，用于计算租金
    public abstract int calRent(int days);
}

// 定义Car类，继承自MotoVehicle
class Car extends MotoVehicle {
    private String type;

    public Car(String no, String brand, String type) {
        super(no, brand);
        this.type = type;
    }

    @Override
    public int calRent(int days) {
        // 小轿车租金300元/天
        return 300 * days;
    }
}

// 定义Bus类，继承自MotoVehicle
class Bus extends MotoVehicle {
    private int seatCount;

    public Bus(String no, String brand, int seatCount) {
        super(no, brand);
        this.seatCount = seatCount;
    }

    @Override
    public int calRent(int days) {
        if (seatCount <= 16) {
            // 16座及以下大巴车租金800元/天
            return 800 * days;
        } else {
            // 16座以上大巴车租金1600元/天
            return 1600 * days;
        }
    }
}

public class Test2 {
    public static void main(String[] args) {
        // 创建一辆小轿车对象
        MotoVehicle car = new Car("京A12345", "宝马", "轿车");
        int carRent = car.calRent(5);
        System.out.println("小轿车5天的租金为: " + carRent + "元");

        // 创建一辆16座大巴车对象
        MotoVehicle bus1 = new Bus("京B54321", "宇通", 16);
        int bus1Rent = bus1.calRent(5);
        System.out.println("16座大巴车5天的租金为: " + bus1Rent + "元");

        // 创建一辆20座大巴车对象
        MotoVehicle bus2 = new Bus("京C98765", "金龙", 20);
        int bus2Rent = bus2.calRent(5);
        System.out.println("20座大巴车5天的租金为: " + bus2Rent + "元");
    }
}
