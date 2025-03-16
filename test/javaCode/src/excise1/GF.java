package excise1;

public class GF {
    //属性
    private String name;
    private double highth;
    private double height;
    public GF(){

    }
    public GF(String name,double highth,double height){
        this.name=name;
        this.highth=highth;
        this.height=height;
    }
    //行为
    public void wash(){
        System.out.println("洗衣服");
    }
    public void cook(){
        System.out.println("做饭");
    }
    public void show(){
        System.out.println("我的女朋友叫"+this.name+"身高为"+this.highth+"体重为"+this.height);
    }
}
