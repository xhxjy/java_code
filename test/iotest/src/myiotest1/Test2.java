package myiotest1;


import cn.hutool.core.io.FileUtil;
import cn.hutool.core.util.ReUtil;
import cn.hutool.http.HttpUtil;

import java.util.*;


public class Test2 {
    public static void main(String[] args){
        //利用糊涂包生成假数据，并写到文件当中
        //糊涂包里有的功能
        //1.爬取数据,
        //2.利用正则表达式获取需要的数据
        //3.写出数据

        //1. 定义网址
        String familyNameNet = "https://hanyu.baidu.com/shici/detail?pid=0b2f26d4c0ddb3ee693fdb1137ee1b0d&from=kg0";
        String boyNameNet = "http://www.haoming8.cn/baobao/10881.html";
        String girlNameNet = "http://www.haoming8.cn/baobao/7641.html";

        //2.爬取网址里的数据
        String familyNameStr = HttpUtil.get(familyNameNet);
        String boyNameStr = HttpUtil.get(boyNameNet);
        String girlNameStr = HttpUtil.get(girlNameNet);
        //3.用正则表达式来获取需要的数据
        /*ArrayList<String> familyNameTemList = getData(familyNameStr, "(\\W{4})(?=，|。)");
        ArrayList<String> boyNameTemList = getData(boyNameStr, "([\\u4E00-\\u9FA5]{2})(?=、|。)");
        //细节:可以将一行看作一个整体
        ArrayList<String> girlNameTemList = getData(girlNameStr, "(.. ){4}..");*/
        ArrayList<String> familyNameTemList =(ArrayList<String>) ReUtil.findAll("(\\W{4})(?=，|。)", familyNameStr, 1);
        ArrayList<String> boyNameTemList =(ArrayList<String>) ReUtil.findAll("([\\u4E00-\\u9FA5]{2})(?=、|。)", boyNameStr, 1);
        ArrayList<String> girlNameTemList =(ArrayList<String>) ReUtil.findAll("(.. ){4}..", girlNameStr, 0);
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
        //6.糊涂包的相对路径,不是相对于当前模块,而是相对于class文件的
        FileUtil.writeLines(infoList,"names.txt","UTF-8");

    }
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





























    /* //2.爬取数据
        String familyNameStr = HttpUtil.get(familyNameNet);
        String boyNameStr = HttpUtil.get(boyNameNet);
        String girlNameStr = HttpUtil.get(girlNameNet);

        //3.利用正则表达式获取数据
        //通过正则表达式，把其中符合要求的数据获取出来
        List<String> familyNameTempList = ReUtil.findAll("(.{4})(，|。)", familyNameStr, 1);
        List<String> boyNameTempList = ReUtil.findAll("([\\u4E00-\\u9FA5]{2})(、|。)", boyNameStr, 1);
        List<String> girlNameTempList = ReUtil.findAll("(.. ){4}..", girlNameStr, 0);

        System.out.println(familyNameTempList);
        System.out.println(boyNameTempList);
        System.out.println(girlNameTempList);

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
        //细节：
        //糊涂包的相对路径，不是相对于当前项目而言的，而是相对class文件而言的
        FileUtil.writeLines(list,"D:\\names.txt","UTF-8");*/

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
    /*public static ArrayList<String> getInfo(ArrayList<String> familyNameList,ArrayList<String> boyNameList,ArrayList<String> girlNameList, int boyCount,int girlCount){
        //1.生成男生不重复的名字
        HashSet<String> boyhs = new HashSet<>();
        while (true){
            if(boyhs.size() == boyCount){
                break;
            }
            //随机
            Collections.shuffle(familyNameList);
            Collections.shuffle(boyNameList);
            boyhs.add(familyNameList.getFirst() + boyNameList.getFirst());
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
            girlhs.add(familyNameList.getFirst() + girlNameList.getFirst());
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
}
