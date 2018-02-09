import java.util.HashSet;
import java.util.Set;

/**
 * Created with Hehel
 * Description:
 * User: Hehel
 * Date: 2017-12-24
 * Time: 10:27
 */
public class Solution4 {
    public static void main(String[] args) {
        Solution4 solution4 = new Solution4();
        System.out.println(solution4);
    }
    public String crackSafe(int n, int k) {
        int size = (int) Math.pow(k, n);
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; ++i) {
            sb.append("0");
        }
        String init = sb.toString();
        Set<String> vis = new HashSet<>();
        vis.add(init);
        ans = init;
        valid = false;
        int len = n - 1;
        dfs(init, vis, k, size, len);
        return ans;
    }
    boolean valid = false;

    String ans;
    boolean dfs(String init, Set<String> vis, int k, int size, int len) {
        if (vis.size() == size) {
            ans = init;
            return true;
        }
        else {
            int n = init.length();
            for (int j = 0; j < k; ++j) {
                String ns = init.substring(n - len, n) + j;
                if (!vis.contains(ns)) {
                    vis.add(ns);
                    if (dfs(init + j, vis, k, size, len)) return true;
                    vis.remove(ns);
                }
            }
        }
        return false;
    }

}
