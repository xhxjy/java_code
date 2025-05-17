package test;

public class Test {
    public static void main(String[] args) {
        /*需求:外面的人想要大明星唱一首歌
        1.先找代理(获取代理的对象)
        2.代理找明星唱歌(代理调用唱歌方法,在底层叫明星唱歌)*/

        //找代理,获取代理的对象
        BigStar bigStar=new BigStar("鸡哥");
        Star star = ProxyUtil.creatProxy(bigStar);
        //代理调用方法
        star.dance();
        String s = star.sing("只因你太美");
        System.out.println(s);
    }
}
