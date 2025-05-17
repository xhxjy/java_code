package test6;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;

public class Test {
    public static void main(String[] args) throws IOException {
        //1.创建一个学生集合
        ArrayList<Student> list = new ArrayList<>();
        //法1:用缓冲流读取每一行数据,后面再将数据封装为一个学生对象,最后添加进集合中
        BufferedReader br = new BufferedReader(new FileReader("iotest\\src\\test6\\names.txt"));
        String line;
        while ((line = br.readLine()) != null) {
            String[] info = line.split("-");
            list.add(new Student(info[0], info[1], Integer.parseInt(info[2]), Double.parseDouble(info[3])));
        }
        br.close();
        //法2:用糊涂包的方法读取每一行的数据并放到集合中,之后与法1同理
//        List<String> studentList = FileUtil.readLines("D:\\java_code\\test\\iotest\\src\\test6\\names.txt", "UTF-8");
        //2.计算每一个学生的权重占比
        //先算总权重
        double weight = 0;
        for (Student stu : list) {
            weight += stu.getWeight();
        }
        //再算权重占比,并将它们存入数组中
        double[] arr = new double[list.size()];
        int index = 0;
        for (Student stu : list) {
            arr[index] = stu.getWeight() / weight;
            index++;
        }
        //3.计算每个人的权重占比范围
        //原理:通过概率累加实现权重划分
//如:初始权重:[50%,30%,20%]--->进行概率累加:[0.5,0.8,1.0]--->
// 0~0.5(50%的概率):学生0;0.5~0.8(30%的概率):学生1;0.8~1(20%的概率):学生2
        /*
        * 初始权重 → [学生0:50%, 学生1:30%, 学生2:20%]
        累加转换 → [学生0:0.5, 学生1:0.8, 学生2:1.0]
        范围划分 →
        学生0: |-----50%-----|
        学生1:           |---30%---|
        学生2:                   |-20%-|
*/
        //如:index=1时:0.1~0.2
        for (int i = 1; i < arr.length; i++) {
            arr[i] = arr[i] + arr[i - 1];
        }
        //4.随机权重占比,找出权重占比对应的人
        //因为是按升序排列,所以可以用二分查找快速找到大于等于随机数的位置索引
        double randomWeight = Math.random();
        //因为权重占比的数组的元素和集合的元素是一一对应的,顺序一致.所以根据该索引可以找出权重占比对应的人
        int i = -Arrays.binarySearch(arr, randomWeight) - 1;
        Student randomStu = list.get(i);
        System.out.println(randomStu.getName());
        //5.修改随机到的人的权重
        randomStu.setWeight(randomStu.getWeight()/2);
        //6.将修改的权重(修改后的集合)重新写入到文件中
        BufferedWriter bw=new BufferedWriter(new FileWriter("iotest\\src\\test6\\names.txt"));
        for (Student stu : list) {
            //重写学生类里的tostring方法
            bw.write(stu.toString());
            bw.newLine();
        }
        bw.close();
    }
}
