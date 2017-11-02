package LeetCode138_Copy_List_with_Random_Pointer;

import java.util.*;

public class Solution138 {
    /**
     * Definition for singly-linked list with a random pointer.
     * class RandomListNode {
     * int label;
     * RandomListNode next, random;
     * RandomListNode(int x) { this.label = x; }
     * };
     */
    public RandomListNode copyRandomList(RandomListNode head) {
        if (head == null) return null;
        HashMap<RandomListNode, RandomListNode> map = new HashMap<>();
        Stack<RandomListNode> stack = new Stack<>();
        Set<RandomListNode> used = new HashSet<>();
        stack.add(head);
        RandomListNode node = new RandomListNode(head.label);
        RandomListNode res = node;
        map.put(head, node);
        used.add(head);
        while (!stack.isEmpty()) {
            head = stack.pop();
            node = map.get(head);
            if (head.next != null) {
                if (!map.containsKey(head.next)) {
                    map.put(head.next, new RandomListNode(head.next.label));
                }
                node.next = map.get(head.next);
                if (!used.contains(head.next)) {
                    stack.add(head.next);
                    used.add(head.next);
                }

            }
            if (head.random != null) {
                if (!map.containsKey(head.random)) {
                    map.put(head.random, new RandomListNode(head.random.label));
                }
                node.random = map.get(head.random);
                if (!used.contains(head.random)) {
                    stack.add(head.random);
                    used.add(head.random);
                }
            }
        }
        return res;
    }

    class RandomListNode {
        int label;
        RandomListNode next, random;

        RandomListNode(int x) {
            this.label = x;
        }
    }

    ;
}
