public class Solution801 {
    private  int min =0;
//    public int minSwap(int[] A, int[] B) {
//        int len =A.length;
//        int[] AM = new int[len+2];
//        int[] BM = new int[len+2];
//        AM[0]=BM[0]=-1;
//        AM[len+1]=BM[len+1]=2001;
//        for (int i = 0; i < len; i++) {
//            AM[i+1]=A[i];
//            BM[i+1]=B[i];
//        }
//        for (int i = 0; i < len; i++) {
//            if(A[i+1]<=A[i]){
//                int temp = A[i];
//            }
//        }
//    }
//
//    void help(int[]A,int []B,int index,int pre,int min){
//        for (int i = index; i < A.length; i++) {
//            if(A[i]<A[i-1]){
//                //交换i-1和交换i
//                int temp1 = A[i-1];
//                if(B[i-1]<A[i]&&B[i-1]>){
//                    A[i-1]=B[i-1];
//                    B[i-1]=A[i-1];
//                    help(A,B,i,A[i-1],min+1);
//                }
//                temp1 = A[i];
//            }
//        }
//    }
}
