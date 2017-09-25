package LeetCode10_Regular_Expression_Matching;

/**
 * Created by yanqinghe on 2017/7/12.
 */
public class Solution10 {
    public static void main(String[] args){
        Solution10 solution = new Solution10();
        String[][] map = {{"aa","a"},
                {"aa","aa"},
                {"aaa","aa"},
                {"aa", "a*"},
                {"aa", ".*"},
                {"ab", ".*"},
                {"aab", "c*a*b"},
                {"", ".*"}};
        for(int i=0;i<map.length;i++){
            System.out.println(solution.isMatch2(map[i][0],map[i][1]));
        }

    }
    public boolean isMatch(String s, String p) {
        return subMatch(s,p,0,0);
    }
    //采用传统的递归方法
    private boolean subMatch(String s,String p,int i,int j){
        //如果对于P字符已经匹配完，
        if(j==p.length()){
            return i==s.length();
        }
        //如果p[j+1]不等于'*'，那么只需要判断当前的I,j是否相等，如果相等话进入下一层，如果不相等返回false，
        //在这里相等的条件包括s[i]==p[j]，以及p[j]=='i'
        //同时需要限定index的范围
        if((j==p.length()-1)||(p.charAt(j+1))!='*'){
            if(i==s.length()||(s.charAt(i)!=p.charAt(j)&&p.charAt(j)!='.')){
                return false;
            }else{
                return subMatch(s,p,i+1,j+1);
            }
        }
        //如果p[j+1]等于'*'，需要对s[i],
        while(i<s.length()&&(s.charAt(i)==p.charAt(j)||p.charAt(j)=='.')){
            if(subMatch(s,p,i,j+2)){
                return true;
            }
            i++;
        }
        return subMatch(s,p,i,j+2);
    }
    //采用动态规划的方法
    public boolean isMatch2(String s, String p){
        if(s.length()==0&&p.length()==0){
            return true;
        }
        if(p.length()==0){
            return false;
        }

        boolean[][] oo= new boolean[s.length()+1][p.length()+1];
        oo[0][0]=true;
        for(int i =0;i<p.length();i++){
            if(p.charAt(i)!='*'){
                for(int j=0;j<s.length();j++){
                    if(s.charAt(j)==p.charAt(i)||p.charAt(i)=='.'){
                        oo[j+1][i+1]=oo[j][i];
                    }
                }
            }else{
                //如果p为'*'
                if(i>0&&oo[0][i-1]) {
                    oo[0][i+1]=true;
                }
                if(i==0) continue;
                if(p.charAt(i-1)!='.'){
                    for(int j=0;j<s.length();j++){
                        if(oo[j+1][i]||i>0&&oo[j+1][i-1]
                                ||i>0 && j>0 &&oo[j][i+1] && s.charAt(j)==s.charAt(j-1) && s.charAt(j-1)==p.charAt(i-1)){
                            oo[j+1][i+1]=true;
                        }
                    }
                }else {
                    int j=0;
                    while(i>0 && j<s.length() && !oo[j+1][i-1] && !oo[j+1][i])
                        j++;
                    for(;j<s.length();j++)
                    {
                        oo[j+1][i+1] = true;
                    }
                }
            }
        }

        return oo[s.length()][p.length()];
    }

}
