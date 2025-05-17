package regexdemo;

public class RegexDemo3 {
    public static void main(String[] args) {
        String regex1="[1-9]\\d{16}[0-9]|(?i)x";
        String regex2="[1-9]\\d{5}(?:18|19|20)\\d{2}(?:0[1-9]|10|11|12)(?:0[1-9]|[1-2]\\d|30|31)\\d{3}[\\dXx]";
        //[1-9]\\d{5}
        //(18|19|20)\\d{2}
        //(0[1-9]|1[0-2])
        //(0[1-9]|[1-2]\\d|3[01])
        //\\d{3}[\\dxX]
//        41080119930228457x
//        510801197609022309
//        15040119810705387X
//        130133197204039024
//        430102197606046442
        String regex3="[1-9]\\d{5}(18|19|20)\\d{2}(0[1-9]|1[0-2])(0[1-9]|[1-2]\\d|3[01])\\d{3}[\\dxX]";
        System.out.println("41080119930228457x".matches(regex3));
        System.out.println("510801197609022309".matches(regex3));
        System.out.println("15040119810705387X".matches(regex3));
        System.out.println("130133197204039024".matches(regex3));
        System.out.println("430102197606046442".matches(regex3));
    }
}
