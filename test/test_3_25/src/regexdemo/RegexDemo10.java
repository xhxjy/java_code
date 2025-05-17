package regexdemo;

public class RegexDemo10 {
    public static void main(String[] args) {
        /*需求:
            将字符串:我要学学编编编编程程程程程程
            替换为:我要学编程
        */
        String s="我要学学编编编编程程程程程程";
        //$1:表示在外部使用正则表达式中第一组的数据
        String result = s.replaceAll("(\\W)\\1+", "$1");
        System.out.println(result);
//        String regex2 ="[1-9]\\d{16}(\\d|X|x)\\1";
//^([01]\d|2[0-3]):[0-5]\d:[@-5]\d$
//
//        System.out.println("41080119930228457x".matches(regex2));
    }
}
