package client;

import java.io.BufferedReader;
import java.io.IOException;

//线程的任务:接收服务端的消息
public class clientMyRunnable implements Runnable{
    BufferedReader br;
    public clientMyRunnable(BufferedReader br) {
        this.br=br;
    }

    @Override
    public void run() {
        while (true) {
            try {
                String line = br.readLine();
                System.out.println(line);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
