package excise3;


import java.util.Scanner;

/*定义一个长度为3的数组，数组存储1~3名学生对象作为初始数据，学生对象的学号，姓名各不相同。
        学生的属性：学号，姓名，年龄。
        要求1：再次添加一个学生对象，并在添加的时候进行学号的唯一性判断。
        要求2：添加完毕之后，遍历所有学生信息。
        要求3：通过id删除学生信息:如果存在，则删除，如果不存在，则提示删除失败。
        要求4：删除完毕之后，遍历所有学生信息。
        要求5：查询数组id为“heima002”的学生，如果存在，则将他的年龄+1岁*/
public class StudentTest {
    public static void main(String[] args) {
        Student[] arr = new Student[3];

        Student s1 = new Student(1, "zqg", 18);
        Student s2 = new Student(2, "xjy", 24);
        Student s3 = new Student(3, "zzz", 20);

        arr[0] = s1;
        arr[1] = s2;
        arr[2] = s3;
        //需求1 再次添加一个学生对象，并在添加的时候进行学号的唯一性判断
        //创建新的对象
        Student s4 = new Student(4, "hhh", 20);
        Scanner sc=new Scanner(System.in);
        //不重复
        if (contain(arr, s4.getId())) {
            //将其添加进数组,分两种情况:
            if (arr.length == getCount(arr)) {
                //1.数组已满:创建新数组(比老数组的长度大1)
                //返回新数组
                Student[] arr1 = creatNewArr(arr);
                //添加新的数据
                arr1[arr1.length - 1] = s4;
                //需求2.遍历数组验证一下
                printArr(arr1);
//        要求3：通过id删除学生信息:如果存在，则删除，如果不存在，则提示删除失败。
                //输入id
                System.out.println("请输入你要删除学生的id");
                int deleteId = sc.nextInt();
                //找到id对应的索引
                int deleteIndex=getIndex(arr1,deleteId);
                //存在
                if(-1!=deleteIndex){
                    //删除学生信息(无需创建删除后的数组,也可以展示删除后的信息;
                    // 直接将对应元素的地址赋值为空,再用遍历方法打印即可)
                    arr1[deleteIndex]=null;
                    printArr(arr1);
                }
                //不存在
                else{
                    System.out.println("当前id不存在,删除失败");
                }
//                要求5：查询数组id为“2”的学生，如果存在，则将他的年龄+1岁
                //查找功能
                //输入id
                System.out.println("请输入你要查找学生的id");
                int checkId = sc.nextInt();
                //找到id对应的索引
                int checkIndex=getIndex(arr1,checkId);
                //存在
                if(-1!=checkIndex){
                    int age=arr1[checkIndex].getAge()+1;
                    arr1[checkIndex].setAge(age);//需要更改对象的隐私属性时,需要用到setter和getter
                    printArr(arr1);
                }
                //不存在
                else{
                    System.out.println("当前id不存在,查询失败");
                }
            }
//            else {
//                //2.数组未满:直接添加即可
//                arr[getCount(arr)] = s4;//举例子理解其中的索引
//                //需求2.遍历数组验证一下
//                printArr(arr);
////        要求3：通过id删除学生信息:如果存在，则删除，如果不存在，则提示删除失败。
//                //输入id
//                System.out.println("请输入你要删除学生的id");
//                int id = sc.nextInt();
//                //找到id对应的索引
//                int deleteIndex=getIndex(arr,id);
//                //存在
//                if(-1!=deleteIndex){
//                    //删除学生信息(无需创建删除后的数组,也可以展示删除后的信息)
//                    arr[deleteIndex]=null;
//                    printArr(arr);
//                }
//                //不存在
//                else{
//                    System.out.println("当前id不存在,删除失败");
//                }
//            }
        }else{
            //重复
            System.out.println("id重复,添加失败");
        }
    }

    //先判断id是否重复,即id是否存在于原数组中(可以用boolean类型),
    // 从而判断是否要将其添加进数组(将其写为一个方法)
    public static boolean contain(Student[] arr, int id) {//将要用的id与arr[]数组的id进行比较
        for (int i = 0; i < arr.length; i++) {
            Student stu = arr[i];
            //数组未满时需要进行非空判断(stu为空时,不可调用方法)
            //1.数据为空时(不用管)
            //2.为非空时
            if(stu!=null){
                // 判断是否重复
                if (id == stu.getId()) {
                    return false;//重复
                }
            }
        }
        return true;
    }

    //判断数组中存了几个元素
    public static int getCount(Student[] arr) {
        int count = 0;//记录存储的元素个数
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] != null)
                count++;
        }
        return count;
    }

    //数组已满,创建新数组(最后一个数据为空,因为我们只是创建新数组,无需添加新数据)
    public static Student[] creatNewArr(Student[] arr) {//要用到老数组
        // 将老数组的数据拷贝过来,再添加新的数据
        Student[] arr1 = new Student[arr.length + 1];
        //将对象添加进对象数组的方法就是:将对象的地址传给数组的元素
        //将老数组的数据拷过来
        for (int i = 0; i < arr.length; i++) {
            arr1[i] = arr[i];
        }
//        //添加新的数据(本方法无此功能)
//        arr1[arr1.length - 1] = stu;
        return arr1;
    }

    //遍历数组(多个地方有遍历数组的需求)
    public static void printArr(Student[] arr) {
        for (int i = 0; i < arr.length; i++) {
            //数组可能未满,其中的元素可能为空,需要进行判断,不打印无效数据
            //有效数据
            Student stu = arr[i];
            if (stu != null) {
                System.out.println("id:" + stu.getId() + "name:" +
                        stu.getName() + "age:" + stu.getAge());
            }
        }
    }

//    //通过id删除学生信息(直接将要删除的元素赋值为null即可)
//    public static Student[] delete(Student[] arr, int id){
//        int deleteIndex=0;
//        //找到id对应的元素在数组中对应的索引
//        if(-1==getIndex(arr,id)){
//            return null;
//        }
//        else{
//            deleteIndex=getIndex(arr,id);
//        }
//        //删除
//        for (int i = 0; i < arr.length; i++) {
//            if(i>deleteIndex)
//                arr[i-1]=arr[i];
//        }
//        //创建删除后的数组
//        Student[] newArr=new Student[arr.length-1];
//        //将原数组拷贝
//        for (int i = 0; i < newArr.length; i++) {
//            newArr[i]=arr[i];
//        }
//        return newArr;
//    }

    //找到删除元素在数组中对应的索引
    public static int getIndex(Student[] arr, int id){
        int i = 0;
        for (i = 0; i < arr.length; i++) {
            //数组未满时需要进行非空判断
            //1.数据为空时(不用管)
            //2.为非空时
            if(arr[i]!=null){
                if (id == arr[i].getId()) {
                    return i;
                }
            }
        }
        //未找到对应元素(即提示删除失败)
        return -1;
    }
}
