package test_3_19;

import java.util.ArrayList;

public class WorkerTest {
    public static void main(String[] args) {
        ArrayList<Worker> list=new ArrayList<>();

        Worker worker1=new Worker("张三",3000);
        Worker worker2=new Worker("王五",4000);
        Worker worker3=new Worker("赵六",5000);
        Worker worker4=new Worker("田七",6000);

        list.add(worker1);
        list.add(worker2);
        list.add(worker3);
        list.add(worker4);

        for (int i = 0; i < list.size(); i++) {
            Worker worker = list.get(i);
            if(worker.getName().equals("王五")){
                worker.setName("王小五");
//                list.set(i,worker);//将改过名字的对象重新赋给当前元素,也可以直接将对象的名字改了
            }
            if(worker.getName().equals("赵六")){
//删除该元素后,后面的元素会往前走,则i+1后会丢失往前移动的那个元素,所以需要--重新调整索引
                list.remove(i--);//i--的妙处:既达到了要删除当前元素的目的,又--了
            }
            if(worker.getName().equals("田七")){
                worker.setWages(worker.getWages()+500);
            }
        }

        for (int i = 0; i < list.size(); i++) {
            Worker worker = list.get(i);
            System.out.println(worker.getName()+","+worker.getWages());
        }
    }
}
//集合中删除元素会对后续的遍历造成影响,需要将索引--