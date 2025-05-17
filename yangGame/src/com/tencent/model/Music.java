package com.tencent.model;

import javazoom.jl.decoder.JavaLayerException;
import javazoom.jl.player.Player;

import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;

public class Music {
    public void music() throws FileNotFoundException, JavaLayerException {
        //获取背景音乐的输入流
        BufferedInputStream bis = new BufferedInputStream(new FileInputStream
                ("D:\\java_code\\yangGame\\music\\music.mp3"));
        //创建背景音乐的播放器
        Player player = new Player(bis);
        //播放音乐
        player.play();
    }
}
