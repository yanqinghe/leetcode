
import java.util.*;

public class Solution94_2 {
    public static void main(String[] args) {
        Solution94_2 solution94_2 = new Solution94_2();
        System.out.println(solution94_2.robotSim(new int[]{
                4,-1,4,-2,4
        },new int[][]{
                {2,4}
        }));
    }

    static short[][] dir= {{0,1},{1,0},{0,-1},{-1,0}};

    public int robotSim(int[] commands, int[][] obstacles) {
        Map<Integer,Set> mapMap = new HashMap<>();
        int d =0;
        int x,y;
        x=y=0;
        for (int[] obstacle : obstacles) {
            int x1 = obstacle[0];
            int y1 = obstacle[1];
            if(!mapMap.containsKey(x1)) mapMap.put(x1,new HashSet());
            mapMap.get(x1).add(y1);
        }
        int ret = 0;
        for(int cmd : commands) {
            if(cmd==-1){
                d=(d+1)%4;
            }else if(cmd==-2){
                d=(d+3)%4;
            }else {
                for (int i = 0; i < cmd; i++) {
                    int tempX = x+dir[d][0];
                    int tempY = y+dir[d][1];
                    if(mapMap.containsKey(tempX)&&mapMap.get(tempX).contains(tempY)){
                        break;
                    }else {
                        x=tempX;
                        y=tempY;
                    }

                }
            }
            ret=Math.max(ret,x*x+y*y);
        }
        return ret;
    }

}
