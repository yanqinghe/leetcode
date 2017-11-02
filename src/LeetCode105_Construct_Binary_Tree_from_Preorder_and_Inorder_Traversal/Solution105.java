package LeetCode105_Construct_Binary_Tree_from_Preorder_and_Inorder_Traversal;

import java.util.HashMap;
import java.util.Map;

public class Solution105 {
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
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if(preorder==null||inorder==null||preorder.length<1||inorder.length<1){
            return null;
        }
        for (int i = 0; i < inorder.length; i++) {
            map.put(inorder[i],i);
        }
        return  help(preorder,0,preorder.length-1,0,inorder.length-1);
    }
    private TreeNode help(int[] preorder,int startP,int endP,int startI,int endI){
        if(startP==endP){
            return new TreeNode(preorder[startP]);
        }
        //根据前序遍历的第一个元素获取根节点的值，然后从Map中获取根节点对应在中序遍历的位置
        int rootIndex = map.get(preorder[startP]);
        //生成当前的根节点
        TreeNode  root = new TreeNode(preorder[startP]);
        //计算左子树对应前序遍历的长度
        int ll =rootIndex-startI;
        int rlen =endI-rootIndex;

        if(ll>0){
            //递归得到左子树
            root.left=help(preorder,startP+1,startP+ll,startI,rootIndex-1);
        }
        if(rlen>0){
            //递归得到右子树
            root.right=help(preorder,startP+ll+1,endP,rootIndex+1,endI);
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
