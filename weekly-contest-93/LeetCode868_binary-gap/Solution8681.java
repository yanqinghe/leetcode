public class Solution8681 {
    public int binaryGap(int N) {
        char[] chars = Integer.toBinaryString(N).toCharArray();
        int pre =0;
        int max = 0;
        for (int i = 1; i < chars.length; i++) {
            if(chars[i]=='1') {
                max = Math.max(i-pre,max);
                pre=i;
            }
       }
       return max;
    }
}
