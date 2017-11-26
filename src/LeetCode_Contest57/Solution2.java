package LeetCode_Contest57;

import org.w3c.dom.ls.LSException;

import java.util.*;

public class Solution2 {

    public static void main(String[] args) {
        Solution2 solution2 = new Solution2();
        List<List<String>> res = new ArrayList<>();
        res.add(new ArrayList<String>(){{
            add("Hanzo");
            add("Hanzo2@m.co");
            add("Hanzo3@m.co");
        }});
        res.add(new ArrayList<String>(){{
            add("Hanzo");
            add("Hanzo4@m.co");
            add("Hanzo5@m.co");
        }});
        res.add(new ArrayList<String>(){{
            add("Hanzo");
            add("Hanzo0@m.co");
            add("Hanzo1@m.co");
        }});
        res.add(new ArrayList<String>(){{
            add("Hanzo");
            add("Hanzo3@m.co");
            add("Hanzo4@m.co");
        }});
        res.add(new ArrayList<String>(){{
            add("Hanzo");
            add("Hanzo7@m.co");
            add("Hanzo8@m.co");
        }});

        res.add(new ArrayList<String>(){{
            add("Hanzo");
            add("Hanzo1@m.co");
            add("Hanzo2@m.co");
        }});
        res.add(new ArrayList<String>(){{
            add("Hanzo");
            add("Hanzo6@m.co");
            add("Hanzo7@m.co");
        }});
        res.add(new ArrayList<String>(){{
            add("Hanzo");
            add("Hanzo5@m.co");
            add("Hanzo6@m.co");
        }});
        solution2.accountsMerge(res);
    }
    class Person{
        User User;
        public Person(String username) {
            this.User= new User(username);
        }
    }
    class User{
        String username;

        public User(String username) {
            this.username = username;
        }
    }
    class ListNode{
        List<ListNode> listNodes=new ArrayList<>();
        String mail;
        String username;
        public ListNode(String mail,String username) {
            this.mail = mail;
            this.username = username;
        }
    }
    public List<List<String>> accountsMerge(List<List<String>> accounts) {
        Map<String,ListNode> map = new HashMap<>();

        for (List<String> account:accounts
             ) {
            String username =account.remove(0);
            ListNode node =null;
            for (String mail:account
                 ) {
                ListNode temp = null;
                if(map.containsKey(mail)){
                    temp = map.get(mail);
                }else {
                    temp=new ListNode(mail,username);
                    map.put(mail,temp);
                }
                if(node!=null){
                    node.listNodes.add(temp);
                    temp.listNodes.add(node);

                }
                node=temp;
            }
        }
        Set<String> used = new HashSet<>();
        Stack<String> stack = new Stack<>();
        List<List<String>> res = new ArrayList<>();
        for (String key:map.keySet()
             ) {
            if(used.contains(key)){
                continue;
            }
            stack.add(key);
            used.add(key);
            List<String> list = new ArrayList<>();
            list.add(map.get(key).username);
            list.add(key);
            while (!stack.isEmpty()){
                String mail = stack.pop();
                for (ListNode node:map.get(mail).listNodes
                     ) {
                    if(!used.contains(node.mail)){
                        stack.add(node.mail);
                        used.add(node.mail);
                        list.add(node.mail);
                    }
                }
            }
            Collections.sort(list);
            res.add(list);
        }
        return res;
    }
}
