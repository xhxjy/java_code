package mybufferedstream1;

import java.io.*;

public class BufferedStreamDemo3 {
    public static void main(String[] args) throws IOException {
        /*
         *   字符缓冲输入流：
         *      构造方法：
         *           public BufferedReader(Reader r)
         *      特有方法：
         *           public String readLine()   读一整行
         *
         * */

        BufferedReader br=new BufferedReader(new FileReader("test_4_22\\a.txt"));

        String s;
        //readLine方法不会将回车换行读取到内存中,所以需要换行打印
        while ((s=br.readLine())!=null){
            System.out.println(s);
        }

        br.close();

        BufferedWriter bw=new BufferedWriter(new FileWriter("test_4_22\\b.txt"));

        bw.write("你好呀,");
        bw.newLine();

        bw.write("请多多指教");
        bw.newLine();

        bw.close();





























        /*//1.创建字符缓冲输入流的对象
        BufferedReader br = new BufferedReader(new FileReader("myio\\a.txt"));
        //2.读取数据
        //细节：
        //readLine方法在读取的时候，一次读一整行，遇到回车换行结束
        //        但是他不会把回车换行读到内存当中
     *//*   String line1 = br.readLine();
        System.out.println(line1);

        String line2 = br.readLine();
        System.out.println(line2);*//*

        String line;
        while ((( line = br.readLine()) != null)){
            System.out.println(line);
        }


        //3.释放资源
        br.close();
*/

    }
}
