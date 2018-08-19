public class Solution507 {
    public boolean checkPerfectNumber(int num) {
        if(num==1) return false;
        int left = 2,right = num-1,sum=1;
        while (left<=right){
            int temp = left*right;
            if(temp==num){

                sum+=left+right;
                left++;
                right--;
            }else if(temp<num){
                left++;
            }else {
                right--;
            }
        }
        return sum==num;
    }
}
