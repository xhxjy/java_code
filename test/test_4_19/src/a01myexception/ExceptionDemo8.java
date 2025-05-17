package a01myexception;

public class ExceptionDemo8 {
    public static void main(String[] args) {
        /*
            自己处理（捕获异常）灵魂四问：
                灵魂二问：如果try中可能会遇到多个问题，怎么执行？
                        会写多个catch与之对应
                        细节：
                            如果我们要捕获多个异常，这些异常中如果存在父子关系的话，那么父类一定要写在下面

                        了解性：
                            在JDK7之后，我们可以在catch中同时捕获多个异常，中间用|进行隔开
                            表示如果出现了A异常或者B异常的话，采取同一种处理方案

         */

        //若我们要捕获多个异常,这些异常存在父子关系,则需要将父类异常放在最后
        //因为找对应的catch语句时,是从上往下找的;若父类不在最后面,则它以后的catch语句都没机会执行
        int[] arr = {1, 2, 3, 4, 5, 6};
        try{
            System.out.println(arr[10]);//执行完这个语句后,它会直接跳出try里面的代码块,在catch中找对应的异常处理方案
            //执行完对应的catch语句后,不会再回到try的代码块中继续往下执行了
            System.out.println(2/0);//不会执行该语句
        } /*catch ( e) {
            System.out.println("除数不能为0");
        }*/ catch (ArithmeticException | ArrayIndexOutOfBoundsException e) {
            System.out.println("索引越界");
        }
        System.out.println("nh");




















        /*//JDK7
        int[] arr = {1, 2, 3, 4, 5, 6};

        try{
            System.out.println(arr[10]);//ArrayIndexOutOfBoundsException
            System.out.println(2/0);//ArithmeticException
            String s = null;
            System.out.println(s.equals("abc"));
        }catch(ArrayIndexOutOfBoundsException | ArithmeticException e){
            System.out.println("索引越界了");
        }catch(NullPointerException e){
            System.out.println("空指针异常");
        }catch (Exception e){
            System.out.println("Exception");
        }

        System.out.println("看看我执行了吗？");*/







    }
}
