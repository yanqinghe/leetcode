import java.util.ArrayList;
import java.util.List;

public class Solution501 {
     class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode(int x) { val = x; }
  }
    public int[] findMode(TreeNode root) {
         if(root==null) return new int[0];
         List<Integer> list = new ArrayList<>();
         dfs(root,list);
         List<Integer> ret = new ArrayList<>();
         int maxCnt =0;
         int cnt =1;
         list.add(list.get(list.size()-1)+1);
         int pre = list.get(0);
         list.remove(0);
        for (Integer cur : list) {
            if(cur!=pre){
                if(cnt>=maxCnt){
                    if(cnt>maxCnt){
                        maxCnt=cnt;
                        ret.clear();
                    }
                    ret.add(pre);
                }
                cnt=1;
                pre=cur;
            }else {
                cnt++;
            }
        }
        int[] res = new int[ret.size()];
        int i =0;
        for (Integer integer : ret) {
            res[i++] = integer;
        }
        return res;
    }
    void dfs(TreeNode treeNode, List<Integer> list){
         if(treeNode==null) return;
         dfs(treeNode.left,list);
         list.add(treeNode.val);
         dfs(treeNode.right,list);

    }
}
