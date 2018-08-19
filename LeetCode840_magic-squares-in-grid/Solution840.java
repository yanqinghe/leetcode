import org.omg.CORBA.INTERNAL;

public class Solution840 {
    public int numMagicSquaresInside(int[][] grid) {
        int res = 0;
        for(int i=0;i<=grid.length-3;i++)
            for(int j=0;j<=grid[0].length-3;j++)
            {
                if(magicHelper(i,j,grid))
                    res++;
            }

        return res;

    }
    boolean magicHelper(int x,int y,int[][]  grid){
        if(grid[x+1][y+1]!=5)   return false;

        for(int i = x;i<x+3;i++)
        {
            int tmp = 0;
            for(int j = y;j<y+3;j++)
            {
                tmp += grid[i][j];
                if(grid[i][j]<10 && grid[i][j]>0)
                    continue;
                else
                    return false;
            }
            if(tmp!=15) return false;

        }
        int sum = 0;
        sum = grid[x][y] + grid[x+1][y] + grid[x+2][y];      if(sum!=15)  return false;
        sum = grid[x][y+1] + grid[x+1][y+1] + grid[x+2][y+1];if(sum!=15)  return false;
        sum = grid[x][y+2] + grid[x+1][y+2] + grid[x+2][y+2];if(sum!=15)  return false;

        sum = grid[x][y] + grid[x+1][y+1]+ grid[x+2][y+2];   if(sum!=15)  return false;
        sum = grid[x][y+2] + grid[x+1][y+1] + grid[x+2][y];  if(sum!=15)  return false;

        return true;
    }
}
