import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Map;

public class Solution94_3 {
    public static void main(String[] args) {
        Solution94_3 solution94_3 = new Solution94_3();
        System.out.println(solution94_3.minEatingSpeed(new int[]{
                30,11,23,4,20
        },6));
    }
    public int minEatingSpeed(int[] piles, int H) {
        int l = 1;
        int h = 0;
        for (int pile : piles) {
            h=Math.max(pile,h);
        }
        int res = h;
        int len = piles.length;
        while (l<=h){
            int m = l+(l-h)/2;
            if(canEat(m,piles,H)){
                res= Math.min(res,m);
                h=m-1;
            }else {
                l=m+1;
            }
        }
        return res;
    }
    boolean canEat(int v,int[] piles,int time){
        int cnt =0;
        for (int pile : piles) {
            cnt+=pile/v;
            if(pile%v>0) cnt++;

        }
        return cnt<=time;
    }

}
