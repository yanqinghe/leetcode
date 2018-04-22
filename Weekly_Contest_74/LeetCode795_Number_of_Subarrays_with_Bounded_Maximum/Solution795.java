import java.util.ArrayList;
import java.util.List;

public class Solution795 {
    public static void main(String[] args) {
        Solution795 solution795 = new Solution795();
        System.out.println(solution795.numSubarrayBoundedMax(new int[]{
                904,293,747,238,787,746,224,902,705,511,527,763,540,734,512,717,252,391,267,856,916,342,401,331,956,793,397,296,29,168,982,434,790,752,925,54,188,555,232,58,283,622,178,663,171,957,567,934,706,516,806,722,38,731,100,430,581,497,770,34,224,365,118,665,556,554,796,302,438,958,172,990,947,7,556,293,351,803,554,829,155,996,151,717,282,940,399,43,966,40,448,244,776,707,93,150,997,117,950,251}
                //0,  1,  2,  3,  4,  5,  6,  7,  8,  9, 10, 11, 12, 13, 14, 15, 16
                //0,  1,  1,  2,  2,  2,  3,  3,  3,  4,  4,  4,  4,  4,
                ,80,524));
    }
    public int numSubarrayBoundedMax(int[] A, int L, int R) {
        if(A==null||A.length<1) return 0;
        for (int i = 0; i < A.length; i++) {

            dfs(A,i,L,R,A[i]);
        }
        return cnt;
    }
    int cnt = 0;
    void dfs(int[] A,int right,int L,int R,int max){

        if(right==A.length||A[right]>R) return;

        max = Math.max(A[right],max);

        if(max>=L) cnt++;

        dfs(A,right+1,L,R,max);
    }
}
