package LeetCode18_Four_Sum_18;
import java.util.*;

/**
 * Created by yanqinghe on 2017/7/16.
 */
public class Solution18 {
    public static void main(String[] args) {
        Solution18 solution = new Solution18();
//        int[] arr={-5,5,4,-3,0,0,4,-2};
        int[] arr = {-3, -2, -1, 0, 0, 1,2,3};
//        int[] arr = {0,0,0,0};
//        int[] arr = {1, 0, -1, 0, -2, 2};
//        int[] arr={0,0,0};
        System.out.print(solution.fourSum(arr, 0));
    }
    public List<List<Integer>> fourSum(int[] num, int target) {
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        if(num==null||num.length==0)
            return res;
        Arrays.sort(num);
        for(int i=num.length-1;i>2;i--)
        {
            if(i==num.length-1 || num[i]!=num[i+1])
            {
                ArrayList<ArrayList<Integer>> curRes = threeSum(num,i-1,target-num[i]);
                for(int j=0;j<curRes.size();j++)
                {
                    curRes.get(j).add(num[i]);
                }
                res.addAll(curRes);
            }
        }
        return res;
    }
    private ArrayList<ArrayList<Integer>> threeSum(int[] num, int end, int target)
    {
        ArrayList<ArrayList<Integer>> res = new ArrayList<ArrayList<Integer>>();
        for(int i=end;i>1;i--)
        {
            if(i==end || num[i]!=num[i+1])
            {
                ArrayList<ArrayList<Integer>> curRes = twoSum(num,i-1,target-num[i]);
                for(int j=0;j<curRes.size();j++)
                {
                    curRes.get(j).add(num[i]);
                }
                res.addAll(curRes);
            }
        }
        return res;
    }
    private ArrayList<ArrayList<Integer>> twoSum(int[] num, int end, int target)
    {
        ArrayList<ArrayList<Integer>> res = new ArrayList<ArrayList<Integer>>();
        int l=0;
        int r=end;
        while(l<r)
        {
            if(num[l]+num[r]==target)
            {
                ArrayList<Integer> item = new ArrayList<Integer>();
                item.add(num[l]);
                item.add(num[r]);
                res.add(item);
                l++;
                r--;
                while(l<r&&num[l]==num[l-1])
                    l++;
                while(l<r&&num[r]==num[r+1])
                    r--;
            }
            else if(num[l]+num[r]>target)
            {
                r--;
            }
            else
            {
                l++;
            }
        }
        return res;
    }
}
