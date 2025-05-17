package junitdemo1;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.io.*;

public class test2 {

    @Before
    public void beforeMethod() throws IOException {
        //将文件进行备份
        FileInputStream src=new FileInputStream("D:\\java_code\\Junit\\a.txt");
        FileOutputStream dest=new FileOutputStream("D:\\java_code\\Junit\\copy.txt");

        byte[] bytes = new byte[1024];
        int len;
        while ((len=src.read(bytes))!=-1){
            dest.write(bytes,0,len);
        }
        dest.close();
        src.close();
    }

    @Test
    public void method(){
        //测试delete方法
        File file = new File("D:\\java_code\\Junit\\a.txt");
        boolean b = file.delete();

//        Assert.assertEquals("delete方法错误",b,true);
        Assert.assertTrue("delete方法错误", b);
    }

    @After
    public void afterMethod() throws IOException {
        //将文件还原
        FileInputStream src=new FileInputStream("D:\\java_code\\Junit\\copy.txt");
        FileOutputStream dest=new FileOutputStream("D:\\java_code\\Junit\\a.txt");

        byte[] bytes = new byte[1024];
        int len;
        while ((len=src.read(bytes))!=-1){
            dest.write(bytes,0,len);
        }
        dest.close();
        src.close();
        //将备份文件删除
        File copy = new File("D:\\java_code\\Junit\\copy.txt");
        copy.delete();
    }
}
