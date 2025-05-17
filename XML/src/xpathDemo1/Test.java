package xpathDemo1;

import org.dom4j.*;
import org.dom4j.io.SAXReader;

import java.io.File;
import java.util.List;

public class Test {
    public static void main(String[] args) throws DocumentException {
        //1.创建解析器对象
        SAXReader sr=new SAXReader();
        //2.通过解析器对象来读取xml文件,获取整个文档的对象
        Document document = sr.read(new File("D:\\java_code\\XML\\src\\xmldemo3\\user.xml"));
        //3.通过文档对象,然后用xpath方式进行快速检索
        //检索单个(第一个)
        Node node = document.selectSingleNode("/users/user/username");
        String username = node.getText();
        System.out.println(username);
        //检索多个
        List<Element> list1 = document.selectNodes("/users/user/username");
        for (Element element : list1) {
            System.out.println(element.getText());
        }

        //全文检索
        //3种路径
        //1.全文寻找username标签,无论它在哪
        List<Element> list2 = document.selectNodes("//username");
        System.out.println(list2.size());
        //2.在user标签里找username标签,但username要是user的子标签
        List<Element> list3 = document.selectNodes("//user/username");
        System.out.println(list3.size());
        //3.在user标签里找username标签,但username可以是user的子标签/孙标签
        List<Element> list4 = document.selectNodes("//user//username");
        System.out.println(list4.size());
        //总结:
        //路径中一个'/'表示单级路径,两个'/'即'//'表示单级/多级路径

        //属性检索
        //3种
        //1.查找指定的属性
        List<Attribute> list5 = document.selectNodes("//@id");
        for (Attribute attribute : list5) {
            System.out.println(attribute.getText());
        }
        //2.获取指定属性的标签
        List<Element> list6 = document.selectNodes("//user[@id]");
        System.out.println(list6.size());
        //3.获取指定属性和属性值的标签
        List<Element> list = document.selectNodes("//user[@id='1']");
        System.out.println(list.size());
    }
}
