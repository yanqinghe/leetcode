package LeetCode135_Candy;

public class Solution135 {
    public static void main(String[] args) {
        Solution135 solution135 = new Solution135();
        int[] a = {2,2,3,3,3,2,2};
        System.out.println(solution135.candy(a));
    }
    public int candy(int[] ratings) {
        int len = ratings.length;
        if (len < 2) {
            return len;
        }
        int[] candy = new int[len + 1];
        candy[0] = 1;
        for (int i = 1; i < len; i ++) {
            if (ratings[i] > ratings[i - 1]) {
                candy[i] = candy[i - 1] + 1;
            }
            else if (candy[i] == candy[i - 1]){
                candy[i] = candy[i - 1];
            }
            else {
                candy[i] = 1;
            }
        }
        int ans = 0;
        for (int i = len - 1; i > 0; i --) {
            if (candy[i] >= candy[i - 1] && ratings[i] < ratings[i - 1]) {
                candy[i - 1] = Math.max(candy[i - 1], candy[i] + 1);
            }
            ans += candy[i];
        }
        return ans + candy[0];
    }

}
