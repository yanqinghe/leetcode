
class Solution41 {
    //    Map<Integer,Integer> map = new HashMap();
//    public int firstMissingPositive(int[] nums) {
//
//        for(int i =0;i<nums.length();i++){
//            map.put(num[i]);
//        }
//        int i=1;
//        while(true){
//            if(!map.containsKey(i)){
//                return i;
//            }
//            i++;
//        }
//    }
    public int firstMissingPositive(int[] nums) {
        if (nums.length < 1) {
            return 1;
        }
        for (int i = 0; i < nums.length; ) {
            if (nums[i] > 0 && nums[i] - 1 < nums.length && nums[i] != nums[nums[i] - 1] && nums[i] != i + 1) {
                int temp = nums[i];
                nums[i] = nums[nums[i] - 1];
                nums[temp - 1] = temp;
            } else {
                i++;
            }
        }
        int i = 0;
        while (i < nums.length) {
            if (nums[i] != i + 1) {
                return i + 1;
            }
            i++;
        }
        return i + 1;
    }
}