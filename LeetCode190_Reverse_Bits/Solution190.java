package LeetCode190_Reverse_Bits;

public class Solution190 {
    public static void main(String[] args) {
        Solution190 solution190 = new Solution190();
        System.out.println(solution190.reverseBits(   268435456));
    }
    // you need treat n as an unsigned value
    public int reverseBits(int n) {
        long unsignedN = n&0x0FFFFFFFFl;
        unsignedN |=0x100000000l;
        long res = 0;
        while (unsignedN!=1){
            res |= unsignedN&1;
            res<<=1;
            unsignedN>>=1;
        }
        res>>=1;
        if((res&0x080000000l)==0x080000000l){
            return (int)res|0b1000_0000_0000_0000_0000_0000_0000_0000;
        }else return (int)res;

    }

}
