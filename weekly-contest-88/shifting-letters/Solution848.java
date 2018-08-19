public class Solution848 {
    public static void main(String[] args) {
        Solution848 solution848 = new Solution848();
        System.out.println(solution848.shiftingLetters("gdhbjaph",new int[]{74,34,65,30,43,91,14,10}));
    }
    public String shiftingLetters(String S, int[] shifts) {
        char[] chars = S.toCharArray();
        long[] toShift = new long[shifts.length];
        int cnt =0;
        for (int i = shifts.length - 1; i >= 0; i--) {
            cnt+=shifts[i];
            cnt%=26;
            toShift[i]=cnt;
        }
        for (int i = 0; i < chars.length; i++) {
            shiftChars(chars,i,toShift[i]);
        }
        return String.valueOf(chars);
    }
    void shiftChars(char [] chars,int i,long n){
        long c = chars[i]-'a';
        c+=n;
        if(c>=26) c%=26;
        chars[i]=(char)(c+'a');
    }
}
