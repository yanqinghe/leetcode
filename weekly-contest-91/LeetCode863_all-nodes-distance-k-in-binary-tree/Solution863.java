import java.util.*;

public class Solution863 {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }
    private class Node {

        List<Node> nextNodes = new ArrayList<>();
        int val;
        int dis =0;
        Node(int val) {
            this.val = val;
        }
    }

    Node targetNode =null;
    public List<Integer> distanceK(TreeNode root, TreeNode target, int K) {
        if(K==0) return Collections.singletonList(target.val);
        List<Integer> res = new ArrayList<>();
        pre(root,null,target.val);
        Set<Integer> set = new HashSet<>();
        Queue<Node>queue = new ArrayDeque<>();
        queue.offer(targetNode);
        set.add(target.val);
        while (!queue.isEmpty()){
            Node cur = queue.poll();
            for (Node nextNode : cur.nextNodes) {
                if(!set.contains(nextNode.val)){
                    nextNode.dis=cur.dis+1;
                    queue.offer(nextNode);
                    set.add(nextNode.val);
                    if(nextNode.dis==K)
                        res.add(nextNode.val);
                }
            }
        }
        return  res;

    }
    void pre(TreeNode cur,Node parent,int val){
        Node node = new Node(cur.val);
        if(cur.val==val) targetNode=node;
        if(parent!=null){
            node.nextNodes.add(parent);
            parent.nextNodes.add(node);
        }
        if(cur.left!=null){
            pre(cur.left,node,val);
        }
        if(cur.right!=null){
            pre(cur.right,node,val);
        }
    }
}
