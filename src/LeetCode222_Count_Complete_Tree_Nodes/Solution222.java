public class Solution222 {
    public int countNodes(TreeNode root) {
        if(root==null) return 0;
        //统计左右子数的层高
        int left= countTreeLvl(root.left);
        int right = countTreeLvl(root.right);
        if(left==right){
            //如果左右子树的层高相同，说明左子树为满二叉树，计算左子树的节点数，然后递归计算右子树
            return (1<<left)+countNodes(root.right);
        }else {
            //如果两者不同，说明右子树为满二叉树，递归计算左子树
            return (1<<right)+countNodes(root.left);
        }

    }
    int countTreeLvl(TreeNode root){
        if(root==null) return 0;
        int count =0;
        while (!(root==null)){
            count++;
            root=root.left;
        }
        return count;
    }
     public class TreeNode {
     int val;
     TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
  }
}
