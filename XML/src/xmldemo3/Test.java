package xmldemo3;

import org.dom4j.Attribute;
import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Test {
    public static void main(String[] args) throws DocumentException {
        //解析xml并将解析到的信息封装为一个个对象
        //1.创建一个集合,存储对象
        ArrayList<User> list=new ArrayList<>();
        //2.创建解析器对象
        SAXReader sr=new SAXReader();
        //3.通过解析器对象读取整个文档,获取文档对象
        Document document = sr.read(new File("D:\\java_code\\XML\\src\\xmldemo3\\user.xml"));
        //4.通过文档对象来获得根标签
        Element rootElement = document.getRootElement();
        //5.通过根标签来获得子标签的集合,并遍历得到各个子标签
        List<Element> elements = rootElement.elements("user");
        for (Element element : elements) {
            //获取属性
            //获取属性/标签的对象
            Attribute id = element.attribute("id");
            //获取对象的文本信息(即对应的属性值),为String类型,有的时候要进行类型转换
            String idValue = id.getText();

            //获取用户名
            Element username = element.element("username");
            String usernameValue = username.getText();

            //获取密码
            Element password = element.element("password");
            String passwordValue = password.getText();

            //获取电话号码
            Element phoneId = element.element("phoneId");
            String phoneIdValue = phoneId.getText();

            //获取是否为管理员
            Element admin = element.element("admin");
            String adminValue = admin.getText();
            //转换类型
            boolean b = Boolean.parseBoolean(adminValue);

            //将各个属性封装为一个user对象并添加进集合中
            list.add(new User(idValue,usernameValue,passwordValue,phoneIdValue,b));
        }
        System.out.println(list);

        //登录操作
        Scanner sc=new Scanner(System.in);
        System.out.println("请输入用户名");
        String username = sc.nextLine();
        System.out.println("请输入密码");
        String password = sc.nextLine();
        //判断用户名是否存在
        int index = getIndex(list, username);
        if(index!=-1){
            //用户名存在
            User user = list.get(index);
            if(user.getPassword().equals(password)){
                System.out.println("登陆成功");
            }else{
                System.out.println("密码错误,请重新输入");
            }
        }else{
            System.out.println("用户名不存在,请先注册");
        }
    }

    public static int getIndex(ArrayList<User> list, String username){
        for (int i = 0; i < list.size(); i++) {
            User user = list.get(i);
            if(user.getUsername().equals(username)){
                return i;
            }
        }
        return -1;
    }
}
