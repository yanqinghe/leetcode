import java.util.ArrayDeque;
import java.util.Queue;
import java.util.Stack;

public class Solution345 {
    public static void main(String[] args) {
        Solution345 solution345 = new Solution345();
        System.out.println(solution345.reverseVowels("aA"));
    }
    public String reverseVowels(String s) {
        char[]chars= s.toCharArray();
        Stack<Character> stack = new Stack<>();
        Queue<Integer> queue = new ArrayDeque<>();
        for (int i = 0; i < chars.length; i++) {
            char c = Character.toLowerCase(chars[i]);
            if(c=='a'||c=='e'||c=='i'||c=='o'||c=='u'){
                stack.add(chars[i]);
                queue.offer(i);
            }
        }
        while (!stack.isEmpty()&&!queue.isEmpty()){
            chars[queue.poll()]=stack.pop();
        }
        return String.valueOf(chars);
    }
}
