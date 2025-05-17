package junitdemo1;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class test1 {

    @Before
    public void method1(){
        System.out.println("Before");
    }

    @Test
    public void method2(){
        System.out.println("test");
    }

    @After
    public void method3(){
        System.out.println("After");
    }
}
