public class Solution342 {
    final static int[] table = new int[]{
            1,4,16,64,256,1024,4096,16384,65536,262144,1048576,4194304,16777216,67108864,268435456,1073741824,    };
    public boolean isPowerOfFour(int num) {
        for (int i : table) {
            if(num==i) return true;
        }
        return false;
    }
}
