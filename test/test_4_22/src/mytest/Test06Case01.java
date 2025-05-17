package mytest;


import java.io.*;
import java.util.*;

public class Test06Case01 {
    public static void main(String[] args) throws IOException {
        /*
            需求：把《出师表》的文章顺序进行恢复到一个新文件中。
        */

        //1.读取数据
        //一次读一行
        BufferedReader br =new BufferedReader(new FileReader("D:\\aaa\\csb.txt"));
        //创建一个字符串集合(不知道元素个数,不然用数组)
        ArrayList<String> list=new ArrayList<>();
        //将每一行的数据存到集合中
        String s;
        while ((s=br.readLine())!=null){
            list.add(s);
        }
        br.close();

        //法1:用treemap集合排序
        /*//2.恢复顺序
        //将内容和序号用'.'分割开,并将它们放入map集合中,序号为键,内容为值
        //创建一个treemap集合(因为需要进行排序)
        TreeMap<Integer,String> tm=new TreeMap<>();
        for (String line : list) {
            String[] arr = line.split("\\.");
            tm.put(Integer.parseInt(arr[0]),arr[1]);
        }

        //3.拷贝数据
        //将TreeMap里排序好的内容写入文件中
        //创建
        BufferedWriter bw=new BufferedWriter(new FileWriter("test_4_22\\copy.txt"));
        for (Map.Entry<Integer, String> entry : tm.entrySet()) {
            Integer num = entry.getKey();
            String content = entry.getValue();
            bw.write(num +"."+ content);
            bw.newLine();
        }
        bw.close();*/

        //法2:直接用list集合来排序,调用collections的sort方法
        Collections.sort(list, (o1, o2) ->
                Integer.parseInt(o1.split("\\.")[0])
                        -Integer.parseInt(o2.split("\\.")[0]));

        BufferedWriter bw=new BufferedWriter(new FileWriter("test_4_22\\copy.txt"));
        for (String content : list) {
            bw.write(content);
            bw.newLine();
        }
        bw.close();


































       /* //1.读取数据
        BufferedReader br = new BufferedReader(new FileReader("myio\\csb.txt"));
        String line;
        ArrayList<String> list = new ArrayList<>();
        while((line = br.readLine()) != null){
           list.add(line);
        }
        br.close();

        //2.排序
        //排序规则：按照每一行前面的序号进行排列
        Collections.sort(list, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                //获取o1和o2的序号
                int i1 = Integer.parseInt(o1.split("\\.")[0]);
                int i2 = Integer.parseInt(o2.split("\\.")[0]);
                return i1 - i2;
            }
        });

      //3.写出
        BufferedWriter bw = new BufferedWriter(new FileWriter("myio\\result.txt"));
        for (String str : list) {
            bw.write(str);
            bw.newLine();
        }
        bw.close();*/





    }
}
