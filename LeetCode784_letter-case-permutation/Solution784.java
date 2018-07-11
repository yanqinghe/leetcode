import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

public class Solution784 {
    public static void main(String[] args) {
        Solution784 solution784= new Solution784();
        solution784.letterCasePermutation("3z4");
    }
    public List<String> letterCasePermutation(String S) {
        char[] chars =     S.toCharArray();
        int len = chars.length;
        StringBuilder sb= new StringBuilder();
        Queue<String> strings = new ArrayDeque<>();
        for (char aChar : chars) {
            if(Character.isDigit(aChar)){
                sb.append(aChar);
            }else {
                String str = sb.toString();
                if (strings.isEmpty()){
                    strings.offer(str+Character.toUpperCase(aChar)+"");
                    strings.offer(str+Character.toLowerCase(aChar)+"");
                }else {
                    strings.add("");
                    String cur = strings.poll();
                    while (true){
                        if(cur.length()==0)
                            break;
                        strings.offer(cur+str+Character.toUpperCase(aChar));
                        strings.offer(cur+str+Character.toLowerCase(aChar));
                        cur=strings.poll();
                    }
                }
                sb= new StringBuilder();
            }
        }
        if(sb.length()>0){
            for (String string : strings) {
                string+=sb;
            }
        }
        List<String> res =new ArrayList<>();
        while (!strings.isEmpty()&&strings.peek().length()!=0){
            res.add(strings.poll());
        }
        if(res.size()==0) res.add(S);
        return res;
    }

}
