package LeetCode131_Palindrome_Partitioning;

import org.omg.PortableServer.LIFESPAN_POLICY_ID;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Solution131 {
    public static void main(String[] args) {
        Solution131 solution131 = new Solution131();
        solution131.partition("aabb");
    }
    public List<List<String>> partition(String s) {
        boolean[][] dp = new boolean[s.length()][s.length()];
        List<List<String>>[] resHelp  = new List[s.length()+1];
        resHelp[0]=new ArrayList<List<String>>();
        for (int i = 0; i < s.length(); i++) {
            resHelp[i+1] = new ArrayList<List<String>>();
            for (int j = 0; j <= i; j++) {
                if(i==j) dp[i][j]=true;
                else if(i==j+1) dp[i][j]=s.charAt(i)==s.charAt(j);
                else dp[i][j]=dp[i-1][j+1]&&s.charAt(i)==s.charAt(j);
                if(j==0&&dp[i][j]){
                    List<String> list = new ArrayList<>();
                    list.add(s.substring(j,i+1));
                    resHelp[i+1].add(list);
                    continue;
                }
                if(!resHelp[j].isEmpty()&&dp[i][j]){
                    for (List<String> list: resHelp[j]
                         ) {
                        List<String > list1 = new ArrayList<>(list);
                        list1.add(s.substring(j,i+1));
                        resHelp[i+1].add(list1);
                    }
                }
            }
        }
        return resHelp[s.length()];
    }

}
