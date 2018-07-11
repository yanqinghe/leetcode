public class Solution633 {
    public static void main(String[] args) {
        for (int i = 0; i < 46341; i++) {
            System.out.println(i*i);
        }
    }
    public boolean judgeSquareSum(int c) {
        if(c<0) return false;
        int mid=(int) Math.sqrt(c);
        int left=0,right=mid;
        while(left<=right)
        {
            int temp=left*left+right*right;
            if(c==temp) return true;
            else if(c>temp) left++;
            else right--;
        }
        return false;
    }
}
