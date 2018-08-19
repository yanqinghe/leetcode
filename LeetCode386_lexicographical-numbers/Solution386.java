import java.util.ArrayList;
import java.util.List;

public class Solution386 {
    public static void main(String[] args) {
        Solution386 solution386 = new Solution386();
        System.out.println(solution386.lexicalOrder(100));
    }
    public List<Integer> lexicalOrder(int n) {
        List<Integer> ret = new ArrayList<>();
        for (int i = 1; i <=9; i++) {
            dfs(i,n,ret);
        }
        return ret;
    }
    private boolean dfs (int num,int n,List<Integer> ret){
        if(num>n) return false;
        ret.add(num);
        num*=10;
        for (int i = 0; i <=9; i++) {
            if(!dfs(num+i,n,ret)) break;
        }
        return true;
    }
}
