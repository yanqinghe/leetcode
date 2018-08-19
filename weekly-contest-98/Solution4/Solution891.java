import org.omg.CORBA.MARSHAL;

import java.util.*;

public class Solution891 {
    public static void main(String[] args) {
        Solution891 solution891 = new Solution891();
        solution891.sumSubseqWidths(new int[]{2,1,3});
    }

    public int sumSubseqWidths(int[] A) {
        Arrays.sort(A);
        long  res = 0,c=1,mod = (long)1e9 + 7;
        for (int i = 0; i < A.length; i++,c=(c<<1)%mod) {
            res= (res+A[i] *c -A[A.length-i-1] *c)%mod;
        }
        return (int)((res + mod) % mod);
    }

}
