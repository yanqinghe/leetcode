import java.lang.reflect.Array;
import java.util.*;

public class Solution861 {
    class Matrix implements Cloneable {

        int[][] ints ;
        String str;
        public Matrix(int[][] ints) {
            int m = ints.length;
            int n = ints[0].length;
            StringBuilder sb= new StringBuilder();

            this.ints = new int[m][n];
            for (int i = 0; i < m; i++) {
                for (int j = 0; j < n; j++) {
                    this.ints[i][j]=ints[i][j];
                    sb.append((char)ints[i][j]);

                }
            }
            str=sb.toString();
        }

        @Override
        public int hashCode() {
            return str.hashCode();
        }

        @Override
        public boolean equals(Object obj) {
            return this.str.equals(((Matrix)obj).str);
        }

        @Override
        protected Object clone() throws CloneNotSupportedException {
            int[][] ints = new int[this.ints.length][this.ints[0].length];
            for (int i = 0; i < this.ints.length; i++) {
                for (int j = 0; j < this.ints[0].length; j++) {
                    ints[i][j]=this.ints[i][j];
                }
            }
            Matrix matrix = new Matrix(ints);
            return matrix;
        }

    }
    public int matrixScore(int[][] A) {
//        int m = A.length;
//        int n = A[0].length;
//        Set<Matrix> set = new HashSet<>();
//        Queue<Matrix> queue = new ArrayDeque<>();
//        queue.offer(new Matrix(A));
//        set.add(new Matrix(A));
//        int min = Integer.MAX_VALUE;
//        while (!queue.isEmpty()){
//            Matrix cur = queue.poll();
//            //变换行
//            int index =0;
//            for (int i = 0; i < m; i++) {
//                int[] temp = new int[n];
//                for (int j = 0; j < n; j++) {
//                    temp[j]= cur.ints[i][j];
//                    cur.ints[i][j]=cur.ints[i][j]==1?0:1;
//                }
//                min=Math.min(min,getVal(cur.ints,m,n));
//                Matrix matrix =new Matrix(cur.ints);
//                if(!set.contains(matrix)) queue.offer(matrix);
//                for (int j = 0; j < n; j++) {
//                    cur.ints[i][j]=temp[j];
//                }
//            }
//            //变换列
//            for (int i = 0; i < m; i++) {
//                char[] chars= str.toCharArray();
//                for (int j = 0; j < n; j++) {
//                    index=j*n+j;
//                    chars[index]=chars[index]=='1'?'0':1;
//                }
//                min=Math.min(min,getVal(chars,m,n));
//            }
//        }
        return 0;
    }
    int getVal(int[][] ints,int m,int n){
        int val=0;
        for (int[] anInt : ints) {
            for (int i = 0; i <n; i++) {
                if(anInt[i]==1){
                    val+=(1<<(n-i-1));
                }
            }
        }
        return val;
    }

}
