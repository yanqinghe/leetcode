import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Solution859 {
    public static void main(String[] args) {
        Solution859 solution859 = new Solution859();
        System.out.println(solution859.buddyStrings("ab","ab"));
    }
    public boolean buddyStrings(String A, String B) {
        if(A.length()!=B.length()) return false;
        int len = A.length();
        int cnt =0;
        int[] arr1 = new int[26];
        int[] arr2 = new int[26];
        for (int i = 0; i < len; i++) {
            if(A.charAt(i)!=B.charAt(i)){
                cnt++;
            }
            arr1[A.charAt(i)-'a']+=1;
            arr2[B.charAt(i)-'a']+=1;
        }
        boolean is=false;
        for (int i = 0; i < 26; i++) {
            if(arr1[i]-arr2[i]!=0) return false;
            if(arr1[i]>=2) is=true;
        }
        return cnt==2||(cnt==0&&is);
    }
}
