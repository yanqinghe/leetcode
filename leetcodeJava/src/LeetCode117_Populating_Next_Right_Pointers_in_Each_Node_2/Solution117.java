package LeetCode117_Populating_Next_Right_Pointers_in_Each_Node_2;

public class Solution117 {
    public static void main(String[] args) {
        Solution117 solution117 = new Solution117();
        solution117.test();
    }
    private void  test(){

        TreeLinkNode treeLinkNode = new TreeLinkNode(1);
        treeLinkNode.left = new TreeLinkNode(2);
        treeLinkNode.left.right= new TreeLinkNode(4);
        treeLinkNode.left.right.left = new TreeLinkNode(5);
        treeLinkNode.right = new TreeLinkNode(3);
        connect(treeLinkNode);
        return;
    }
    public void connect(TreeLinkNode root) {
        if(root==null) return;
        TreeLinkNode node = root;
        root.next = null;
        while(node!=null){
            TreeLinkNode cNode = node;
            TreeLinkNode pre = new TreeLinkNode(0);
            while(cNode!=null){
                if(cNode.left!=null){
                    pre.next=cNode.left;
                    if(cNode.right!=null){
                        cNode.left.next=cNode.right;
                        pre=cNode.right;
                    }else {
                        pre=cNode.left;
                    }
                }else {
                    if(cNode.right!=null){
                        pre.next=cNode.right;
                        pre=cNode.right;
                    }

                }
                cNode=cNode.next;
            }
            while(node.left==null&&node.right==null){
                node = node.next;
                if(node==null){
                    return;
                }
            }
            if(node.left!=null){
                node=node.left;
            }else {
                node=node.right;
            }
        }

    }
    class TreeLinkNode {
        int val;
        TreeLinkNode left, right, next;

        TreeLinkNode(int x) {
            val = x;
        }
    }
}
