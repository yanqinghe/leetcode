package LeetCode146_LRU_Cache;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LRUCache {
    Map<Integer,Node> map = new HashMap<>();
    int capacity;
    int size = 0;
    Node head = new Node(0,0);
    Node end = null;
    public LRUCache(int capacity) {
        this.capacity=capacity;
    }

    public int get(int key) {
        if(map.containsKey(key)){
            //如果存在，需要调整近期使用顺序
            Node temp = map.get(key);
            if(temp.next!=null){
                //链接temp前后的node
                temp.pre.next=temp.next;
                temp.next.pre=temp.pre;
                temp.next=null;
                //将temp与末尾链接
                end.next=temp;
                temp.pre=end;
                //末尾为temp
                end =temp;
            }
            //如果temp.next为空，说明temp已经在末尾了,不需要改变
            return temp.value;

        }else {
            return -1;
        }
    }

    public void put(int key, int value) {
        if(map.size()==0){
            end=new Node(key,value);
            head.next=end;
            end.pre=head;
            map.put(key,end);
        }else {
            if(map.containsKey(key)){
                this.get(key);
                map.get(key).value=value;
            }else {
                end.next=new Node(key,value);
                end.next.pre=end;
                end=end.next;
                if(map.size()==capacity){
                    //如果当前容量已满
                    //找到最前面的
                    Node temp = head.next;
                    //从map中删掉
                    map.remove(temp.key);
                    head.next=temp.next;
                    temp.next.pre=head;
                }
                map.put(key,end);
            }

        }
    }
    class Node{
        int key;
        int value;
        Node pre;
        Node next;
        public Node(int key,int value) {
            this.key=key;
            this.value = value;
        }
    }
}
