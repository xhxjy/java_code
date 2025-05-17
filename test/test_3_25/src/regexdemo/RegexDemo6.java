package regexdemo;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

//选择性爬取
public class RegexDemo6 {
    public static void main(String[] args) {
        /*
            有如下文本，按要求爬取数据。
                Java自从95年问世以来，经历了很多版本，目前企业中用的最多的是Java8和Java11，
                因为这两个是长期支持版本，下一个长期支持版本是Java17，相信在未来不久Java17也会逐渐登上历史舞台


            需求1:爬取版本号为8，11.17的Java文本，但是只要Java，不显示版本号。
            需求2:爬取版本号为8，11，17的Java文本。正确爬取结果为:Java8 Java11 Java17 Java17
            需求3:爬取除了版本号为8，11.17的Java文本，
        */
        String s = "Java自从95年问世以来，经历了很多版本，目前企业中用的最多的是Java8和Java11，" +
                "因为这两个是长期支持版本，下一个长期支持版本是Java17，相信在未来不久Java17也会逐渐登上历史舞台";

        //需求1
        //'?'表示括号前面的整体,'='表示不显示它之后的数据
        String regex1="Java(?=8|11|17)";
        //需求2
        //':'表示显示它之后的数据
        String regex2="Java(?:8|11|17)";
        //需求3
        //'!'表示除了它之后的数据
        String regex3="Java(?!8|11|17)";

        Pattern p=Pattern.compile(regex3);
        Matcher m = p.matcher(s);
        while (m.find()){
            String str = m.group();
            System.out.println(str);
        }
    }
}
