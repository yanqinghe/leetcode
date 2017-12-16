
public class Solution108 {
    public TreeNode sortedArrayToBST(int[] nums) {
        return help(nums, 0, nums.length - 1);
    }

    private TreeNode help(int[] nums, int l, int r) {
        if (l > r) {
            return null;
        }
        int mid = (l + r) >> 1;
        TreeNode root = new TreeNode(nums[mid]);
        root.left = help(nums, l, mid - 1);
        root.right = help(nums, mid + 1, r);
        return root;
    }

    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }
}
