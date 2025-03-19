package test_3_19;

import java.util.ArrayList;

public class TeacherTest {
    public static void main(String[] args) {
        ArrayList<Teacher> list=new ArrayList<>();

        Teacher teacher1=new Teacher("zhao","javase");
        Teacher teacher2=new Teacher("wang","php");
        Teacher teacher3=new Teacher("xjy","golang");

        list.add(teacher1);
        list.add(teacher2);
        list.add(teacher3);

        for (int i = 0; i < list.size(); i++) {
            Teacher teacher = list.get(i);
            System.out.println(teacher.getName()+","+teacher.getMajor());
        }
    }
}
