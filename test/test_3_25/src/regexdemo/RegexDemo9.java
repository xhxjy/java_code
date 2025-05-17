package regexdemo;

public class RegexDemo9 {
    public static void main(String[] args) {
        //需求1:判断一个字符串的开始字符和结束字符是否一致?只考虑一个字符
        //举例: a123a b456b 17891 &abc& a123b(false)
        // \\组号:表示把第X组的内容再出来用一次
        String regex1 = "(.).+\\1";
        System.out.println("a123a".matches(regex1));
        //需求2:判断一个字符串的开始部分和结束部分是否一致?可以有多个字符
        //举例: abc123abc b456b 123789123 &!@abc&!@ abc123abd(false)
        //      \\数字(组号):表示重新调用第几组的内容
        String regex2="(.+).+\\1";
        System.out.println("abc123abc".matches(regex2));
        //需求3:判断一个字符串的开始部分和结束部分是否一致?开始部分内部每个字符也需要一致
        //举例: aaa123aaa bbb456bbb 111789111 &&abc&&
        //  (.):将首字母看作一组
        //  \\2:将首字母拿出来再次使用
        //  \\1:将第一组重复的字母拿来使用
        String regex3="((.)\\2*).+\\1";//前面为第2组的原因是外层也加了一个括号
        System.out.println("aaa123aaa".matches(regex3));
        System.out.println("bbb456bbb".matches(regex3));
        System.out.println("111789111".matches(regex3));
        System.out.println("&&abc&&".matches(regex3));
    }
}
