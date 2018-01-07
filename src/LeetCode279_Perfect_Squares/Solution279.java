import java.util.ArrayList;
import java.util.List;

public class Solution279 {
    public int numSquares(int n) {
        int [] nums = new int[n+1];
        for (int i = 1; i*i <= n; i++) {
            nums[i*i]=1;
        }
        for (int i = 2; nums[n]==0; i++) {
            int temp = i;
            int index = 1;
            int cnt=1;
            while (temp>0){
                index*=cnt++;
            }
        }
        findNum(list,n,0);
        return res;
    }
    int res = -1;
    void findNum(ArrayList<Integer> integers,int target,int count){
        //遍历
        if(target<0) return;
        if(target==0){
            res  = count;
        }else {
            if(res==-1) {
                for (Integer i:integers) {
                    findNum(integers,target-i,count+1);
                }
            }
        }

    }
}
