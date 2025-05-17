package test;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;

public class Test1 {
    public static void main(String[] args) {
        //jdk8
        LocalDateTime now=LocalDateTime.now();
        LocalDateTime birthday = LocalDateTime.of(2006, 7, 27, 14, 20);
        System.out.println(ChronoUnit.DAYS.between(birthday,now));//后减前
    }
}
