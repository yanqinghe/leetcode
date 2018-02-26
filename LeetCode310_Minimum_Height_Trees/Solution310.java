import java.util.*;

public class Solution310 {
    public static void main(String[] args) {
        Solution310 solution310 = new Solution310();
        solution310.findMinHeightTrees(6,new int[][]{{0, 3}, {1, 3}, {2, 3}, {4, 3}, {5, 4}});
    }

    /**
     * 这个思路实际上是一个 BFS 思路。和常见的从根节点进行 BFS 不同，这里从叶子节点开始进行 BFS。

     所有入度（即相连边数）为 1 的节点即是叶子节点。找高度最小的节点，即找离所有叶子节点最远的节点，也即找最中心的节点。

     找最中心的节点的思路很简单：

     每次去掉当前图的所有叶子节点，重复此操作直到只剩下最后的根
     * @param n
     * @param edges
     * @return
     */
    public List<Integer> findMinHeightTrees(int n, int[][] edges) {
        if (n == 1) return Collections.singletonList(0);
        //叶节点
        List<Integer> leaves = new ArrayList<>();
        //路径
        List<Set<Integer>> adj = new ArrayList<>(n);
        //初始化所有节点可以到达的节点Set
        for (int i = 0; i < n; ++i) adj.add(new HashSet<>());
        for (int[] edge : edges) {
            //题目给定的步长为1的节点
            adj.get(edge[0]).add(edge[1]);
            adj.get(edge[1]).add(edge[0]);
        }
        for (int i = 0; i < n; ++i) {
            //如果是题目给定的节点，那么添加入叶节点当中
            if (adj.get(i).size() == 1) leaves.add(i);
        }
        while (n > 2) {
            n -= leaves.size();
            List<Integer> newLeaves = new ArrayList<>();
            for (int i : leaves) {
                int t = adj.get(i).iterator().next();
                adj.get(t).remove(i);
                if (adj.get(t).size() == 1) newLeaves.add(t);
            }
            leaves = newLeaves;
        }
        return leaves;
    }
}
