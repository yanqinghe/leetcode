
import java.util.*;

public class Solution207 {
    public static void main(String[] args) {
        Solution207 solution207 = new Solution207();
        solution207.canFinish(2,new int[][]{{1,0},{0,1}});
    }
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        //初始化List
       List<List<Integer>> list = new ArrayList<>(numCourses);
        for (int i = 0; i <numCourses ; i++) {
            list.add(new ArrayList<>());
        }
        //给每个节点添加子节点
       for (int[] array: prerequisites
             ) {
            list.get(array[0]).add(array[1]);
        }
        //初始化全局已访问节点数组
        boolean[] visitedPre = new boolean[numCourses];
        for (int i = 0; i < numCourses; i++) {
            //当全局未访问，对该节点的路径进行递归，如果错误，返回false，否则继续
            if(!visitedPre[i]&&!help(i,list,new boolean[numCourses],visitedPre)) return false;
        }
        //全部路径搜寻完毕，没有环状路径
        return true;

    }
    boolean help(int from,List<List<Integer>> lists,boolean[] visited,boolean[] visitedPre){
        //如果当前节点全局未访问
        if(!visitedPre[from]){
            //当前节点设为该路径的未访问
            visited[from]=true;
            //遍历子节点
            for (int nextFrom: lists.get(from)){
                //如果该该节点出现在该路径重复出现，说明出环，返回false
                if(visited[nextFrom]||!visitedPre[nextFrom]&&!help(nextFrom,lists,visited,visitedPre))
                    return  false;
            }
            //将路径数组恢复
            visited[from] = false;
            //将该节点设为全局已访问
            visitedPre[from]=true;

        }
        return true;

    }
}
