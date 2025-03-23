package oop_interface_demo2;

public class PingPangCoach extends Coach implements SpeakEnglish{
    public PingPangCoach() {
    }

    public PingPangCoach(String name, int age) {
        super(name, age);
    }

    @Override
    public void stuCoach() {
        System.out.println("学教乒乓球");
    }

    @Override
    public void speakEnglish() {
        System.out.println("讲英语");
    }
}
