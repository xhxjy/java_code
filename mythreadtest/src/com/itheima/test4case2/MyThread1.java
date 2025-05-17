package com.itheima.test4case2;

public class MyThread1 extends Thread {
    /*//记录3个小红包
    static int count = 3;

    //记录红包总额
    static BigDecimal sum=BigDecimal.valueOf(100);

    //定义红包的最低金额
    static final BigDecimal MIN = BigDecimal.valueOf(0.01);

    //定义红包的最高金额
//    static final double MAX = 40;

    //run方法里面的代码块就是线程要执行的任务(要做的事)
    @Override
    public void run() {

        //当未规定某线程会执行多少次时才放死循环
        // 这里因为一个线程(人)只能抢一次红包,所以无需写循环
//        while (true){
        synchronized (MyThread1.class) {
            if (count == 0) {
                System.out.println(getName() + "没抢到");
            } else {
                //还有红包抢
                if (count != 1) {
                    //前两次抢红包
                    BigDecimal money;
                    //使红包的随机值不小于最低金额
                    //细节:不可以一次性将红包抽完,要保证红包中余额有最小值,
                    // 即随机的金额范围要用红包总额减去剩余的红包数×最小金额
//                    money = sum - (count - 1) * MIN;
                    double bounds=sum.subtract(BigDecimal.valueOf(count-1).multiply(BigDecimal.valueOf(MIN))).doubleValue();
                    Random r = new Random();
                    money = BigDecimal.valueOf(r.nextDouble(bounds));
                    //随机的金额比最小值还少,就将最小值赋值给它
                    if (money < MIN)
                        money = MIN;

                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                    System.out.println(getName() + "抢到" + money);

                    //刷新红包的余额
                    sum -= money;
                    count--;
                } else {
                    //最后一次抢,直接将余额当作红包
                    System.out.println(getName() + "抢到" + sum);
                    sum = 0;
                    count--;
                }
            }
        }*/
//        }
    }
//}
