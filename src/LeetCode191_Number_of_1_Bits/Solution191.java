
public class Solution191 {
    // you need to treat n as an unsigned value
    public int hammingWeight(int n) {
        long unsignedN = n&0x0FFFFFFFFl;
        short res = 0;
        while (unsignedN>0){
            if((unsignedN&1)==1) res++;
            unsignedN>>=1;
        }
        return res;
    }

}
