
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Solution219 {
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        if(nums==null||nums.length<1) return false;
        Map<Integer,Integer> map = new HashMap<>(nums.length);
        for (int i = 0; i < nums.length; i++) {
            if(map.containsKey(nums[i])&& Math.abs(map.get(nums[i])-i)<=k) return true;
            map.put(nums[i],i);
        }
        return false;
    }
}
