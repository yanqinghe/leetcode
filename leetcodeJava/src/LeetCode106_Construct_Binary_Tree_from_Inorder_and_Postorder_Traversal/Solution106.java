package LeetCode106_Construct_Binary_Tree_from_Inorder_and_Postorder_Traversal;

import java.util.HashMap;
import java.util.Map;

public class Solution106 {
    /**
     * Definition for a binary tree node.
     * public class TreeNode {
     * int val;
     * TreeNode left;
     * TreeNode right;
     * TreeNode(int x) { val = x; }
     * }
     */
    private Map<Integer,Integer> map = new HashMap<>();
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        if(postorder==null||inorder==null||postorder.length<1||inorder.length<1){
            return null;
        }
        for (int i = 0; i < inorder.length; i++) {
            map.put(inorder[i],i);
        }
        return  help(postorder,0,postorder.length-1,0,inorder.length-1);
    }
    private TreeNode help(int[] postorder,int startP,int endP,int startI,int endI){
               if(startP==endP){
            return new TreeNode(postorder[startP]);
        }
        //根据前序遍历的第一个元素获取根节点的值，然后从Map中获取根节点对应在中序遍历的位置
        int rootIndex = map.get(postorder[endP]);
        //生成当前的根节点
        TreeNode  root = new TreeNode(postorder[endP]);
        //计算左子树对应前序遍历的长度
        int llen =rootIndex-startI;
        int rlen =endI-rootIndex;

        if(llen>0){
            //递归得到左子树
            root.left=help(postorder,startP,endP-rlen-1,startI,rootIndex-1);
        }
        if(rlen>0){
            //递归得到右子树
            root.right=help(postorder,endP-rlen,endP-1,rootIndex+1,endI);
        }

        return root;
    }

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }
}
