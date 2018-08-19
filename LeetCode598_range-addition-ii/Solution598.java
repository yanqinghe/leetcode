public class Solution598 {
    public int maxCount(int m, int n, int[][] ops) {
        int a =m;
        int b= n;
        for (int[] op : ops) {
            a=Math.min(op[0],a);
            b=Math.min(op[1],b);
        }
        return a*b;

    }
}
