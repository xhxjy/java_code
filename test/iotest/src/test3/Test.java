package test3;

import cn.hutool.core.io.FileUtil;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Test {
    public static void main(String[] args) {
        /*需求：
            一个文件里面存储了班级同学的信息，格式为：张三-男-23
            每一个学生信息占一行。
            要求通过程序实现随机点名器。
            70%的概率随机到男生
            30%的概率随机到女生
            随机100万次，统计结果。看生成男生和女生的比例是不是接近于7：3
        */

        //读取信息
        //用糊涂包的方法时,文件路径并不是相对于当前项目,而是相对于class文件,所以建议写绝对路径
        List<String> namesList = FileUtil.readLines("D:\\java_code\\test\\iotest\\src\\test3\\allnames.txt", "UTF-8");
        //创建集合,使其中的数据三七分,然后将集合打乱.通过对集合首元素的判断,从而获得对应的概率
        //创建权重集合,使比例为7:3
        ArrayList<Integer> numList = new ArrayList<>();
        Collections.addAll(numList, 1, 1, 1, 1, 1, 1, 1, 0, 0, 0);
        int boyCount=0;
        int girlCount=0;
        for (int i = 0; i < 1000000; i++) {
            //随机点人
            Collections.shuffle(numList);
            Integer firstNum = numList.getFirst();
            //法1:
            if (firstNum == 1) {
                //男生
                while (true) {
                    Collections.shuffle(namesList);
                    String[] info = namesList.getFirst().split("-");
                    String gender = info[1];
                    if ("男".equals(gender)) {
//                        System.out.println(info[0]);
                        boyCount++;
                        break;
                    }
                }
            } else {
                //女生
                while (true) {
                    Collections.shuffle(namesList);
                    String[] info = namesList.getFirst().split("-");
                    String gender = info[1];
                    if ("女".equals(gender)) {
//                        System.out.println(info[0]);
                        girlCount++;
                        break;
                    }
                }
            }

            //法2:可以事先将男生和女生的信息分别放到两个集合中,然后再进行随机点人
        }
        System.out.println(boyCount);
        System.out.println(girlCount);

    }
}
