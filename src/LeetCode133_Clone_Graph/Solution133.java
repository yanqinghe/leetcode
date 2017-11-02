package LeetCode133_Clone_Graph;

import java.util.*;

public class Solution133 {
    /**
     * Definition for undirected graph.
     * class UndirectedGraphNode {
     *     int label;
     *     List<UndirectedGraphNode> neighbors;
     *     UndirectedGraphNode(int x) { label = x; neighbors = new ArrayList<UndirectedGraphNode>(); }
     * };
     */
    //广度优先搜索
    public UndirectedGraphNode cloneGraph(UndirectedGraphNode node) {
        if(node==null)
            return null;
        HashMap<UndirectedGraphNode,UndirectedGraphNode> map = new HashMap<>();
        UndirectedGraphNode myNode = new UndirectedGraphNode(node.label);
        Queue<UndirectedGraphNode> queue = new ArrayDeque<>();
        map.put(node,myNode);
        queue.add(node);
        while (!queue.isEmpty()){
            UndirectedGraphNode curNode = queue.poll();
            for (UndirectedGraphNode neighbor: curNode.neighbors
                 ) {
                if(!map.containsKey(neighbor)){
                    myNode = new UndirectedGraphNode(neighbor.label);
                    map.put(neighbor,myNode);
                    queue.offer(neighbor);
                }
                map.get(curNode).neighbors.add(map.get(neighbor));
            }
        }
        return map.get(node);
    }

    /**
     * 图的深度搜索
     * @param node
     * @return
     */
    public UndirectedGraphNode cloneGraph2(UndirectedGraphNode node) {
        if(node==null)
            return null;
        HashMap<UndirectedGraphNode,UndirectedGraphNode> map = new HashMap<>();
        UndirectedGraphNode myNode = new UndirectedGraphNode(node.label);
        Stack<UndirectedGraphNode> stack = new Stack<>();
        map.put(node,myNode);
        stack.add(node);
        while (!stack.isEmpty()){
            UndirectedGraphNode curNode = stack.pop();
            for (UndirectedGraphNode neighbor: curNode.neighbors
                    ) {
                if(!map.containsKey(neighbor)){
                    myNode = new UndirectedGraphNode(neighbor.label);
                    map.put(neighbor,myNode);
                    stack.add(neighbor);
                }
                map.get(curNode).neighbors.add(map.get(neighbor));
            }
        }
        return map.get(node);
    }

    /**
     * 图的深度优先算法，利用递归方式。
     * @param node
     * @return
     */
    public UndirectedGraphNode cloneGraph3(UndirectedGraphNode node) {
       return dfs(node,new HashMap<>());
    }
    private UndirectedGraphNode dfs(UndirectedGraphNode node, Map<UndirectedGraphNode, UndirectedGraphNode> map){
            if(node==null){
                return null;
            }
            if(map.containsKey(node)){
                return map.get(node);
            }
            UndirectedGraphNode copy  = new UndirectedGraphNode(node.label);
            map.put(node,copy);
        for (UndirectedGraphNode neighbor:
             node.neighbors) {
            copy.neighbors.add(dfs(neighbor,map));
        }
        return copy;
    }

  class UndirectedGraphNode {
      int label;
      List<UndirectedGraphNode> neighbors;
      UndirectedGraphNode(int x) { label = x; neighbors = new ArrayList<UndirectedGraphNode>();
      }
};
}
