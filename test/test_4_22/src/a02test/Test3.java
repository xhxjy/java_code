package a02test;

import java.io.File;

public class Test3 {
    public static void main(String[] args) {
       /* 需求2：
        找到电脑中所有以avi结尾的电影。（需要考虑子文件夹）
        套路：
            1，进入文件夹
            2，遍历数组
            3，判断
            4，判断
        */

        findTXt();
    }
    public static void findTXt(){
        //返回电脑里的各个盘符
        File[] files = File.listRoots();
        //用findTXt方法遍历各个盘符
        for (File file : files) {
            findTXt(file);
        }
    }

    public static void findTXt(File f){
        File[] files = f.listFiles();
        //listFiles():遇到没有权限进入的文件夹时,会返回null
        //所以需要对数组进行非空判断
        if(files!=null){
            for (File file :files) {
                //判断是否为文件夹或文件
                //用递归算法
                //结束条件:文件对象为文件时
                if(file.isFile()){
                    //文件对象为文件,将它打印出来
                    if(file.getName().endsWith(".txt")){
                        System.out.println(file);
                    }
                }else if(file.isDirectory()){
                    //文件对象为文件夹
                    //查看文件夹里的内容看它里面是否有txt文件(重复findTxt方法)
                    findTXt(file);
                }
            }
        }
    }
























    /*public static void findAVI(){
        //获取本地所有的盘符
        File[] arr = File.listRoots();
        for (File f : arr) {
            findAVI(f);
        }
    }

    public static void findAVI(File src){//"C:\\
        //1.进入文件夹src
        File[] files = src.listFiles();
        //2.遍历数组,依次得到src里面每一个文件或者文件夹
        if(files != null){
            for (File file : files) {
                if(file.isFile()){
                    //3，判断，如果是文件，就可以执行题目的业务逻辑
                    String name = file.getName();
                    if(name.endsWith(".avi")){
                        System.out.println(file);
                    }
                }else{
                    //4，判断，如果是文件夹，就可以递归
                    //细节：再次调用本方法的时候，参数一定要是src的次一级路径
                    findAVI(file);
                }

            }
        }
    }*/
}
