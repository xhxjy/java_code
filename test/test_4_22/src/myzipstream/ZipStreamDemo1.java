package myzipstream;


import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;

/*
 *   解压缩流
 *
 * */
public class ZipStreamDemo1 {
    public static void main(String[] args) throws IOException {
        //1.创建两个个file对象分别表示要解压的压缩包(数据源)和需要解压的目的地
        File src = new File("D:\\aaa.zip");
        File dest = new File("D:\\");
        //解压
        unzip(src, dest);
    }

    //解压缩
    //本质:将压缩包里的文件或文件夹读取出来,按层级拷贝到目的地中(需要刷新路径)
    private static void unzip(File src, File dest) throws IOException {
        //1.创建对应的解压缩流来读取压缩包中的数据
        ZipInputStream zis = new ZipInputStream(new FileInputStream(src));
        //2.循环获取压缩包里的每一个条目(文件或文件夹),即zipEntry对象
        ZipEntry entry;
        while ((entry = zis.getNextEntry()) != null) {
            if (entry.isDirectory()) {
                //文件夹:
                //刷新路径,创建对应的空文件夹
                //细节:刷新路径
//entry.toString()指文件或文件夹在zip文件中的完整路径.如在aaa.zip中存在一个文件:a.txt,
// 会返回对应的完整路径:xxx\\jjj\\a.txt,所以刷新路径只需将它和dest进行拼接即可
                File file = new File(dest, entry.toString());
                //不可以写成这样,因为若一个大文件夹下有两个子文件夹,这样写会变为3级文件夹
                //dest = new File(dest, entry.toString());
                file.mkdirs();
            } else {
                //文件
                //将文件里的内容拷贝到目的地上
                //细节:刷新路径(同上理)
                FileOutputStream fos = new FileOutputStream(new File(dest, entry.toString()));

                byte[] bytes = new byte[1024 * 1024];
                int len;
                while ((len = zis.read(bytes)) != -1) {
                    fos.write(bytes, 0, len);
                }
                //关闭字节输出流(文件流)
                fos.close();
                //关闭当前条目流(表示压缩包中的一个文件处理完成)
                zis.closeEntry();
            }
        }
        //关闭总输入流
        zis.close();
    }
































    /*//1.创建一个File表示要解压的压缩包
        File src = new File("D:\\aaa.zip");
        //2.创建一个File表示解压的目的地
        File dest = new File("D:\\");

        //调用方法
        unzip(src,dest);*/
    /*//定义一个方法用来解压
    public static void unzip(File src,File dest) throws IOException {
        //解压的本质：把压缩包里面的每一个文件或者文件夹读取出来，按照层级拷贝到目的地当中
        //创建一个解压缩流用来读取压缩包中的数据
        ZipInputStream zip = new ZipInputStream(new FileInputStream(src));
        //要先获取到压缩包里面的每一个zipentry对象
        //表示当前在压缩包中获取到的文件或者文件夹
        ZipEntry entry;
        while((entry = zip.getNextEntry()) != null){
            System.out.println(entry);
            if(entry.isDirectory()){
                //文件夹：需要在目的地dest处创建一个同样的文件夹
                File file = new File(dest,entry.toString());
                file.mkdirs();
            }else{
                //文件：需要读取到压缩包中的文件，并把他存放到目的地dest文件夹中（按照层级目录进行存放）
                FileOutputStream fos = new FileOutputStream(new File(dest,entry.toString()));
                int b;
                while((b = zip.read()) != -1){
                    //写到目的地
                    fos.write(b);
                }
                fos.close();
                //表示在压缩包中的一个文件处理完毕了。
                zip.closeEntry();
            }
        }

        zip.close();*/

//    }
}
