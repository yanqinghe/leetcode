public class Solution409 {
    public int longestPalindrome(String s) {
        int[] arr = new int[52];
        for (char c : s.toCharArray()) {
            int i = c-'a';
            if(i>=0) i+=26;
            else i=c-'A';
            arr[i]++;
        }
        int ret =0;
        boolean is = false;
        for (int i : arr) {
            if(i>1) ret+=(i/2*2);
            if((i&1)==1)  is=true;
        }
        return is?ret+1:ret;
    }
}
