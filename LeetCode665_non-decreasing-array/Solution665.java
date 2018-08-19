public class Solution665 {
    public static void main(String[] args) {
        Solution665 solution665 = new Solution665();
        System.out.println(solution665.checkPossibility(new int[]{4,2,1}));
    }
    public boolean checkPossibility(int[] nums) {
        int cnt = 0;
        int prepre = 0;
        for (int i = 1; i < nums.length; i++) {
            if(nums[i]<nums[i-1]){
                nums[i]=prepre;
                cnt++;
            }
            prepre=nums[i-1];
        }
        return cnt<2;
    }
}
