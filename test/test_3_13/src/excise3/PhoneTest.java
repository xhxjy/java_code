package excise3;

public class PhoneTest {
    public static void main(String[] args) {
        //创建对象数组
        Phone[] arr = new Phone[3];
        //创建对象
        Phone p1 = new Phone("iqoo", 2000, "蓝色");
        Phone p2 = new Phone("iphone", 6000, "白色");
        Phone p3 = new Phone("RedMagic", 2500, "黑色");
        //对象传入数组
        arr[0] = p1;
        arr[1] = p2;
        arr[2] = p3;
        //在数组中计算总和
        int sum = 0;
        for (int i = 0; i < arr.length; i++) {
            Phone phone = arr[i];
            sum += phone.getPrice();
        }
        //算平均数
        System.out.println(sum / (arr.length));
    }
}
