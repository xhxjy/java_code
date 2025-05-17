package a01jdk7datedemo;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class A04_SimpleDateFormatDemo2 {
    public static void main(String[] args) throws ParseException {
        /*
            假设，你初恋的出生年月日为:2000-06-24
            请用字符串表示这个数据，并将其转换为:2000年06月24日

        */

        //根据时间字符串来解析为对应date对象
        //先将日期写为一个字符串
        String str="2000-06-24";
        //再创建SimpleDateFormat对象将字符串按格式解析为对应的date对象
        SimpleDateFormat sdf1=new SimpleDateFormat("yyyy-MM-dd");
        Date d = sdf1.parse(str);

        //创建SimpleDateFormat对象,将date对象转化为字符串
        SimpleDateFormat sdf2=new SimpleDateFormat("yyyy年MM月dd日");
        String s = sdf2.format(d);
        System.out.println(s);

        //日期字符串的格式转换


//        //1.可以通过2000-11-11进行解析，解析成一个Date对象
//        String str = "2000-11-11";
//        //2.解析
//        SimpleDateFormat sdf1 = new SimpleDateFormat("yyyy-MM-dd");
//        Date date = sdf1.parse(str);
//        //3.格式化
//        SimpleDateFormat sdf2 = new SimpleDateFormat("yyyy年MM月dd日");
//        String result = sdf2.format(date);
//        System.out.println(result);
    }
}
