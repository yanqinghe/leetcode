public class Solution223 {
    public static void main(String[] args) {
        Solution223 solution223 = new Solution223();
        System.out.println(solution223.computeArea(-1500000001,
                0,
                -1500000000,
                1,
                1500000000,
                0,
                1500000001,
                1));
    }
    public int computeArea(int A, int B, int C, int D, int E, int F, int G, int H) {
        int area1 = (C-A)*(D-B);
        int area2 = (G-E)*(H-F);
        return area1+area2-(int)overArea(A, B, C, D, E, F, G, H);
    }
    long overArea(long A, long B, long C, long D, long E, long F, long G, long H){
        long w = Math.min(C,G)- Math.max(A, E);
        long h = Math.min(D,H)-Math.max(B,F);
        if(w<=0||h<=0) return 0;
        return w*h;
    }
}
