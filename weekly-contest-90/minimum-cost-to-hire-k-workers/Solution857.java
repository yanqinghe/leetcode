import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.PriorityQueue;

public class Solution857 {
    public double mincostToHireWorkers(int[] quality, int[] wage, int K) {
        int len = quality.length;
        Person[] people = new Person[len];
        for (int i = 0; i < len; i++) {
            people[i]= new Person(quality[i],wage[i]);
        }
        Arrays.sort(people);
        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>();
        long qSum =0;
        double ret =Double.MAX_VALUE;
        for (int i = 0; i < len; i++) {
            priorityQueue.add(-(people[i].quality));
            qSum+= people[i].quality;
            if(priorityQueue.size()>K){
                //如果人数超出限制，那么当前队列中拥有最大quality的元素，该元素位于队列的队首。
                //同时重新计算qSum
                qSum+=priorityQueue.poll();
            }
            if(priorityQueue.size()==K){
                //如果人数符合要求，那么计算最低工资。最低工资的计算方式就是quality与当前最大比值的乘积
                ret=Math.min(ret,qSum*people[i].r);
            }
            //如果人数不足，继续添加
        }
        return ret;
    }
    class Person implements Comparable<Person> {
        int quality;
        int wage;
        double r;
        public Person(int quality, int wage) {
            this.quality = quality;
            this.wage = wage;
            this.r=this.wage/(double)this.quality;
        }

        @Override
        public int compareTo(Person s) {
            return Double.compare(this.r,s.r);
        }
    }
}
