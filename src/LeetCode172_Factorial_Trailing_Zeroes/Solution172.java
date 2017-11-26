package LeetCode172_Factorial_Trailing_Zeroes;

public class Solution172 {
    public int trailingZeroes(int n) {
        int res = 0;
        while (n>0){
            res+=n/5;
            n/=5;

        }

        return res;
    }
}
