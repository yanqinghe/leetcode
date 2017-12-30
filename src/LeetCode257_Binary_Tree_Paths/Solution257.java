import java.util.ArrayList;
import java.util.List;

public class Solution257 {


    public List<String> binaryTreePaths(TreeNode root) {
        List<String> res = new ArrayList<>();
        if(root==null) return res;
        dfs(root,res,"");
        return res;
    }

    void dfs(TreeNode treeNode,List<String> res, String str){
        if(str.length()<1){
            str+=treeNode.val;
        }else {
            str+="->"+treeNode.val;
        }

        if(treeNode.left==null&&treeNode.right==null){
            res.add(str);
        }else{
            if(treeNode.left!=null){
                dfs(treeNode.left,res,str);
            }
            if(treeNode.right!=null){
                dfs(treeNode.right,res,str);
            }
        }
    }
     class TreeNode {
     int val;
     TreeNode left;
     TreeNode right;
     TreeNode(int x) { val = x; }
  }
}
