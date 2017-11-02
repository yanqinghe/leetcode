package LeetCode125_Valid_Palindrome;

public class Solution125 {
    public static void main(String[] args) {
        Solution125 solution125 = new Solution125();
        solution125.isPalindrome("0P");
    }
    public boolean isPalindrome(String s) {
        int l = 0;
        int r = s.length()-1;
        while (l<r){
            if(!help(s.charAt(l))){
                l++;
                continue;
            }
            if(!help(s.charAt(r))){
                r--;
                continue;
            }
            if(((s.charAt(l) + 32 - 'a') %32 != (s.charAt(r) + 32 - 'a') % 32)){
                return false;
            }else {
                l++;
                r--;
            }

        }
        return true;
    }
    private boolean help(char c){
        if(c>='a'&&c<='z') return true;
        if(c<='Z'&&c>='A') return true;
        if(c>='0'&&c<='9') return true;
        return false;
    }
}
