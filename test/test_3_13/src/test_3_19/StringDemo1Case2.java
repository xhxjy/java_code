package test_3_19;

//在一个母字符串中找一个子字符串出现的次数
public class StringDemo1Case2 {
    public static void main(String[] args) {
        String str = "java语言是,java语言78,java是192";
        String tar = "java";
        System.out.println(getCount(str, tar));
    }

//将子字符串全部换为长度为0的空字符串,然后用老的字符串减去新的,
// 得到长度差再除以子字符串的长度,最终得到出现次数
    public static int getCount(String str, String tar) {
        String newStr = str.replace(tar, "");
        int count = (str.length() - newStr.length()) / tar.length();
        return count;
    }
}
