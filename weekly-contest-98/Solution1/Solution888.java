public class Solution888 {
    public static void main(String[] args) {
        Solution888 solution888 = new Solution888();
        solution888.fairCandySwap(new int[]{1,2,5},new int[]{2,4});
    }
    public int[] fairCandySwap(int[] A, int[] B) {
        int sum1 = 0;
        for (int i : A) {
            sum1+=i;
        }
        int sum2 = 0;
        for (int i : B) {
            sum2+=i;
        }
        int sum=(sum1+sum2)/2;
        int d1 = sum1 - sum;
        int d2 =sum2 -sum;
        for (int i : A) {
            for (int j : B) {
                if(d1==(i-j)&&d2==(j-i)){
                    return new int[]{i,j};
                }
            }
        }
        return new int[]{0,0};
    }
}
