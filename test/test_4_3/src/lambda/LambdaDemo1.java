package lambda;

public class LambdaDemo1 {
    public static void main(String[] args) {
        method(
                ()->{
            System.out.println("xhxjy");
                }
        );
    }
    public static void method(Swim s){
        s.swimming();
    }
}
interface Swim{
    public abstract void swimming();
}
