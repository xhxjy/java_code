package oop_interface_demo2;

public class Test {
    public static void main(String[] args) {
        PingPangCoach pangCoach=new PingPangCoach();
        pangCoach.speakEnglish();
        pangCoach.stuCoach();
        PingPangPlayer pangPlayer=new PingPangPlayer();
        pangPlayer.stuPlay();
        pangPlayer.speakEnglish();
    }
}
