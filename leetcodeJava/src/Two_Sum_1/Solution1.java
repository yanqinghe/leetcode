package Two_Sum_1;

/**
 * Created by yanqinghe on 2017/7/2.
 */
public class Solution1 {
    public static void main(String[] args) {

    }

    public int[] twoSum(int[] nums, int target) {
        int[] answer = new int[2];
        for (int i = 0; i < nums.length; i++) {
            answer[0] = nums[i];
            int temp = target - answer[0];
            for (int j = i; j < nums.length; j++) {
                if (nums[j] == temp) {
                    return answer;
                }
            }
        }
        return answer;
    }

//    public int[] twoSum2(int[] nums, int target) {
//        int[] res = new int[2];
//        if(numbers==null||numbers.length<2) return null;
//        Map<Integer, Integer> map = new HashMap<>();
//        for(int i=0;i<numbers.length;i++){
//            if(map.containsKey(target-numbers[i])){
//                res[0]=map.get(target-numbers[i])+1;
//                res[1]=i+1;
//                return res;
//            }
//            map.put(numbers[i],i);
//        }
//        return null;
//    }

}
