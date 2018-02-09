import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Solution756 {
    public static void main(String[] args) {
        Solution756 solution756 = new Solution756();
        System.out.println(1<<~0<0);
    }
    public boolean pyramidTransition(String bottom, List<String> allowed) {
        int[][] help = new int[7][7];
        for (String string:
                allowed) {
            int i = string.charAt(0)-'A';
            int j = string.charAt(1)-'A';
            int top = string.charAt(2)-'A';
            help[i][j]|=1<<top;
        }
        int len  = bottom.length();//底边长
        int [] dp = new int[len];
        //将底边放到dp中
        for (int i = 0; i < len; i++) {
            dp[i]=1<<bottom.charAt(i)-'A';
        }
        for (int i = len-1;i >0; i--) {
            //从下到上计算每层
            int [] ndp = new int[i];//每一层的局部变量
            for (int j = 0; j < i; j++) {
                int l = dp[j];
                int r =dp[j+1];
                for (int k = 0; k < 7; k++) {
                    for (int m = 0; m < 7; m++) {
                        if(l<<~k<0&&r<<~m<0){
                            ndp[j]|=help[k][m];
                        }
                    }
                }
            }
            dp=ndp;
        }
        return dp[0]!=0;
    }


}
