package Weekly_Contest_62;

import java.util.*;

public class Solution743 {

    public int networkDelayTime(int[][] times, int N, int K) {
        //遍历数组，生成node对象
        List<Node> nodes = new ArrayList<>(N);
        for (int i = 0; i < N; i++) {
            Node node  = new Node();
            node.time=Integer.MAX_VALUE;
            nodes.add(node);
        }
        //建立node之间的连接关系
        for (int i = 0; i < times.length; i++) {
            nodes.get(times[i][0]-1).nextNode.put(nodes.get(times[i][1]-1),times[i][2]);
        }
        //使用Queue对图进行广度遍历
        int max = 0;
        Set<Node> hashSet = new HashSet<>();
        Queue<Node> queue = new ArrayDeque<>();
        Node firs = nodes.get(K-1);
        firs.time=0;
        queue.add(nodes.get(K-1));
        while (!queue.isEmpty()){
            Node node = queue.remove();
            hashSet.add(node);
            if(!node.nextNode.isEmpty()){
                //遍历当前元素的子元素
                for (Node child:node.nextNode.keySet()
                        ) {
                    //分别计算当前元素到子元素的时间
                    int time = node.time+node.nextNode.get(child);
                    if(child.time>time){
                        //如果子元素点亮时间出现最小值，那么更新子元素的点亮时间
                        child.time=time;
                        queue.add(child);
                    }
                    if(max==time){

                    }
                }
            }
        }
        if(hashSet.size()<N) return -1;
        else {
            for (Node node: nodes
                 ) {
                max=Math.max(node.time,max);
            }
            return max;
        }
    }
    class Node{
        private int time;
        private Map<Node,Integer> nextNode =new HashMap<>();
    }

}
