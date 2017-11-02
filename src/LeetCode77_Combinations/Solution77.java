package LeetCode77_Combinations;

import java.util.LinkedList;
import java.util.List;

public class Solution77 {

    List<List<Integer>> result = new LinkedList<>();

    public List<List<Integer>> combine(int n, int k) {
        if(n==0||k==0){
            return result;
        }
        help(new LinkedList<>(),1,0,k,n);
        return result;
    }


    private void help(List<Integer> list ,int from,int l,int k,int n){
        if(l==k){
            //如果到了最后一层
            result.add(new LinkedList<>(list));
        }else {
            for (int i = from; i <= n; i++) {
                list.add(i);
                help(list,i+1,l+1,k,n);
                list.remove(list.size()-1);
            }
        }
    }
}
