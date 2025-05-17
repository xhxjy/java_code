package a02jdk8datedemo;

import java.time.ZoneId;
import java.util.Set;

public class A01_ZoneIDDemo1 {
    public static void main(String[] args) {
        /*
        static Set<string> getAvailableZoneIds() 获取Java中支持的所有时区
        static ZoneId systemDefault() 获取系统默认时区
        static Zoneld of(string zoneld) 获取一个指定时区
        */

        //
        Set<String> zoneIds = ZoneId.getAvailableZoneIds();
//        System.out.println(zoneIds);

        ZoneId zoneId = ZoneId.systemDefault();
//        System.out.println(zoneId);//Asia/Shanghai

        ZoneId zoneId1 = ZoneId.of("America/Cuiaba");
        System.out.println(zoneId1);

    }
}
