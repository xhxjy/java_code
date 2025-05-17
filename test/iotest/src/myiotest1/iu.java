package myiotest1;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class iu {
    public static void main(String[] args) {
        String s = "Java自从95年问世以来，经历了很多版本，目前企业中用的最多的是Java8和Java11，" +
                "因为这两个是长期支持版本，下一个长期支持版本是Java17，相信在未来不久Java17也会逐渐登上历史舞台";

//需求1
//'?'表示括号前面的整体,'='表示不显示它之后的数据
        String regex1="Java(?=8|11|17)";//java,java,java,java
//需求2
//':'表示显示它之后的数据
        String regex2="Java(?:8|11|17)";
//需求3
//'!'表示不包含它之后的数据
        String regex3="Java(?!8|11|17)";//java
        Pattern p = Pattern.compile(regex2);
        Matcher m = p.matcher(s);
        while(m.find()){
            String str = m.group();
            System.out.println(str);
        }
    }
}
