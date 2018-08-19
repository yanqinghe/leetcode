import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Solution448 {
    public static void main(String[] args) {
        Solution448 solution448 = new Solution448();
        System.out.println(solution448.findDisappearedNumbers(new int[]{
                4,3,2,7,8,2,3,1
        }));
    }
    public List<Integer> findDisappearedNumbers(int[] nums) {
        int len =nums.length;
        for (int i = 0; i < len;) {
            if(nums[i]>0){
                if(nums[i]!=i+1){
                    swapEle(nums,i,nums[i]-1);
                    continue;
                }
            }
                i++;
        }
        List<Integer> list= new ArrayList<>();
        for (int i = 0; i < len; i++) {
            if(nums[i]==0) list.add(i+1);
        }
        return list;
    }
    void  swapEle(int[] ints,int curI,int toI){
        int temp = ints[toI];
        if(temp<0){
            ints[curI]=0;
        }else {
            ints[toI]=-ints[curI];
            ints[curI]=temp;
        }
    }
}
