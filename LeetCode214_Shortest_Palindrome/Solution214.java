
public class Solution214 {
    public String shortestPalindrome(String s) {
        if(s==null||s.length()<1) return s;
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = s.length(); i >0; i--) {
            if(!isP(s.substring(0,i),0,i-1)){
                stringBuilder.append(s.charAt(i-1));
            }
        }
        return stringBuilder.append(s).toString();
    }
    boolean isP(String str,int i ,int j){
        if(i==j||i==j-1) return true;
        if(str.charAt(i)==str.charAt(j)){
            return isP(str,i+1,j-1);
        }
        return false;
    }
    public String shortestPalindrome2(String s) {
        String r = new StringBuilder(s).reverse().toString();
        String t = s + "#" + r;
        int[] next = new int[t.length()];
        for (int i = 1; i < t.length(); ++i) {
            int j = next[i - 1];
            while (j > 0 && t.charAt(i) != t.charAt(j)) j = next[j - 1];
            j += (t.charAt(i) == t.charAt(j)) ? 1 : 0;
            next[i] = j;
        }
        return r.substring(0, s.length() - next[t.length() - 1]) + s;
    }
}
