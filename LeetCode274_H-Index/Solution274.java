public class Solution274 {
    public static void main(String[] args) {
        Solution274 solution274 = new Solution274();
        int[] citations = {3, 0, 6, 1, 5};
        System.out.println(solution274.hIndex(citations));
    }
    public int hIndex(int[] citations) {
        if(citations==null || citations.length<1) return 0;
        int n  = citations.length;
        int[] index = new int[n+1];
        //统计每种引用对应的论文个数
        for (int i = 0; i < n; i++) {
            if(citations[i]>=n){
                index[n]++;
            }else {
                index[citations[i]]++;
            }
        }
        //从最高引用开始向下
        int res = 0;
        for (int i = n; i >=0 ; i--) {
            res+=index[i];
            if(res>=i){
                res  =i;break;
            }
        }
        return res;
    }
}
