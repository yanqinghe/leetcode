import java.sql.Statement;
import java.util.*;
import java.util.stream.Collectors;

public class Solution316 {
    public static void main(String[] args) {
        Solution316 solution316 = new Solution316();
        System.out.println(solution316.removeDuplicateLetters("cbacdcbc"));
    }
    public String removeDuplicateLetters(String s) {
        //首先利用Set去重
        int[] dict = new int[26];
        boolean[] set = new boolean[26];
        for (int i = 0; i <s.length(); i++) {
            dict[s.charAt(i)-'a']=i;
        }
        Stack<Character> stack = new Stack<>();

        for (int i = 0; i < s.length() ; i++) {
            char c =s.charAt(i);
            if(set[c-'a']) continue;
            while ((!stack.isEmpty())&&c<stack.peek()&&dict[stack.peek()-'a']>i){
                set[stack.pop()-'a']=false;
            }
            stack.add(c);
            set[c-'a']=true;
        }
        StringBuilder sb = new StringBuilder();
        while (!stack.isEmpty()) sb.append(stack.pop());
        return sb.reverse().toString();
    }
}
