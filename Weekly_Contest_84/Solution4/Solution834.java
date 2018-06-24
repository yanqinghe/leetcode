import org.omg.CORBA.INTERNAL;

import java.util.*;
import java.util.stream.Collector;
import java.util.stream.Collectors;

public class Solution834 {
    public static void main(String[] args) {
        Solution834 solution834 = new Solution834();
        solution834.sumOfDistancesInTree(3,new int[][]{
                {2,0},{1,0}
        });
    }
    class Node{
        int parent=-1;
        List<Integer> children = new ArrayList<>();
        int val;
        public Node(int val) {
            this.val = val;
        }
    }
    int[][] dj;
    public int[] sumOfDistancesInTree(int N, int[][] edges) {
        dj = new int[N][N];
        Node[] nodes = new Node[N];
        for (int i = 0; i < N; i++) {
            nodes[i]= new Node(i);
        }
        for (int[] edge : edges) {
            nodes[edge[0]].children.add(edge[1]);
            nodes[edge[1]].parent=edge[0];
        }
        Node root = Arrays.stream(nodes).filter(node -> node.parent==-1).collect(Collectors.toList()).get(0);
        dfs(new ArrayList<>(),root,nodes);
        Set<Integer> gSet = new HashSet<>();
        gSet.add(root.val);
        for (int i = 0; i < N; i++) {
            gSet.add(i);
            Set<Integer> lSet = new HashSet<>(nodes[i].children);
                Node curNode = nodes[i];
                while (curNode.parent!=-1){
                    curNode=nodes[curNode.parent];
                    for (int j = 0; j < N; j++) {
                        if(gSet.contains(j)||lSet.contains(j)) continue;
                        dj[i][j]=dj[i][curNode.val]+dj[curNode.val][j];
                        dj[j][i]= dj[i][j];
                        lSet.add(j);
                    }
                }
        }
        int[] res = new int[N];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                res[i]+=dj[i][j];
            }
        }

        return res;
    }

    private void  dfs(List<Node> parents,Node curNode,Node[] nodes){
       int cnt =parents.size();
        for (Node parent : parents) {
            dj[parent.val][curNode.val]=cnt;
            dj[curNode.val][parent.val]=cnt;
            cnt--;
        }
        parents.add(curNode);
        for (Integer child : curNode.children) {
            dfs(parents,nodes[child],nodes);
        }
        parents.remove(parents.size()-1);
    }
}
