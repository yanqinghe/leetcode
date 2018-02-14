public class Solution283{
    public void moveZeroes(int[] nums) {
        //排除问题输入
        if(nums==null||nums.length<1) return;
        //维护两个游标，i代表当前元素位置，j代表应该当前元素应该放置的位置
        for(int i=0,j=0;i<nums.length;i++){
            if(nums[i]!=0){
                //如果当前元素不为零
                if(i!=j){
                    //如果需要移动，进行移动
                    nums[j]=nums[i];
                    //移动后，将元素的原位置补零，方便后续操作。
                    nums[i]=0;
                }
                j++;
            }
        }
    }
}