package regexdemo;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegexDemo4 {
    public static void main(String[] args) {
        /* 有如下文本，请按照要求爬取数据。
                Java自从95年问世以来，经历了很多版本，目前企业中用的最多的是Java8和Java11，
                因为这两个是长期支持版本，下一个长期支持版本是Java17，相信在未来不久Java17也会逐渐登上历史舞台
                要求:找出里面所有的JavaXX
         */

        //获取正则表达式的对象Pattern
        Pattern p= Pattern.compile("Java\\d{0,2}");
        //创建文本读取器的对象matcher
        String str="Java自从95年问世以来，经历了很多版本，目前企业中用的最多的是Java8和Java11," +
                "因为这两个是长期支持版本，下一个长期支持版本是Java17，相信在未来不久Java17也会逐渐登上历史舞台";
        //str是大串,p是规则,
        Matcher m = p.matcher(str);
        //find方法除了会返回是否存在的boolean类型的判断,
        //它在底层会返回符合规则的字符串的的起始和结束索引,对小串进行截取
        while(m.find()){
            //group方法会将截取的小串进行返回
            String s = m.group();
            System.out.println(s);
        }
    }
}
