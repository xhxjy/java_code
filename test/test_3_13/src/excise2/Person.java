package excise2;

import java.util.Random;

public class Person {
    private String name;
    private int HP;
    private char gender;
    private String face;

    //    face 长相描述
    String[] boyfaces = {"风流俊雅", "气宇轩昂", "相貌英俊", "五官端正", "相貌平平"};
    String[] girlfaces = {"美奂绝伦", "沉鱼落雁", "婷婷玉立", "身材娇好", "相貌平平"};

    //    attack 攻击描述：
    String[] attacks_desc = {
            "%s使出了一招【背心钉】，转到对方的身后，一掌向%s背心的灵台穴拍去。",
            "%s使出了一招【游空探爪】，飞起身形自半空中变掌为抓锁向%s。",
            "%s大喝一声，身形下伏，一招【劈雷坠地】，捶向%s双腿。",
            "%s运气于掌，一瞬间掌心变得血红，一式【掌心雷】，推向%s。",
            "%s阴手翻起阳手跟进，一招【没遮拦】，结结实实的捶向%s。",
            "%s上步抢身，招中套招，一招【劈挂连环】，连环攻向%s。"
    };

    //    injured 受伤描述：
    String[] injureds_desc = {
            "结果%s退了半步，毫发无损",
            "结果给%s造成一处瘀伤",
            "结果一击命中，%s痛得弯下腰",
            "结果%s痛苦地闷哼了一声，显然受了点内伤",
            "结果%s摇摇晃晃，一跤摔倒在地",
            "结果%s脸色一下变得惨白，连退了好几步",
            "结果『轰』的一声，%s口中鲜血狂喷而出",
            "结果%s一声惨叫，像滩软泥般塌了下去"
    };

    //两个构造方法
    public Person() {
    }

    public Person(String name, int HP, char gender) {
        this.name = name;
        this.HP = HP;
        this.gender = gender;
        //随机长相
        setFace(gender);
    }

    //getter和setter
    public char getGender() {
        return gender;
    }

    public void setGender(char gender) {
        this.gender = gender;
    }

    public String getFace() {
        return face;
    }

    //根据性别得到长相(放到构造方法中更好)
    public void setFace(char gender) {
        Random a = new Random();
        int index = a.nextInt(boyfaces.length);
        if (gender == '男') {
            face = boyfaces[index];
        } else {
            face = girlfaces[index];
        }
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getHP() {
        return HP;
    }

    public void setHP(int HP) {
        this.HP = HP;
    }

    //行为
    //1.攻击
    //谁攻击谁(role为被攻击方)
    public void attack(Person role) {
        //随机输出一个攻击效果
        Random a = new Random();
        int index = a.nextInt(attacks_desc.length);
        String KungFu = attacks_desc[index];

        System.out.printf(KungFu, this.name, role.name);
        System.out.println();//换行

        //伤害
//        Random r = new Random();(与上面随机的重复)
        int hurt = a.nextInt(20) + 1;//1~20
        //剩余血量
        int currentHP = role.getHP() - hurt;
        //判断被攻击方的血量是否为0
        currentHP = currentHP < 0 ? 0 : currentHP;//三目运算符的使用场景
        role.HP = currentHP;

        //受伤的描述
        //分情况使用(根据血量的多少)
        if (currentHP > 90) {
            System.out.printf(injureds_desc[0], role.name);
        } else if (currentHP > 80) {//多写后面的条件,提高代码的可读性
            System.out.printf(injureds_desc[1], role.name);
        } else if (currentHP > 70) {
            System.out.printf(injureds_desc[2], role.name);
        } else if (currentHP > 60) {
            System.out.printf(injureds_desc[3], role.name);
        } else if (currentHP > 40) {
            System.out.printf(injureds_desc[4], role.name);
        } else if (currentHP > 20) {
            System.out.printf(injureds_desc[5], role.name);
        } else if (currentHP > 10) {
            System.out.printf(injureds_desc[6], role.name);
        } else {
            System.out.printf(injureds_desc[7], role.name);
        }
        System.out.println();//换行
    }

    //2.展示角色
    public void showRoleInfo() {
        System.out.println("姓名为:" + name);
        System.out.println("血量为:" + HP);
        System.out.println("性别为:" + gender);
        System.out.println("长相为:" + face);
    }
}
