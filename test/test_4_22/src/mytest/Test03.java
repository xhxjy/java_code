package mytest;


import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Arrays;
import java.util.StringJoiner;

public class Test03 {
    public static void main(String[] args) throws IOException {
        /*
            文本文件中有以下的数据：
                2-1-9-4-7-8
            将文件中的数据进行排序，变成以下的数据：
                1-2-4-7-8-9
        */

        //获取文件中的数据并将它们转化为一个字符串
        FileInputStream fis=new FileInputStream("test_4_22\\a.txt");
        //法1
//        byte[] bytes = new byte[1024];
//        int len;
//        String result="";
//        while ((len=fis.read(bytes))!=-1){
//            String s = new String(bytes, 0, len);
//            result=s;
//        }
        //法2
        StringBuilder sb=new StringBuilder();
        int b;
        while ((b=fis.read())!=-1){
            sb.append((char) b);
        }
        String result = sb.toString();

        fis.close();
        //之后用字符串分割的方法获得各个数字
        String[] numbers = result.split("-");
        //对这些数字升序排列,排完序后字符串的sj对象将数字字符串加上间隔转为原来的格式
        Arrays.sort(numbers);
        StringJoiner sj=new StringJoiner("-");
        for (String number : numbers) {
            sj.add(number);
        }
        String data = sj.toString();
        //将更改后的数据写入文件
        FileOutputStream fos=new FileOutputStream("test_4_22\\a.txt");
        byte[] dataBytes = data.getBytes();
        fos.write(dataBytes);
        fos.close();




































        /*//1.读取数据
        FileReader fr = new FileReader("myio\\a.txt");
        StringBuilder sb = new StringBuilder();
        int ch;
        while((ch = fr.read()) != -1){
            sb.append((char)ch);
        }
        fr.close();
        System.out.println(sb);
        //2.排序
        String str = sb.toString();
        String[] arrStr = str.split("-");//2-1-9-4-7-8

        ArrayList<Integer> list = new ArrayList<>();
        for (String s : arrStr) {
            int i = Integer.parseInt(s);
            list.add(i);
        }
        Collections.sort(list);
        System.out.println(list);
        //3.写出
        FileWriter fw = new FileWriter("myio\\a.txt");
        for (int i = 0; i < list.size(); i++) {
            if(i == list.size() - 1){
                fw.write(list.get(i) + "");
            }else{
                fw.write(list.get(i) + "-");
            }
        }
        fw.close();*/





    }
}