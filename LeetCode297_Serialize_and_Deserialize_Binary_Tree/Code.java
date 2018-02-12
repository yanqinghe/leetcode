import java.util.ArrayList;
import java.util.Queue;
import java.util.Stack;

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Codec {
    private final String delimiter = ",";
    private final String emptyNode = "#";
    
    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {            
        StringBuilder sb = new StringBuilder();
        serialize(root, sb);
        return sb.toString();
    }
    
    private void serialize(TreeNode root, StringBuilder sb) {
        if(root == null) {
            sb.append(emptyNode).append(delimiter);
        } else {
            sb.append(root.val).append(delimiter);
            serialize(root.left, sb);
            serialize(root.right, sb);
        }
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        Deque<String> nodes = new LinkedList<>();
        nodes.addAll(Arrays.asList(data.split(delimiter)));
        return deserialize(nodes);
    }
    
    private TreeNode deserialize(Deque<String> nodes) {
        String nodeVal = nodes.pollFirst();
        if(nodeVal.equals(emptyNode)) {
            return null;
        } else {
            TreeNode node = new TreeNode(Integer.parseInt(nodeVal));
            node.left = deserialize(nodes);
            node.right = deserialize(nodes);
            return node;
        }
    }
    
}

class TreeNode {
         int val;
         TreeNode left;
         TreeNode right;
         TreeNode(int x) { val = x; }
    }

// Your Codec object will be instantiated and called as such:
// Codec codec = new Codec();
// codec.deserialize(codec.serialize(root));