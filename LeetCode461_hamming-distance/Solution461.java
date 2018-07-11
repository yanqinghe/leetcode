public class Solution461 {
    public static void main(String[] args) {
        Solution461 solution461 = new Solution461();
        System.out.println(solution461.hammingDistance(1,4));
    }
    public int hammingDistance(int x, int y) {
        int ret =0;
        int z = x^y;
        for (int i = 0; i < 32; i++) {
            if((z&1)==1)ret++;
            z=z>>1;
        }
        return ret;
    }
}
