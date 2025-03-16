package excise2;

public class GameTest {
    public static void main(String[] args) {
        Person a = new Person("xjy", 100, '女');
        Person b = new Person("zqg", 100, '男');

//        //根据性别得到长相(放到构造方法中更好)
//        a.setFace(a.getGender());
//        b.setFace(b.getGender());

        a.showRoleInfo();
        b.showRoleInfo();
        //开始格斗(回合制)
        while (true) {
            //a攻击b
            a.attack(b);
            //判断b的血量是否为0,若是则结束
            if (b.getHP() == 0) {
                System.out.println(a.getName() + "KO了" + b.getName());
                break;
            }
            //b攻击a
            b.attack(a);
            //判断a的血量
            if (a.getHP() == 0) {
                System.out.println(b.getName() + "KO了" + a.getName());
                break;
            }
        }
    }
}
