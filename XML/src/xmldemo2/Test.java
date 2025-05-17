package xmldemo2;

import org.dom4j.Attribute;
import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class Test {
    public static void main(String[] args) throws DocumentException {
        ArrayList<Person> list=new ArrayList<>();

        //1.创建解析器对象
        SAXReader sr=new SAXReader();
        //2.用解析器对象读取整个文档的对象
        Document document = sr.read(new File("D:\\java_code\\XML\\src\\XmlDemo1\\person.xml"));
        //关键:一层一层的获取文本里的内容
        //3.获取根标签
        Element rootElement = document.getRootElement();
        //4.获取根标签里的子标签
        //细节:泛型为Element类型
        //指定标签名字获取子标签
        List<Element> elements = rootElement.elements("person");
        for (Element element : elements) {
            //5.获取子标签里的内容
            //属性id
            //找到属性/标签
            Attribute id = element.attribute("id");
            //获得属性/标签里的值
            String idValue = id.getText();

            //标签name
            Element name = element.element("name");
            String nameValue = name.getText();

            //标签age
            Element age = element.element("age");
            String ageText = age.getText();
            //类型转换
            int ageValue = Integer.parseInt(ageText);

            //将各属性封装为一个对象并添加进集合中
            Person p = new Person(idValue, nameValue, ageValue);
            list.add(p);
        }
        System.out.println(list);

    }
}
