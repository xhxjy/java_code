package test;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class ProxyUtil {
    //作用:创建一个代理
    /*
    * 返回值:一个代理
    * 形参:被代理的明星
    *
    * 需求:外面的人想要大明星唱一首歌
    * 1.先找代理(获取代理的对象)
    * 2.代理找明星唱歌(代理调用唱歌方法,在底层叫明星唱歌)*/
    public static Star creatProxy(BigStar bigStar){
        /* java.lang.reflect.Proxy类：提供了为对象产生代理对象的方法：
        public static Object newProxyInstance(ClassLoader loader, Class<?>[] interfaces, InvocationHandler h)
        参数一：用于指定用哪个类加载器，去加载生成的代理类
        参数二：指定接口，这些接口用于指定生成的代理长什么，也就是有哪些方法
        参数三：用来指定生成的代理对象要干什么事情*/
        Star star =(Star) Proxy.newProxyInstance(
                ProxyUtil.class.getClassLoader(),//参数一：用于指定用哪个类加载器，去加载生成的代理类
                new Class[]{Star.class},//参数二：指定接口,在接口里找代理要有的方法
                new InvocationHandler() {//用来指定生成的代理对象要干什么事
                    @Override
                    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                        /*
                        * 参数1:代理对象(不用管)
                        * 参数2:代理要运行的方法(如:sing)
                        * 参数3:调用方法(sing)时要传递的参数
                        * */
                        if("sing".equals(method.getName())){
                            //增强方法
                            System.out.println("准备话筒,收钱");
                        } else if ("dance".equals(method.getName())) {
                            //增强方法
                            System.out.println("布置场地,收钱");
                        } else if ("cleanWC".equals(method.getName())) {
                            //拦截方法
                            return null;
                        }
                        //找明星唱歌或跳舞(本质:调用大明星的唱歌或跳舞的方法)
                        return method.invoke(bigStar,args);
                    }
                }
        );
        return star;
    }
}
