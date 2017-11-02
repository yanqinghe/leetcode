package LeetCode140_Word_Break_2;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Solution140 {
    public List<String> wordBreak(String s, List<String> wordDict) {
        Set<String> set = new HashSet<>();
        int maxLen = 0;
        for (String str:wordDict
             ) {
            if(str.length()>maxLen) maxLen=str.length();
            set.add(str);
        }
        boolean[] dp = new boolean[s.length()+1];
        dp[0]=true;
        for (int i = 1; i <=s.length() ; i++) {
            for (int j = i-1; j >=Math.max(0,i-1-maxLen); j--) {
                if(dp[j]&&set.contains(s.substring(j,i))){
                    dp[i]=true;
                    break;
                }
            }
        }
        List<String> res = new ArrayList<String>();
        if(!dp[s.length()]) return res;

        List<String> path = new ArrayList<String>();
        help(s,set,path,res,0,dp,maxLen);
        return res;
    }
    private void help(String s, Set<String> dict, List<String> path, List<String> res, int index, boolean dp[],int maxLen){
        int len = s.length();
        if(index==len){
            StringBuilder sb = new StringBuilder();
            for(String str:path){
                sb.append(str);
                sb.append(' ');
            }
            sb.deleteCharAt(sb.length()-1);
            res.add(sb.toString());
            return;
        }
        if(!dp[index]) return;
        len = Math.min(index+maxLen,len);
        for (int i=index;i<len;i++){
            String left = s.substring(index,i+1);
            if(dict.contains(left)){
                path.add(left);
                help(s,dict,path,res,i+1,dp,maxLen);
                path.remove(path.size()-1);
            }
        }
    }

    public List<String> wordBreak2(String s, List<String> wordDict) {
        Set<String> set = new HashSet<>();
        int maxLen = 0;
        for (String str:wordDict
                ) {
            if(str.length()>maxLen) maxLen=str.length();
            set.add(str);
        }
        List<String> [] res = new List[s.length()+1];
        res[0]= new ArrayList<>();
        for (int i = 1; i <=s.length() ; i++) {
            res[i] = new ArrayList<>();
            for (int j = i-1; j >=Math.max(0,i-maxLen+1); j--) {
                String sub = s.substring(j,i);
                if(j==0&&set.contains(sub)){
                    res[i].add(s.substring(j,i));
                }else if(!res[j].isEmpty()&&set.contains(sub)){
                    for (String str: res[j]
                            ) {
                        StringBuilder sb = new StringBuilder(str);
                        sb.append(' ');
                        sb.append(sub);
                        res[i].add(sb.toString());
                    }
                }
            }
        }

        return res[s.length()];
    }
}
