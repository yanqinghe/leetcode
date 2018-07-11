import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Solution447 {
    public static void main(String[] args) {
        Solution447 solution447 = new Solution447();
        System.out.println(solution447.numberOfBoomerangs(new int[][]{
                {0,0},{1,0},{2,0}
        }));
    }
    public int numberOfBoomerangs(int[][] points) {
        int num  = points.length;
        Map<Double,Integer>[] maps = new Map[num];
        for (int i = 0; i <num ; i++) {
            maps[i]=new HashMap<>();
        }
        for (int i = 0; i < num; i++) {
            for (int j = i+1; j <num ; j++) {
                int dx = points[i][0]-points[j][0];
                int dy = points[i][1]-points[j][1];
                double d= Math.sqrt(dx*dx+dy*dy);
                maps[i].put(d,maps[i].getOrDefault(d,0)+1);
                maps[j].put(d,maps[j].getOrDefault(d,0)+1);
            }
        }
        int cnt =0;
        for (Map<Double, Integer> map : maps) {
            for (Integer i : map.values()) {
                cnt+=i*(i-1);
            }
        }
        return cnt;
    }
}
