public class Solution275 {
    public int hIndex(int[] citations) {
        if(citations==null||citations.length<1) return 0;
        int n = citations.length;
        int cnt =Math.min(1,citations[n-1]);
        for (int i = n-2; i >=0 ; i--) {
            if(citations[i]!=citations[i+1]&&cnt>=citations[i])
                return Math.min(cnt,citations[i+1]);
            cnt++;

        }
        return Math.min(cnt,citations[0]);
    }
}
