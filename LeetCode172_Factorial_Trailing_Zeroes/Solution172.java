
public class Solution172 {
    public static void main(String[] args) {
        Solution172 solution172 = new Solution172();
        System.out.println(solution172.trailingZeroes(50));
    }
    public int trailingZeroes(int n) {
        int res = 0;
        while (n>0){
            res+=n/5;
            n/=5;

        }

        return res;
    }
}
