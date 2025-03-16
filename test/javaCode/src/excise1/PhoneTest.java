package excise1;

public class PhoneTest {
    public static void main(String[] args) {
        Phone a = new Phone();
        a.setBrand("小米");
        a.setPrice(1999);
        a.setColor("绿色");
        a.call();
        a.sendMessage();
    }
}
