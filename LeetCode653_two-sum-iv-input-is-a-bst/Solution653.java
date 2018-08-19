import java.util.LinkedList;

public class Solution653 {
     class TreeNode {
      int val;
      TreeNode left;
     TreeNode right;
     TreeNode(int x) { val = x; }
 }
    public boolean findTarget(TreeNode root, int k) {
        LinkedList<Integer> list= new LinkedList<>();
        dfs(root,list);
        int l = list.pollFirst();
        int r = list.pollLast();
        while(list.size()>0){
            int sum = l+r;
            if(sum>k) r = list.pollFirst();
            else if(sum<k) l = list.pollLast();
            else return true;
        }
        return false;
    }
    private void dfs(TreeNode root,LinkedList<Integer> list){
        if(root==null) return;
        dfs(root.left,list);
        list.addLast(root.val);
        dfs(root.right,list);
    }
}
