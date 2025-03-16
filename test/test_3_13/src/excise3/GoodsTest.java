package excise3;

//对象数组
public class GoodsTest {
    public static void main(String[] args) {
        Goods[] arr=new Goods[3];

        Goods a=new Goods(101,"xjy",150.0,80);
        Goods b=new Goods(202,"zqg",170.0,20);
        Goods c=new Goods(303,"hjg",190.0,100);

        //将商品添加到数组中
        arr[0]=a;
        arr[1]=b;
        arr[2]=c;

        for (int i = 0; i < arr.length; i++) {
            System.out.println("商品ID:"+arr[i].getId()+"名字:"+arr[i].getName()
                    + "价格:"+arr[i].getPrice()+"库存:"+arr[i].getRemainNum());
        }
    }
}
