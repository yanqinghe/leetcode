public class Solution476 {
    public static void main(String[] args) {
        Solution476 solution476 = new Solution476();
        solution476.findComplement(5);
    }
    public int findComplement(int num) {
        int len = Integer.toBinaryString(num).length();
        int mask=0;
        for (int i = 0; i < len; i++) {
            mask+=1<<i;
        }
        return (~num)&mask;
    }
}
