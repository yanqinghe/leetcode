public class Solution1 {
    public static void main(String[] args) {
        Solution1 solution1 = new Solution1();
        System.out.println(solution1.isRectangleOverlap(
//                new int[]{0,0,1,1},new int[]{1,0,2,1}
        new int[]{0,0,2,2},new int[]{1,1,3,3}
//        new int[]{-275916328,-417802221,22808107,675629469},new int[]{-257926405,-680763313,702840196,454409669}

        ));
    }
    public boolean isRectangleOverlap(int[] rec1, int[] rec2) {
       double[] c1 = center(rec1);
       double[] c2 = center(rec2);
        double sumx = Math.abs((long)rec1[0]-(long)rec1[2])+Math.abs((long)rec2[0]-(long)rec2[2]);
        double sumy = Math.abs((long)rec1[1]-(long)rec1[3])+Math.abs((long)rec2[1]-(long)rec2[3]);

        return Math.abs(c1[0]-c2[0])<sumx/2.0&&Math.abs(c1[1]-c2[1])<sumy/2.0;
    }
    double[] center(int[] rec){
        return new double[]{
                (rec[0]+rec[2])/2.0,(rec[1]+rec[3])/2.0
        };
    }


}
