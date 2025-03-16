package excise3;

public class GFTest {
    public static void main(String[] args) {
        //创建对象数组
        GF[] arr = new GF[4];
        //创建对象
        GF p1 = new GF("xjy", 24, '女', "photo");
        GF p2 = new GF("hjy", 18, '女', "game");
        GF p3 = new GF("kkk", 16, '女', "sleep");
        GF p4 = new GF("zzz", 22, '女', "draw");
        //对象传入数组
        arr[0] = p1;
        arr[1] = p2;
        arr[2] = p3;
        arr[3] = p4;
        //在数组中计算总和
        int sum = 0;
        for (int i = 0; i < arr.length; i++) {
            GF gf = arr[i];
            sum += gf.getAge();
        }
        //算平均数
        int avgAge = sum / (arr.length);
        System.out.println(avgAge);
        //判断
        int count = 0;
        for (int i = 0; i < arr.length; i++) {
            GF gf = arr[i];
            if (gf.getAge() < avgAge) {
                gf.showInfo();
                count++;
            }
        }
        System.out.println("有"+count+"个");
    }
}
