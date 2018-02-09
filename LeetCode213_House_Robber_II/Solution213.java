
public class Solution213 {
    public static void main(String[] args) {
        Solution213 solution213 = new Solution213();
        solution213.rob(new int[]{11,2,3,4,1,25,51,23,5,6,3,41,5,65});
    }
    public int rob(int[] nums) {
        if(nums==null||nums.length<1) return 0;
        if(nums.length==1) return nums[0];
        int [] help = new int[4];
        int [] help3 = new int[4];
        boolean [] help2 = new boolean[4];
        help[3]=nums[0];
        help2[3] =true;
        help3[3]=0;
        for (int i = 1; i < nums.length; i++) {
            for (int j = 0; j < help.length-1; j++) {
                help[j]=help[j+1];
                help2[j]=help2[j+1];
                help3[j]=help3[j+1];
            }
            help3[3]=Math.max(help3[0],help3[1])+nums[i];
            if(help[0]>help[1]){
                help[3]=help[0]+nums[i];
                help2[3]=help2[0];
            }else if(help[0]<help[1]){
                help[3]=help[1]+nums[i];
                help2[3]=help2[1];
            }else{
                help[3]=help[1];
                help2[3]=help2[0]&&help2[1];
            }
        }
        return Math.max(Math.max(help3[2],help3[3]),Math.max(help[2],help2[3]?Math.max(help[3]-nums[0],help[3]-nums[nums.length-1]):help[3]));
    }
}
