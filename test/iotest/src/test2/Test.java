package test2;

import cn.hutool.core.io.FileUtil;

import java.io.File;
import java.nio.charset.StandardCharsets;
import java.util.Collections;
import java.util.List;

public class Test {
    public static void main(String[] args) {
        /*需求：
            需求：
                有一个文件里面存储了班级同学的信息，每一个信息占一行。
                格式为：张三-男-23
                要求通过程序实现随机点名器。

            运行效果：
                第一次运行程序：随机同学姓名1（只显示名字）
                第二次运行程序：随机同学姓名2（只显示名字）
                第三次运行程序：随机同学姓名3（只显示名字）
                …
         */
        //一次读一行,并将它们放在集合中
        //new File("iotest\\src\\test2\\allnames.txt"), StandardCharsets.UTF_8
        List<String> allNames = FileUtil.readLines(new File("iotest\\src\\test2\\allnames.txt"), StandardCharsets.UTF_8);
        Collections.shuffle(allNames);
        System.out.println(allNames.getFirst().split("-")[0]);
    }
}
