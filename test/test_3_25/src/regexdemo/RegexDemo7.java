package regexdemo;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegexDemo7 {
    public static void main(String[] args) {
        //贪婪(默认):ab+
        //非贪婪:ab+?
        String s = "Java自从95年问世以来，abbbbbbbbbbbbaaaaaaaaaaaaaaaaaa" +
                "经历了很多版木，目前企业中用的最多的是]ava8和]ava11，因为这两个是长期支持版木。" +
                "下一个长期支持版本是Java17，相信在未来不久Java17也会逐渐登上历史舞台";
        String regex1="ab+?";
        Pattern p = Pattern.compile(regex1);
        Matcher m = p.matcher(s);
        while(m.find()){
            String str = m.group();
            System.out.println(str);
        }
    }
}
