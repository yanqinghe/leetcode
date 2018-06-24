public class Solution829 {
    public static void main(String[] args) {
        Solution829 solution829 = new Solution829();
        System.out.println(solution829.consecutiveNumbersSum(1));
    }

    public int consecutiveNumbersSum(int N) {
        int l = 1;
        int r = 0;
        int sum = 0;
        int ans = 0;
        while (true) {
            while (sum < N && r <= N) {
                sum += (++r);
            }
            if (sum < N) break;
            else if (sum > N) {
                sum -= l;
                l++;

            } else {
                ans++;
                sum -= l;
                l++;
            }
        }
        return ans;
    }

    public int consecutiveNumbersSum2(int N) {
        int count = 1;
        for( int k = 2; k < Math.sqrt( 2 * N ); k++ ) {
            if ( ( N - ( k * ( k - 1 )/2) ) % k == 0) count++;
        }
        return count;
    }

}
