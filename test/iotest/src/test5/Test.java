package test5;

import cn.hutool.core.io.FileUtil;

import java.util.Collections;
import java.util.List;

public class Test {
    public static void main(String[] args) {
        /*需求：
            一个文件里面存储了班级同学的姓名，每一个姓名占一行。
            要求通过程序实现随机点名器。

          运行结果要求：
            被点到的学生不会再被点到。
            但是如果班级中所有的学生都点完了， 需要重新开启第二轮点名。
         */
        //点3轮名
        for (int i = 0; i < 3; i++) {
            //每点完一轮名,需要重新读取名单
            List<String> oldNameList = FileUtil.readLines("D:\\java_code" +
                    "\\test\\iotest\\src\\test5\\allnames.txt", "UTF-8");
            while(true){
                if(oldNameList.size()==0) break;
                //点一个,删一个
                Collections.shuffle(oldNameList);
                System.out.println(oldNameList.getFirst());
                oldNameList.removeFirst();
            }
        }
    }
}
