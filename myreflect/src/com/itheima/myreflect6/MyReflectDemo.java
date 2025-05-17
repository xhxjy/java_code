package com.itheima.myreflect6;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Properties;

public class MyReflectDemo {
    public static void main(String[] args) throws IOException, ClassNotFoundException, NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException {
    /*
        反射可以跟配置文件结合的方式，动态的创建对象，并调用方法
    */
        //1.读取配置文件的信息
        //创建配置文件的集合
        Properties prop=new Properties();
        BufferedReader br=new BufferedReader(new FileReader("D:\\java_code\\myreflect\\prop.properties"));
        //配置文件的集合加载读到的信息
        prop.load(br);
        br.close();

        //2.从配置文件中获取类名和要调用方法名
        String classname = (String) prop.get("classname");
        String methodName = prop.getProperty("method");//

        //3.利用反射调用方法
        //通过类名来获取该类的字节码文件
        Class clazz = Class.forName(classname);
        //获取构造方法并创建对象

        //细节:获取的是无参的构造方法,所以下面创建对象时,就不可以写参数
        //因为目的只是调用方法,所以对象是否有属性无所谓,所以优先选择空参构造
//        Constructor con = clazz.getDeclaredConstructor(String.class,int.class);
//        Object o = con.newInstance("zjskd",89);
        Constructor con = clazz.getDeclaredConstructor();
        Object o = con.newInstance();
//        System.out.println(o);
        //获取并调用方法

        //通过该类的字节码文件和方法名获取对应的方法
        Method method = clazz.getDeclaredMethod(methodName);
        //不确定该方法是否为私有,所以要多一步解除权限
        method.setAccessible(true);
        //通过方法和对象来调用方法
        method.invoke(o);

































        /*//1.读取配置文件中的信息
        Properties prop = new Properties();
        FileInputStream fis = new FileInputStream("D:\\java_code\\myreflect\\prop.properties");
        prop.load(fis);
        fis.close();
        System.out.println(prop);


        //2.获取全类名和方法名
        String className = (String) prop.get("classname");
        String methodName = (String) prop.get("method");

        System.out.println(className);
        System.out.println(methodName);

        //3.利用反射创建对象并运行方法
        Class clazz = Class.forName(className);

        //获取构造方法
        Constructor con = clazz.getDeclaredConstructor();
        Object o = con.newInstance();
        System.out.println(o);

        //获取成员方法并运行
        Method method = clazz.getDeclaredMethod(methodName);
        method.setAccessible(true);
        method.invoke(o);*/


    }
}