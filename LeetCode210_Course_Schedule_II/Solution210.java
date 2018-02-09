
import java.util.*;

public class Solution210 {
    public static void main(String[] args) {
        Solution210 solution210 = new Solution210();
        solution210.findOrder(3,new int[][]{{0,1},{0,2},{1,2}});
    }
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        //初始化节点数组
        List<Integer>[] nodes = new ArrayList[numCourses];
        //
        int[] isReq = new int[numCourses];
        for (int i = 0; i < numCourses; i++) {
            nodes[i]=new ArrayList<>();
        }
        //初始化节点之间的关系
        //isReq代表是否是别的节点的前提

        for (int[] prerequisite : prerequisites
                ) {
            nodes[prerequisite[0]].add(prerequisite[1]);
            isReq[prerequisite[1]]++;
        }
        Queue<Integer> queue = new ArrayDeque<>();
        for (int i = 0; i <numCourses ; i++) {
            if(isReq[i]==0) queue.add(i);
        }
        int [] res = new int[numCourses];
        int count = numCourses-1;
        while (!queue.isEmpty()){
            int temp = queue.remove();
            res[count--]=temp;
            for (Integer child:nodes[temp]){
                isReq[child]--;
                if(isReq[child]==0) queue.add(child);
            }
        }
        if(count!=-1) return new int[0];
        return res;
    }


}
