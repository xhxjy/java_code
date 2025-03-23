package oop_interface_demo2;

public class PingPangPlayer extends Player implements SpeakEnglish{
    public PingPangPlayer() {
    }

    public PingPangPlayer(String name, int age) {
        super(name, age);
    }

    @Override
    public void stuPlay() {
        System.out.println("学习乒乓球");
    }

    @Override
    public void speakEnglish() {
        System.out.println("讲英语");
    }
}
