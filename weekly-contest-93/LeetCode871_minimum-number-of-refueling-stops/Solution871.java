import java.lang.reflect.Array;
import java.util.*;

public class Solution871 {
    public static void main(String[] args) {
        Solution871 solution871 = new Solution871();
        solution871.minRefuelStops(100,50,new int[][]{
//                {10,60},{20,30},{30,30},{60,40}
                {40,50}
        });
    }

    public int minRefuelStops(int target, int startFuel, int[][] stations) {
        long f = startFuel;
        Queue<Integer> pq = new PriorityQueue<Integer>();
        int ret = 0;
        int p = 0;
        long d = f;
        while(true){
            while(p < stations.length && stations[p][0] <= d){
                pq.add(-stations[p][1]);
                p++;
            }
            if(d >= target)return ret;
            if(pq.isEmpty())return -1;
            int val = -pq.poll();
            d += val;
            ret++;
        }
    }
}
