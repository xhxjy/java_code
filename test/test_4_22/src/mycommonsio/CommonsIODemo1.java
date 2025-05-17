package mycommonsio;

import org.apache.commons.io.IOUtils;

import java.io.FileOutputStream;
import java.io.IOException;

public class CommonsIODemo1 {
    public static void main(String[] args) throws IOException {
        /*
          FileUtils类
                static void copyFile(File srcFile, File destFile)                   复制文件
                static void copyDirectory(File srcDir, File destDir)                复制文件夹
                static void copyDirectoryToDirectory(File srcDir, File destDir)     复制文件夹
                static void deleteDirectory(File directory)                         删除文件夹
                static void cleanDirectory(File directory)                          清空文件夹
                static String readFileToString(File file, Charset encoding)         读取文件中的数据变成成字符串
                static void write(File file, CharSequence data, String encoding)    写出数据

            IOUtils类
                public static int copy(InputStream input, OutputStream output)      复制文件
                public static int copyLarge(Reader input, Writer output)            复制大文件
                public static String readLines(Reader input)                        读取数据
                public static void write(String data, OutputStream output)          写出数据
         */
        /*File src = new File("test_4_22\\a.txt");
        File dest = new File("test_4_22\\copy.txt");
        FileUtils.copyFile(src,dest);*/

        /*File src = new File("D:\\aaa");
        File dest = new File("D:\\ccc");
        FileUtils.copyDirectory(src,dest);*/

        /*File src = new File("D:\\aaa\\jkn.txt");
        String content = FileUtils.readFileToString(src, StandardCharsets.UTF_8);
        System.out.println(content);*/

        /*IOUtils.copy(new FileInputStream("test_4_22\\\\a.txt"),
                new FileOutputStream("test_4_22\\\\copy.txt"));*/

        //返回字符串集合
        /*List<String> content = IOUtils.readLines(new FileReader("test_4_22\\\\a.txt"));
        for (String s : content) {
            System.out.println(s);
        }*/

        IOUtils.write("jjk,你好",new FileOutputStream("test_4_22\\\\copy.txt"));



































       /* File src = new File("myio\\a.txt");
        File dest = new File("myio\\copy.txt");
        FileUtils.copyFile(src,dest);*/


        /*File src = new File("D:\\aaa");
        File dest = new File("D:\\bbb");
        FileUtils.copyDirectoryToDirectory(src,dest);*/

        /*File src = new File("D:\\bbb");
        FileUtils.cleanDirectory(src);*/
    }
}
