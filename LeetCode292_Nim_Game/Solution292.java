public class Solution292{
    public static void main(String[] args) {
        
    }
    /**
     * 超时
     */
    public boolean canWinNim1(int n) {
        if(n<3) return true;
        return !(canWinNim(-1)&&canWinNim(n-2)&&canWinNim(n-3));
    }
    //
    /**
     * 考虑采用动态规划
     * 
     * 然而 在找规律的时候就发现不需要动态规划，n%4==0的说明是false 其余的为true
     * 1 2 3 4 5 6 7 8 9
     * t t t f t t t f t
     */
    public boolean canWinNim(int n) {
        // boolean[] dp = new boolean[n];
        // for(int i =0;i<n;i++){

        // }
        return n%4==0?false:true;
    }
}