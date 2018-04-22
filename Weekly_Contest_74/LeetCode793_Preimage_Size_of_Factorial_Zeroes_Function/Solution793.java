public class Solution793 {
    public static void main(String[] args) {
        Solution793 solution793 = new Solution793();
        System.out.println(solution793.preimageSizeFZF(0));
    }
    public int preimageSizeFZF(int K) {

//        while ()
        return (int)(binaryCount(K)-binaryCount(K-1));
    }

    /**
     * 计算末尾小于等于n个零的个数
     * @param n
     * @return
     */
    long binaryCount(int n){
        long low = -1, high = 3000000000L;
        while(high - low > 1){
            long h = high+low>>1;
            long s = 0;
            for(long k = h/5;k > 0;k /= 5)s += k;
            if(s <= n){
                low = h;
            }else{
                high = h;
            }
        }
        return low+1;
    }
}
