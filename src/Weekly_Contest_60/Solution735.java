
import java.util.Stack;

public class Solution735 {
    public static void main(String[] args) {
        Solution735 solution735 = new Solution735();
        int[] a = {10,2,-5};
        solution735.asteroidCollision(a);
    }
    public int[] asteroidCollision(int[] asteroids) {
        if(asteroids==null||asteroids.length<1) return asteroids;
        Stack<Integer> stack= new Stack<>();
        for (int i = 0; i < asteroids.length; i++) {
            if(asteroids[i]<0){
                while (!stack.isEmpty()&&stack.peek()>0&&stack.peek()<(-asteroids[i])){
                    stack.pop();
                }
                 if(stack.isEmpty()||stack.peek()<0){
                    stack.push(asteroids[i]);
                                }else if(stack.peek()==-asteroids[i]){
                    stack.pop();
                }
            }else {
                stack.push(asteroids[i]);
            }
        }
        int[] res=new int[stack.size()];
        for (int i = res.length-1; i >=0 ; i--) {
            res[i]=stack.pop();
        }
        return res;
    }
}
