public class Solution798 {
    public int bestRotation(int[] A) {
        int len = A.length;
        int[] K = new int[len];

        for (int i = 0; i < len; ++i) {
            int left = (i - A[i] + 1 + len) % len;
            int right = (i + 1) % len;
            K[left]--;
            K[right]++;
            if (left > right)
                K[0]--;
        }
        int best = Integer.MIN_VALUE;
        int res = 0,cur = 0;

        for(int i=0;i<len;i++){
            cur +=K[i];
            if(cur>best){
                res = i;
                best = cur;
            }
        }
        return res;
    }
}
