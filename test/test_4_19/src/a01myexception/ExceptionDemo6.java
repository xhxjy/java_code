package a01myexception;

import java.util.MissingFormatArgumentException;

public class ExceptionDemo6 {
    public static void main(String[] args) {
        /*
            自己处理（捕获异常）
            格式：
                try {
                   可能出现异常的代码;
                } catch(异常类名 变量名) {
                   异常的处理代码;
                }
             好处:可以让程序继续往下执行，不会停止
         */

        /*格式:try{
        可能出现异常的代码
        }
        catch{
        处理方案
        }
        */
        //好处:可以让程序继续往下执行，不会停止
        int[] arr = {1, 2, 3, 4, 5, 6};
        try{
            System.out.println(arr[10]);
            //创建对应的异常对象,即ArrayIndexOutOfBoundsException,
            //拿着它去和下面的catch里的参数进行对比,若参数类型相同,则执行catch里的代码;
            // 反之jvm会对该异常进行处理
        } catch (MissingFormatArgumentException e) {
            System.out.println("索引越界");
        }
        System.out.println("xhnxjy");





















        /*int[] arr = {1, 2, 3, 4, 5, 6};
        try{
            //可能出现异常的代码;
            System.out.println(arr[10]);//此处出现了异常，程序就会在这里创建一个ArrayIndexOutOfBoundsException对象
                                        //new ArrayIndexOutOfBoundsException();
                                        //拿着这个对象到catch的小括号中对比，看括号中的变量是否可以接收这个对象
                                        //如果能被接收，就表示该异常就被捕获（抓住），执行catch里面对应的代码
                                        //当catch里面所有的代码执行完毕，继续执行try...catch体系下面的其他代码
        }catch(ArrayIndexOutOfBoundsException e){
            //如果出现了ArrayIndexOutOfBoundsException异常，我该如何处理
            System.out.println("索引越界了");
        }

        System.out.println("看看我执行了吗？");*/

    }
}
