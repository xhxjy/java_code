package myiotest1;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.Random;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Test1 {
    public static void main(String[] args) throws IOException {
        /*
         制造假数据：
             获取姓氏：https://hanyu.baidu.com/shici/detail?pid=0b2f26d4c0ddb3ee693fdb1137ee1b0d&from=kg0
             获取男生名字：http://www.haoming8.cn/baobao/10881.html
             获取女生名字：http://www.haoming8.cn/baobao/7641.html
        */
        //1.定义变量记录网址
        String familyName = "https://hanyu.baidu.com/shici/detail?pid=0b2f26d4c0ddb3ee693fdb1137ee1b0d&from=kg0";
        String boyName = "http://www.haoming8.cn/baobao/10881.html";
        String girlName = "http://www.haoming8.cn/baobao/7641.html";
        //2.读取网站里的数据,并将它们变成字符串
        String familyNameStr = webCrawler(familyName);
        String boyNameStr = webCrawler(boyName);
        String girlNameStr = webCrawler(girlName);
        //3.通过正则表达式来获取需要的数据(姓和名)
        //细节:正则表达式:"\\W"表示中文
//        ArrayList<String> familyNameTemList=getData(familyNameStr,"(\\W{4})(，|。)",1);

        ArrayList<String> familyNameTemList = getData(familyNameStr, "(\\W{4})(?=，|。)");
        ArrayList<String> boyNameTemList = getData(boyNameStr, "([\\u4E00-\\u9FA5]{2})(?=、|。)");
        //细节:可以将一行看作一个整体
        ArrayList<String> girlNameTemList = getData(girlNameStr, "(.. ){4}..");
        //4.处理数据
        //familyNameTemList
        ArrayList<String> familyNameList = processSurName(familyNameTemList);
        //boyNameTemList
        //有重复的要进行除重
        ArrayList<String> boyNameList = new ArrayList<>();
        for (String s : boyNameTemList) {
            if (!boyNameList.contains(s)) {
                boyNameList.add(s);
            }
        }
        //girlNameTemList
        ArrayList<String> girlNameList = processName(girlNameTemList);
        //5.生成数据:姓名(唯一)+性别+年龄
        ArrayList<String> infoList = getInfo(familyNameList, boyNameList, girlNameList, 50, 50);
        //6.写出数据
        BufferedWriter bw=new BufferedWriter(new FileWriter("iotest\\names.txt"));
        for (String info : infoList) {
            bw.write(info);
            bw.newLine();
        }
        bw.close();
    }

    //生成数据:姓名(唯一)+性别+年龄
    //法1:相较于法2,更加灵活
    //参数1,2,3:分别指处理过后的姓氏,男生名字和女生名字的集合
    //参数4,5:分别指男生和女生个数
    private static ArrayList<String> getInfo(ArrayList<String> familyNameList,
                                             ArrayList<String> boyNameList,
                                             ArrayList<String> girlNameList,
                                             int boycount, int girlCount) {
        //生成男生的名字
        HashSet<String> boyHs=new HashSet<>();
        while (true){
            if(boyHs.size()==boycount){
                break;
            }
            Collections.shuffle(familyNameList);
            Collections.shuffle(boyNameList);
            boyHs.add(familyNameList.getFirst()+boyNameList.getFirst());//getFirst()和get(0)效果一样
        }
        //生成女生的名字
        HashSet<String> girlHs=new HashSet<>();
        while (true){
            if(girlHs.size()==girlCount){
                break;
            }
            Collections.shuffle(familyNameList);
            Collections.shuffle(girlNameList);
            girlHs.add(familyNameList.getFirst()+girlNameList.getFirst());//getFirst()和get(0)效果一样
        }
        //创建一个集合存储男生和女生的信息
        ArrayList<String> list=new ArrayList<>();
        Random r=new Random();
        //生成男生的信息
        for (String name : boyHs) {
            int age = r.nextInt(10) + 18;
            list.add(name+"-男-"+age);
        }
        //生成女生的信息
        for (String name : girlHs) {
            int age = r.nextInt(5) + 18;
            list.add(name+"-女-"+age);
        }
        //打乱集合,保证信息的真实性
        Collections.shuffle(list);
        return list;
    }
    //法2:缺点:生成的数据个数固定,不够灵活
    /*Random r = new Random();
        //随机生成姓名(姓氏+名字)
        Collections.shuffle(familyNameList);
        Collections.shuffle(boyNameList);
        Collections.shuffle(girlNameList);
        //创建一个集合用来存储名字
        ArrayList<String> nameList = new ArrayList<>();
        //生成名字并添加到对应集合中
        for (String surName : familyNameList) {
            //随机性别:男/女
            //细节:三元表达式
            String gender = r.nextBoolean() ? "男" : "女";
            //每循环一次后需要将名字重新初始化
            String name="";
            //根据性别分情况
            if ("男".equals(gender)) {
                for (String bn : boyNameList) {
                    name = surName + bn;
                    nameList.add(name);
                }
            } else {
                for (String gn : girlNameList) {
                    name = surName + gn;
                    nameList.add(name);
                }
            }
        }
        Collections.shuffle(nameList);
        System.out.println(nameList);*/

    //处理数据(女性的名字)
    private static ArrayList<String> processName(ArrayList<String> namelist) {
        //遍历集合中的每一个元素(字符串),对每个字符串进行切割并将切割后的每一个元素添加进新的集合中
        ArrayList<String> resultList = new ArrayList<>();
        for (String s : namelist) {
            String[] arr = s.split(" ");
            for (String name : arr) {
                resultList.add(name);
            }
        }
        return resultList;
    }

    //处理数据(姓氏)
    static ArrayList<String> processSurName(ArrayList<String> list) {
        //遍历集合,遍历集合中的每一个元素(字符串),再将字符串中的每一个元素添加进新的集合中
        ArrayList<String> resultList = new ArrayList<>();
        for (String group : list) {
            //字符串的遍历:
            //法1
            /*char[] name = group.toCharArray();
            for (char c : name) {
                resultList.add(c+"");//细节:将字符转为字符串
            }*/

            //法2
            for (int i = 0; i < group.length(); i++) {
                char c = group.charAt(i);
                resultList.add(c + "");
            }
        }
        return resultList;
    }

    //通过正则表达式来获取姓
    //法1
    //index:表示分组索引
    /*private static ArrayList<String> getData(String familyNameStr, String regex,int index) {
        //1.创建集合
        ArrayList<String> list=new ArrayList<>();
        //2.
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(familyNameStr);
        while (matcher.find()){
            //将指定分组的内容加入集合
            list.add(matcher.group(index));
        }
        return list;
    }*/
//    通过正则表达式来获取姓
    //法2:用选择性爬取的方式
    private static ArrayList<String> getData(String familyNameStr, String regex) {
        //1.创建集合
        ArrayList<String> list = new ArrayList<>();
        //2.根据正则表达式来爬取数据,并将它们添加进集合中
        //根据正则表达式来生成pattern对象,即对应的规则
        Pattern pattern = Pattern.compile(regex);
        //拿到文本(网址)根据对应的规则来获取文本匹配器
        Matcher matcher = pattern.matcher(familyNameStr);
        //根据文本匹配器来获取数据
        while (matcher.find()) {
            list.add(matcher.group());
        }
        return list;
    }

    public static String webCrawler(String web) throws IOException {
        //1.定义StringBuffer来拼接爬取到的数据
        StringBuilder sb = new StringBuilder();
        //2.创建一个URL对象表示网址
        URL url = new URL(web);
        //3.链接上这个网址
        //细节:要保证网络畅通且可以访问到该网址
        URLConnection conn = url.openConnection();
        //4.读取数据
        //细节:因为读取到的数据有可能有中文,所以需要用到字节输入转换流
        InputStreamReader isr = new InputStreamReader(conn.getInputStream());
        char[] chars = new char[1024 * 1024];
        int len;
        while ((len = isr.read(chars)) != -1) {
            sb.append(new String(chars, 0, len));
        }
        //关流
        isr.close();
        return sb.toString();
    }






























    /*//1.定义变量记录网址
        String familyNameNet = "https://hanyu.baidu.com/shici/detail?pid=0b2f26d4c0ddb3ee693fdb1137ee1b0d&from=kg0";
        String boyNameNet = "http://www.haoming8.cn/baobao/10881.html";
        String girlNameNet = "http://www.haoming8.cn/baobao/7641.html";

        //2.爬取数据,把网址上所有的数据拼接成一个字符串
        String familyNameStr = webCrawler(familyNameNet);
        String boyNameStr = webCrawler(boyNameNet);
        String girlNameStr = webCrawler(girlNameNet);

        //3.通过正则表达式，把其中符合要求的数据获取出来
        ArrayList<String> familyNameTempList = getData(familyNameStr,"(.{4})(，|。)",1);
        ArrayList<String> boyNameTempList = getData(boyNameStr,"([\\u4E00-\\u9FA5]{2})(、|。)",1);
        ArrayList<String> girlNameTempList = getData(girlNameStr,"(.. ){4}..",0);

        //4.处理数据
        //familyNameTempList（姓氏）
        //处理方案：把每一个姓氏拆开并添加到一个新的集合当中
        ArrayList<String> familyNameList = new ArrayList<>();
        for (String str : familyNameTempList) {
            //str 赵钱孙李  周吴郑王   冯陈褚卫   蒋沈韩杨
            for (int i = 0; i < str.length(); i++) {
                char c = str.charAt(i);
                familyNameList.add(c + "");
            }
        }
        //boyNameTempList（男生的名字）
        //处理方案：去除其中的重复元素
        ArrayList<String> boyNameList = new ArrayList<>();
        for (String str : boyNameTempList) {
            if(!boyNameList.contains(str)){
                boyNameList.add(str);
            }
        }
        //girlNameTempList（女生的名字）
        //处理方案：把里面的每一个元素用空格进行切割，得到每一个女生的名字
        ArrayList<String> girlNameList = new ArrayList<>();

        for (String str : girlNameTempList) {
            String[] arr = str.split(" ");
            for (int i = 0; i < arr.length; i++) {
                girlNameList.add(arr[i]);
            }
        }

        //5.生成数据
        //姓名（唯一）-性别-年龄
        ArrayList<String> list = getInfos(familyNameList, boyNameList, girlNameList, 70, 50);
        Collections.shuffle(list);


        //6.写出数据
        BufferedWriter bw = new BufferedWriter(new FileWriter("myiotest\\names.txt"));
        for (String str : list) {
            bw.write(str);
            bw.newLine();
        }
        bw.close();*/

    /*
     * 作用：
     *      获取男生和女生的信息：张三-男-23
     *
     * 形参：
     *      参数一：装着姓氏的集合
     *      参数二：装着男生名字的集合
     *      参数三：装着女生名字的集合
     *      参数四：男生的个数
     *      参数五：女生的个数
     * */
    /*public static ArrayList<String> getInfos(ArrayList<String> familyNameList,ArrayList<String> boyNameList,ArrayList<String> girlNameList, int boyCount,int girlCount){
        //1.生成男生不重复的名字
        HashSet<String> boyhs = new HashSet<>();
        while (true){
            if(boyhs.size() == boyCount){
                break;
            }
            //随机
            Collections.shuffle(familyNameList);
            Collections.shuffle(boyNameList);
            boyhs.add(familyNameList.get(0) + boyNameList.get(0));
        }
        //2.生成女生不重复的名字
        HashSet<String> girlhs = new HashSet<>();
        while (true){
            if(girlhs.size() == girlCount){
                break;
            }
            //随机
            Collections.shuffle(familyNameList);
            Collections.shuffle(girlNameList);
            girlhs.add(familyNameList.get(0) + girlNameList.get(0));
        }
        //3.生成男生的信息并添加到集合当中
        ArrayList<String> list = new ArrayList<>();
        Random r = new Random();
        //【18 ~ 27】
        for (String boyName : boyhs) {
            //boyName依次表示每一个男生的名字
            int age = r.nextInt(10) + 18;
            list.add(boyName + "-男-" + age);
        }
        //4.生成女生的信息并添加到集合当中
        //【18 ~ 25】
        for (String girlName : girlhs) {
            //girlName依次表示每一个女生的名字
            int age = r.nextInt(8) + 18;
            list.add(girlName + "-女-" + age);
        }
        return list;
    }*/



    /*
     * 作用：根据正则表达式获取字符串中的数据
     * 参数一：
     *       完整的字符串
     * 参数二：
     *       正则表达式
     * 参数三：
     *      获取数据
     *       0：获取符合正则表达式所有的内容
     *       1：获取正则表达式中第一组数据
     *       2：获取正则表达式中第二组数据
     *       ...以此类推
     *
     * 返回值：
     *       真正想要的数据
     *
     * */
    /*private static ArrayList<String> getData(String str, String regex,int index) {
        //1.创建集合存放数据
        ArrayList<String> list = new ArrayList<>();
        //2.按照正则表达式的规则，去获取数据
        Pattern pattern = Pattern.compile(regex);
        //按照pattern的规则，到str当中获取数据
        Matcher matcher = pattern.matcher(str);
        while (matcher.find()){
            list.add(matcher.group(index));
        }
        return list;

    }*/


    /*
     * 作用：
     *   从网络中爬取数据，把数据拼接成字符串返回
     * 形参：
     *   网址
     * 返回值：
     *   爬取到的所有数据
     * */
    /*public static String webCrawler(String net) throws IOException {
        //1.定义StringBuilder拼接爬取到的数据
        StringBuilder sb = new StringBuilder();
        //2.创建一个URL对象
        URL url = new URL(net);
        //3.链接上这个网址
        //细节：保证网络是畅通的，而且这个网址是可以链接上的。
        URLConnection conn = url.openConnection();
        //4.读取数据
        InputStreamReader isr = new InputStreamReader(conn.getInputStream());
        int ch;
        while ((ch = isr.read()) != -1){
            sb.append((char)ch);
        }
        //5.释放资源
        isr.close();
        //6.把读取到的数据返回
        return sb.toString();
    }*/
}