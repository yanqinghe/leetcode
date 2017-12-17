package LeetCode216_Combination_Sum_III;

import java.util.ArrayList;
import java.util.List;

public class Solution216 {
    public List<List<Integer>> combinationSum3(int k, int n) {
        List<List<Integer>> res = new ArrayList<>();
        getList(res,new ArrayList(),0,n,Math.min(n,10),k);
        return res;
    }
    void getList(List<List<Integer>> res,ArrayList<Integer> list,int i,int target,int n ,int k ){
        if(target==0&&list.size()==k) res.add(new ArrayList<Integer>(list));
        else{
            for (int j = i+1; j < n && j<=target; j++) {
                list.add(j);
                getList(res,list,j,target-j,n,k);
                list.remove(list.size()-1);
            }
        }
    }

}
