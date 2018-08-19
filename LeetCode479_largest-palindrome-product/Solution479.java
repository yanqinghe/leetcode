public class Solution479 {

        public int largestPalindrome(int n) {
            if(n==1)
                return 9;
            int maxNumber=(int)Math.pow(10,n)-1;
            for(int i=maxNumber;i>maxNumber/10;i--){//从大到小遍历n位数
                long num=palindrome(i);//构造回文
                for(long j=maxNumber;j*j>=num;j--){//判断num是否可以分解为两个n位数相乘
                    if(num%j==0)
                        return (int)(num%1337);
                }
            }
            return 0;
        }
        public long palindrome(int i){
            StringBuffer s=new StringBuffer();
            s.append(Integer.toString(i)).reverse();
            return Long.parseLong(i+s.toString());
        }
}
