package Combination_Sum_39;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution39 {
    List<List<Integer>> result = new ArrayList<List<Integer>>();

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        // 首先对候选数组进行排序操作
        Arrays.sort(candidates);
        getList(new ArrayList(),candidates,0,target);
        return result;
    }
    public void getList(List<Integer> list,int[] candidates,int i,int target){
        if(target==0){
            List<Integer> arrayList = new ArrayList<Integer>(list);
            result.add(arrayList);
        }else{
            for(int j=i;j<candidates.length && candidates[j]<=target;j++){
                list.add(candidates[j]);
                getList(list,candidates,j,target-candidates[j]);
                list.remove(list.size()-1);
            }
        }

    }
}
