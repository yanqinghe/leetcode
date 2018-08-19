import org.omg.CORBA.INTERNAL;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Solution889 {
    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public static void main(String[] args) {
        Solution889 solution889 = new Solution889();
        solution889.constructFromPrePost(new int[]{2,1}, new int[]{1,2});
    }

    public TreeNode constructFromPrePost(int[] pre, int[] post) {
        TreeNode root = new TreeNode(pre[0]);
        int len = post.length;
        if (len > 1) {
            Map<Integer, Integer> preMap = new HashMap<>();
            Map<Integer, Integer> postMap = new HashMap<>();
            for (int i = 0; i < pre.length; i++) {
                preMap.put(pre[i], i);
                postMap.put(post[i], i);
            }
            buildTree(0, pre, post.length - 1, post, preMap, postMap, new HashSet<>(), root);
        }

        return root;
    }

    private void buildTree(int preIndex, int[] pre, int postIndex, int[] post,
                           Map<Integer, Integer> preMap, Map<Integer, Integer> postMap,
                           Set<Integer> set, TreeNode treeNode) {
        if (preIndex < pre.length - 1) {
            int left = pre[preIndex + 1];
            if (!set.contains(left)) {
                treeNode.left = new TreeNode(left);
                set.add(left);
            }
        }
        if (postIndex > 0) {
            int right = post[postIndex - 1];
            if (!set.contains(right)) {
                set.add(right);
                treeNode.right = new TreeNode(right);
            }
        }
        if (treeNode.left != null)
            buildTree(preIndex + 1, pre, postMap.get(treeNode.left.val), post, preMap, postMap, set, treeNode.left);
        if (treeNode.right != null)
            buildTree(preMap.get(treeNode.right.val), pre, postIndex - 1, post, preMap, postMap, set, treeNode.right);
    }
//    private TreeNode buildTree(2int preIndex, int[] pre, int postIndex, int[] post,
//                               Map<Integer,Integer> preMap, Map<Integer,Integer> postMap
//    ){
//        TreeNode treeNode = new TreeNode(pre[preIndex]);
//        int leftPreIndex = preIndex+1;
//        if(leftPreIndex<pre.length-1){
//            int leftVal = pre[leftPreIndex];
//            int leftPostIndex = postMap.get(leftVal);
//            if(postIndex>leftPostIndex){
//                treeNode.left = buildTree(leftPreIndex,pre,leftPostIndex,post,preMap,postMap);
//            }
//        }
//        int rightPostIndex = postIndex-1;
//        if(rightPostIndex>0){
//            int rightVal = post[rightPostIndex];
//            int rightPreIndex = preMap.get(rightVal);
//            if(rightPreIndex>preIndex){
//                treeNode.right = buildTree(rightPreIndex,pre,rightPostIndex,post,preMap,postMap);
//            }
//        }
//        return treeNode;
//    }
//}
}
