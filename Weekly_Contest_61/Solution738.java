
public class Solution738 {
    int max = 0;
    public int monotoneIncreasingDigits(int N) {
        String nstr = String.valueOf(N);

        //不能进位
        help(nstr,1,true,nstr.charAt(0)-'0');
        //允许进位
        for (int i = nstr.charAt(0)-'0'-1; i >=0; i--) {
            if(max!=0) return max;
            help(nstr,1,false,i);
        }
        return max;
    }
    void help(String nstr,int i,boolean is,int res){
        if(max!=0) return ;
        if(i>=nstr.length()) {
            max = Math.max(res,max);
            return;
        }
        if(is){
            //不能进位的话
            for(int j =nstr.charAt(i)-'0';j>=nstr.charAt(i-1)-'0';j--){
                //要在从上一个开始到这个进行循环
                if(j==nstr.charAt(i)-'0'){
                    //不能进位
                    help(nstr,i+1,true,res*10+j);
                }else {
                    help(nstr,i+1,false,res*10+j);
                }
            }
        }else {
            for (int j = 9; j >= 0; j--) {
                help(nstr,i+1,false,res*10+j);
            }
        }
    }
}
