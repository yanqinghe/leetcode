import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class Solution797 {
    public List<List<Integer>> allPathsSourceTarget(int[][] graph) {
        List<List<Integer>> res=  new ArrayList<>();
        Stack<List<Integer>> stack = new Stack<>();
        List<Integer> zero = new ArrayList<>();
        zero.add(0);
        stack.push(zero);
        while (!stack.isEmpty()){
            List<Integer> curPath = stack.pop();
            Integer curNode = curPath.get(curPath.size()-1);
            if(curNode==graph.length-1){
                //如果到最后的节点。
                res.add(new ArrayList<>(curPath));
            }else {
                //如果没有到最后的节点
                for(int i =0;i<graph[curNode].length;i++){
                    List<Integer> temp = new ArrayList<>(curPath);
                    temp.add(graph[curNode][i]);
                    stack.push(temp);
                }
            }
        }
        return res;
    }
}
