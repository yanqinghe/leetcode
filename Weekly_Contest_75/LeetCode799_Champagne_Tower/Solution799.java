import java.util.ArrayList;
import java.util.List;

public class Solution799 {
    public static void main(String[] args) {
        Solution799 solution799 = new Solution799();
        solution799.champagneTower(4,2,1);
    }
    public double champagneTower(int poured, int query_row, int query_glass) {

        double[] waterDP = {poured};
        int lvl = 0;
        while (lvl<query_row){
            double[] waterTemp = new double[waterDP.length+1];
            if(waterDP[0]>1) waterTemp[0] = (waterDP[0]-1.0)*0.5;
            waterTemp[waterDP.length]= waterTemp[0];
            for (int i = 1; i <waterDP.length; i++) {
                waterTemp[i]=
                        (waterDP[i-1]>1?(waterDP[i-1]-1)*0.5:0)
                                +(waterDP[i]>1?(waterDP[i]-1)*0.5:0);

            }
            waterDP=waterTemp;

//            for(double d:waterTemp){
//                System.out.print( d+",");
//            }
//            System.out.print('\n');
            lvl++;
        }
        return waterDP[query_glass]>1?1:waterDP[query_glass];
    }
}

