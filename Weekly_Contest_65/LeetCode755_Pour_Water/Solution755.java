import java.util.logging.Level;

public class Solution755 {
    public static void main(String[] args) {
        Solution755 solution755 = new Solution755();
        int[] heights = {1, 2, 3, 4, 3, 2, 1, 2, 3, 4, 3, 2, 1};
        solution755.pourWater(heights, 5, 5);

    }

    public int[] pourWater(int[] heights, int V, int K) {
        //对倒入的水进行遍历
        for (int i = 0; i < V; i++) {
            int cur = K;
            for (int left = cur - 1; left >= 0; left--) {
                if (heights[left] < heights[cur]) {
                    cur = left;
                }else {
                    if (heights[left] > heights[cur]) break;
                }
            }
            for (int right = cur + 1; right < heights.length; right++) {
                if (heights[right] < heights[cur]) {
                    cur = right;
                }else {
                    if (heights[right] > heights[cur]) break;
                }

            }
            heights[cur]++;
        }
        return heights;
    }
}