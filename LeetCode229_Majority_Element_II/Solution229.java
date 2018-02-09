import java.util.ArrayList;
import java.util.List;

public class Solution229 {
    public List<Integer> majorityElement(int[] nums) {
        List<Integer> res = new ArrayList<>();
        if(nums==null||nums.length<1) return res;
        int count1=0,num1=0,count2=0,num2=0;
        //首先对数组进行遍历，得到两个众数
        for (int num:nums) {
            if(num1==num) count1++;
            else if(num2==num) count2++;
            else if(count1==0) {
                num1 = num;
                count1++;
            }else if(count2 ==0){
                num2=num;
                count2++;
            }else {
                count1--;
                count2--;
            }
        }
        count1=count2=0;
        for(int num:nums){
            if(num==num1) count1++;
            else if(num==num2) count2++;
        }
        int r  = nums.length/3;
        if(count1>r) res.add(num1);
        if(count2>r) res.add(num2);
        return res;
    }
}
