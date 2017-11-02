package LeetCode3_Longest_Substring_Without_Repeating_Characters;

/**
 * Created by yanqinghe on 2017/7/2.
 */
public class Solution3 {
    public static void main(String args[]){
        Solution3 solution = new Solution3();
        System.out.println(solution.lengthOfLongestSubstring("bbbbb"));
    }
    public int lengthOfLongestSubstring(String s) {
        char[] chars = s.toCharArray();
        Integer[] charResult = new Integer[128];
        int begin =0;
        int end=0;
        int max=0;
        for(int i=0;i<chars.length;i++) {
            int eeee = chars[i] + 0;
            int preIndex = charResult[eeee]==null?-1:charResult[eeee];
            if (preIndex >= begin) {

                begin = preIndex + 1;
            }
                max = (max <= (i - begin+1) ? (i - begin+1) : max);

            charResult[eeee] = i;
        }
//        max=max==0?chars.length:max;
        return  max;
    }
}
