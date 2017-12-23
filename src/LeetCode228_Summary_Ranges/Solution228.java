import java.util.ArrayList;
import java.util.List;

public class Solution228{
    public List<String> summaryRanges(int[] nums) {
        List<String> res= new ArrayList<>();
        if(nums==null||nums.length<1) return res;
        StringBuilder str = new StringBuilder().append(nums[0]);
        boolean is = false;
        for (int i = 1; i < nums.length; i++) {
            while (i<nums.length&&nums[i]==nums[i-1]+1){
                is=true;
                i++;
            }
            if(is){
                //如果is为true说明存在连续的部分
                str.append("->").append(nums[i-1]);
                is=false;
            }
            res.add(str.toString());
            str = new StringBuilder();
            if(i<nums.length) str.append(nums[i]);
        }
        if(str.length()>0) res.add(str.toString());
        return res;
    }
}
