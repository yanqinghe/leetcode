import java.lang.reflect.Array;
import java.util.*;

public class Solution870 {
    public static void main(String[] args) {
        Solution870 solution870 = new Solution870();
        System.out.println(solution870.advantageCount(new int[]{
                2,7,11,15        },new int[]{
                1,10,4,11
        }));
    }
    class Node{
        int val =0;
        int index=0;
        boolean type = false;
        public Node(int val, int index,boolean type) {
            this.val = val;
            this.index = index;
            this.type=type;
        }
    }
    public int[] advantageCount(int[] A, int[] B) {
        PriorityQueue<Node> queue = new PriorityQueue<>(new Comparator<Node>() {
            @Override
            public int compare(Node o1, Node o2) {
                return o1.val-o2.val;
            }
        });
        int len = A.length;
        for (int i = 0; i < len; i++) {
            queue.add(new Node(A[i],i,true));
            queue.add(new Node(B[i],i,false));
        }
        int[] ints = new int[len];
        Queue<Integer> none = new ArrayDeque<>();
        while (!queue.isEmpty()){
            Node cur = queue.poll();
            if(cur.type){
                none.add(cur.val);
            }else {
                Queue<Node> temp = new ArrayDeque<>();
                while (!queue.isEmpty()){
                    if(queue.peek().type&&queue.peek().val>cur.val){
                        ints[cur.index]=queue.poll().val;
                        break;
                    }else {
                        temp.add(queue.poll());
                    }
                }
                while (!temp.isEmpty()){
                    queue.add(temp.poll());
                }
            }
        }
        for (int i = 0; i < len; i++) {
            if(ints[i]==0) ints[i]=none.poll();
        }
        return ints;
    }
}
