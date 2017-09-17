package Container_With_Most_Water_11;

/**
 * Created by yanqinghe on 2017/7/13.
 */
public class Solution11 {
    public static void main(String[] args){
        Solution11 solution = new Solution11();
        int[] arr = {1,2,3,4};
        System.out.print(solution.maxArea(arr));
    }
    public int maxArea(int[] height) {
        int ans = 0;
        int l = 0;
        int r = height.length - 1;
        while (l < r) {
            int v = (r - l) * Math.min(height[l], height[r]);
            if (v > ans) ans = v;
            if (height[l] < height[r]) l++;
            else r--;
        }
        return ans;
    }
}
