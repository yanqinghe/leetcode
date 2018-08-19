import java.util.ArrayList;
import java.util.List;

public class Solution437 {
    public int pathSum(TreeNode root, int sum) {
        dfs(root,sum,new ArrayList<>());
        return cnt;
     }
     private int cnt =0;
     private void dfs(TreeNode root, int sum, List<Integer> list){
         if(root==null) return ;
         list.add(0);
         for (int i = 0; i < list.size(); i++) {
                list.set(i,list.get(i)+root.val);
            if(list.get(i)==sum) cnt++;
         }
        dfs(root.left,sum, new ArrayList<>(list));
         dfs(root.right,sum, new ArrayList<>(list));

     }
      class TreeNode {
     int val;
     TreeNode left;
      TreeNode right;
    TreeNode(int x) { val = x; }
  }
}
