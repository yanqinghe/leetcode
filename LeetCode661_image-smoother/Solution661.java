import java.lang.reflect.Array;
import java.util.Arrays;

public class Solution661 {
    public int[][] imageSmoother(int[][] M) {
        int rows = M.length;
        int cols = M[0].length;
        int[][] res = new int[rows][cols];

        for(int i=0; i<rows; i++)
        {
            for(int j=0; j<cols; j++)
            {
                int sum = 0;
                int count = 0;
                // sum 3x3 area and take care of the boundary
                for(int x=Math.max(0,i-1); x<=Math.min(rows-1, i+1); x++)
                {
                    for(int y=Math.max(0, j-1); y<=Math.min(cols-1, j+1); y++)
                    {
                        sum += M[x][y]; // sum up cells value
                        count++; // count cells number
                    }
                }

                res[i][j] = sum / count; // get average value
            }
        }

        return res;
    }
}
