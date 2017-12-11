package Weekly_Contest_62;

import com.sun.org.apache.regexp.internal.RE;

import java.util.*;

public class Solution742 {

    public int findClosestLeaf(TreeNode root, int k) {
        //失效
        if(root == null)
            return 0;
        //如果只有一个，直接返回
        if(root.val==k&&root.left==null&&root.right==null) return k;

        MyNode pathTree = initPathTree(root);
        MyNode myNode = findK(root,pathTree,k);


        return myNode.leafNode.val;
    }
    MyNode findK(TreeNode root,MyNode myNode,int k){
        if(root==null) return null;
        if(root.val==k){
            //如果当前节点是k，那么执行操作
            return myNode;
        }else {
            MyNode node =findK(root.left,myNode.left,k);
            if(node!=null){
                if(node.path>myNode.path+1){
                    myNode.path+=1;
                    return myNode;
                }else {
                    return node;
                }
            }
            node = findK(root.right,myNode.right,k);
            if(node!=null) {
                if(node.path>myNode.path+1){
                    myNode.path+=1;
                    return myNode;
                }else {
                    return node;
                }
            }
        }
        return null;
    }
    MyNode initPathTree(TreeNode root){
        MyNode myNode = new MyNode();
        myNode.leafNode = root;
        if(root.left!=null){
            myNode.left = initPathTree(root.left);
            myNode.path=myNode.left.path+1;
            myNode.leafNode = myNode.left.leafNode;
        }
        if(root.right!=null){
            myNode.right = initPathTree(root.right);
            //如果左边为空，或者左边的大于右边的，那么就赋值右边的
            if(myNode.path==0||myNode.path>myNode.right.path+1){
                myNode.path=myNode.right.path+1;
                myNode.leafNode = myNode.right.leafNode;
            }
        }
        return  myNode;
    }
    int findMinPath(TreeNode root){
        if(root==null) return 0;
        return Math.min(findMinPath(root.left),findMinPath(root.right))+1;
    }
    class MyNode {
        int path;
        TreeNode leafNode;
        MyNode left;
        MyNode right;

    }
      class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }
}
