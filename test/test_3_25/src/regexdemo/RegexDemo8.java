package regexdemo;

public class RegexDemo8 {
    public static void main(String[] args) {
        //public string replaceAll(string regex,string newstr) 按照正则表达式的规则进行替换
        //public string[] split(string regex): 按照正则表达式的规则切割字符串

        /*
            有一段字符串:小诗诗dqwefqwfqwfwq12312小丹丹dqwefqwfqwfwq12312小惠惠
            要求1:把字符串中三个姓名之间的字母替换为vs
            要求2:把字符串中的三个姓名切割出来*/
        String s="小诗诗dqwefqwfqwfwq12312小丹丹dqwefqwfqwfwq12312小惠惠";
        String regex1="[\\w&&[^_]]+";
        String s1 = s.replaceAll(regex1, "xhn");
        System.out.println(s1);
        String regex2="[\\w&&[^_]]+";
        String[] s2 = s.split(regex2);
        for (int i = 0; i < s2.length; i++) {
            System.out.println(s2[i]);
        }
    }
}
