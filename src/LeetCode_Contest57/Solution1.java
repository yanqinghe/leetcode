package LeetCode_Contest57;

import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

public class Solution1 {
    public static void main(String[] args) {
        Solution1 solution1 = new Solution1();
        String [] s = {"k","lg","it","oidd","oid","oiddm","kfk","y","mw","kf","l","o","mwaqz","oi","ych","m","mwa"};
        solution1.longestWord(s);
    }
    public String longestWord(String[] words) {
        if(words==null||words.length<1) return "";
        Arrays.sort(words);
               Set<String> set = new HashSet<>();
        int max =0;
        for (int i = 0; i < words.length; i++) {
                set.add(words[i]);

        }
        String res = "";
        int len = 0;
        for (int i = 0; i < words.length; i++) {
            if(words[i].length()>len){
                boolean is = true;
                for (int j = 1; j < words[i].length(); j++) {
                    if(!set.contains(words[i].substring(0,j))){
                        is=false;
                        break;
                    }
                }
                if(is){
                    res= words[i];
                    len=words[i].length();
                }
            }
        }
        return  res;
    }
}
