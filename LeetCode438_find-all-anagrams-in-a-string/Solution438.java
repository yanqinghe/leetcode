import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution438 {
    public static void main(String[] args) {
        Solution438 solution438 = new Solution438();
        System.out.println(solution438.findAnagrams("abab","ab"));
    }
    public List<Integer> findAnagrams(String s, String p) {
        int[] pArr  = new int[26];
        for (char c : p.toCharArray()) {
            pArr[c-'a']++;
        }
        int[] sArr = new int[26];
        int len1 = p.length();
        int len2 = s.length();
        List<Integer> res = new ArrayList<>();
        char[] chars = s.toCharArray();
        int i =0,len=0;
        while (i+len<len2){
            if(len<len1){
                len++;
                sArr[chars[i+len-1]-'a']++;
            }else {
                if(equal(sArr,pArr)) res.add(i);
                sArr[chars[i]-'a']--;
                i++;
                len--;
            }
        }
        if(equal(sArr,pArr)) res.add(i);
        return res;
    }
    boolean equal(int[] nums1,int[] nums2){
        for (int i = 0; i < nums1.length; i++) {
            if(nums1[i]!=nums2[i]) return false;
        }
        return true;
    }
}
