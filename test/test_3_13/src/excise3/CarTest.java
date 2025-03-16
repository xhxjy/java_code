package excise3;

import java.util.Scanner;

public class CarTest {
    public static void main(String[] args) {
        //定义数组
        Car[] arr=new Car[3];
        //将它们放在循环中
//        //定义三个对象
//        Car a1=new Car();
//        Car a2=new Car();
//        Car a3=new Car();
//        //将对象传给数组
//        arr[0]=a1;
//        arr[1]=a2;
//        arr[2]=a3;
        //在数组中给对象赋值
        Scanner sc=new Scanner(System.in);
        for (int i = 0; i < arr.length; i++) {
            //定义对象(不可写在循环外部,否则相当于只创建了一个对象)
            Car c=new Car();
            //输入数据
            //1.输入brand
            System.out.printf("请输入品牌");
            String brand = sc.next();
            c.setBrand(brand);
            //2.输入price
            System.out.printf("请输入价格");
            int price=sc.nextInt();
            c.setPrice(price);
            //3....
            System.out.printf("请输入颜色");
            String color=sc.next();
            c.setColor(color);
//            将对象传给数组
            arr[i]=c;
        }
        //遍历查看结果
        for (int i = 0; i < arr.length; i++) {
            Car point=arr[i];//便于后面的书写
            System.out.println(point.getBrand()+","+point.getPrice()
                    +","+point.getColor()+",");
        }
    }
}
