import java.util.*;

public class Solution802 {
    public static void main(String[] args) {
        Solution802 solution802 = new Solution802();
        solution802.eventualSafeNodes(new int[][]{{},{0,2,3,4},{3},{4},{}});
    }

    public List<Integer> eventualSafeNodes(int[][] graph) {
        List<Integer> res= new ArrayList<>();
        boolean[] set = new boolean[graph.length];
        for(int i =0;i<graph.length;i++){
            if(!set[i]){
                Stack<Set<Integer>> paths  = new Stack<>();
                Stack<Integer> stack = new Stack<>();
                Set<Integer> set1 = new HashSet<>();
                set1.add(i);
                paths.add(set1);
                stack.add(i);
                while (!stack.isEmpty()){
                    Set<Integer> path = paths.pop();
                    int curNode  = stack.pop();
                    if(graph[curNode].length>0){
                        for (int nextNode : graph[curNode]) {
                            if(set[nextNode]||path.contains(nextNode)){
                                for (Integer integer : path) {
                                    set[integer]=true;
                                }
                            }else {
                                Set<Integer> temp = new HashSet<>(path);
                                temp.add(nextNode);
                                paths.add(temp);
                                stack.add(nextNode);
                            }
                        }
                    }
                }
            }
        }
        for(int i =0;i<graph.length;i++){
            if(!set[i]) res.add(i);
        }
        return res;
    }

    List<Integer> res = new ArrayList<>();
    void dfs(int[][] graph, int node,Set<Integer> path){
        if(graph[node].length<1){
            //如果当前路径结束且未出现环
            res.addAll(path);
        }else {
            for (int i : graph[node]) {
                if(path.contains(i)){
                    //如果出现环，说明改路径所有节点都有问题。
                }else {
                    //如果暂时未出现环,继续深入
                    path.add(i);
                    dfs(graph,i,path);
                    path.remove(i);
                }
            }
        }
    }
}
