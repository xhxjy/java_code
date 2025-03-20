package test_3_19;

//在一个母字符串中找一个子字符串出现的次数
public class StringDemo1Case1 {
    public static void main(String[] args) {
        String str = "java语言是,java语言78,java是192";
        String tar = "java";
        System.out.println(getCount(str, tar));
    }

    public static int getCount(String str, String tar) {
        //记录出现次数
        int count = 0;
//记录子字符串的首个字符的索引,将它赋值为何值都可以,但是因为它要接收的是indexOf()方法返回的值
        //将它赋值为-1会有相关性
        int index =-1;
        //
        while ((index = str.indexOf(tar)) != -1) {//获取子字符串在母字符串中第一次重新的索引
            count++;
            //将第一个子字符串的最后的索引拿出,并开始切割
            str = str.substring(index + tar.length());
        }
        return count;
    }
}
//
