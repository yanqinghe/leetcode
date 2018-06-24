import java.util.*;

public class Solution816 {
    public static void main(String[] args) {
        Solution816 solution816 = new Solution816();
        solution816.ambiguousCoordinates("(100)");
    }
    public List<String> ambiguousCoordinates(String S) {
        List<String> res = new ArrayList<>();
        for (int i = 2; i <S.length()-1; i++) {
            help(i,S,res);
        }
        return res;
    }
    void help(int cur,String S, List<String> res){
        List<String> leftList = dfs(S.substring(1,cur));
        if(leftList.size()==0) return;
        List<String> rightList = dfs(S.substring(cur,S.length()-1));
        if(rightList.size()==0) return;
        for (String s : leftList) {
            for (String s1 : rightList) {
                res.add("("+s+", "+s1+")");
            }
        }

    }
    List<String> dfs(String subStr){
        List<String> list = new ArrayList<>();
        int len = subStr.length();
        if(subStr.length()==1){
            list.add(subStr);
        }else {
            if(subStr.charAt(0)=='0'){
                String temp =subStr.substring(1,len);
                if(confirmRight(temp)){
                    list.add("0."+temp);
                }

            }else {
                list.add(subStr);
                for (int i = 1; i < len; i++) {
                    String temp = subStr.substring(i,len);
                    if(confirmRight(temp)){
                        list.add(subStr.substring(0,i)+"."+temp);
                    }
                }
            }
        }
        return list;
    }
    boolean confirmRight(String str){
        return str.charAt(str.length()-1)!='0';
    }
}
