package test;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Test2 {
    public static void main(String[] args) throws ParseException {
        //得到当前和出生日期的时间对象,获取它们的毫秒值,进行相减,得到的差值再除以一天的毫秒值就得到了天数
        Date now=new Date();
        //得到出生日期的时间对象
        //用字符串写出出生日期的格式,创建带对应格式的SimpleDateFormat对象sdf,再通过sdf对象将字符串解析为date对象
        String birthday="2000-06-24";
        SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
        Date date = sdf.parse(birthday);

        long time1 = now.getTime();
        long time2 = date.getTime();

        System.out.println((time1-time2)/(1000L*60*60*24));
    }
}
