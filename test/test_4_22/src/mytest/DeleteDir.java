package mytest;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

public class DeleteDir {
    public static void main(String[] args) throws IOException {
        File file = new File("D:\\kkk");
        //
        delete(file);
    }

    private static void delete(File file) throws IOException {
        File[] files = file.listFiles();
        if (files != null) {
            for (File f : files) {
                if(f.isDirectory()){
                    FileOutputStream fos = new FileOutputStream(new File(file, f.getName() + "\\" + "a.txt"));
                    fos.write(97);
                    fos.close();
                    delete(f);
                }
            }
        }
    }
}
