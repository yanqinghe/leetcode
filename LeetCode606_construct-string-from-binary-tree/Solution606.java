import java.util.Queue;
import java.util.Stack;

public class Solution606 {
    public String tree2str(TreeNode t) {
        StringBuilder sb= new StringBuilder(dfs(t,true));
        sb.deleteCharAt(sb.length()-1).deleteCharAt(0);
        return sb.toString();
    }
    private String dfs(TreeNode treeNode,boolean is){
        if(treeNode==null) return is?"()":"";
        StringBuilder sb = new StringBuilder().append('(').append(treeNode.val);
        String right = dfs(treeNode.right,false);
        String left = dfs(treeNode.left,right.length()==0?false:true);
        sb.append(left).append(right).append(')');
        System.out.println(sb.toString());
        return sb.toString();
    }
    private class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }
}
