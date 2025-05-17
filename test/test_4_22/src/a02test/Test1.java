package a02test;

import java.io.File;
import java.io.IOException;

public class Test1 {
    public static void main(String[] args) throws IOException {
        //需求：在当前模块下的aaa文件夹中创建一个a.txt文件

        //不一定有aaa文件夹,需要先创建父级路径,后面再与子级路径拼接
        File f = new File("test_4_22\\aaa");
        //若文件夹存在,会创建失败,继续往下走,不会报错;
        // 若不存在则直接创建成功,也是继续往下走.
        // 所以仅仅是这个方法的返回值不同而已,无需判断
        f.mkdirs();

        File f2 = new File(f, "jjj");
        boolean b = f2.createNewFile();
        System.out.println(b);

        /*//1.创建出当前模块下的aaa文件夹的文件对象
        File f = new File("test_4_22\\aaa\\xjy");
        //
        try {
            System.out.println(f.createNewFile());
        } catch (IOException e) {
            System.out.println("找不到对应的父类路径");
        }*/





























        /*//1.创建a.txt的父级路径
        File file = new File("myfile\\aaa");
        //2.创建父级路径
        //如果aaa是存在的，那么此时创建失败的。
        //如果aaa是不存在的，那么此时创建成功的。
        file.mkdirs();
        //3.拼接父级路径和子级路径
        File src = new File(file,"a.txt");
        boolean b = src.createNewFile();
        if(b){
            System.out.println("创建成功");
        }else{
            System.out.println("创建失败");
        }*/

    }
}
