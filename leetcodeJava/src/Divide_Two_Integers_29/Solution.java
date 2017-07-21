class Solution{
    public static void main(String[] args){

    }
     public int divide(int dividend, int divisor) {
        if(divisor==0){
            return Integer.MAX_VALUE;
        }
        boolean r = true;
        if(dividend<0){
            if(divisor<0){
 dividend=Math.abs(dividend);
            divisor=Math.abs(divisor);
            }else{
                dividend=Math.abs(dividend);
            }
        }
        if(dividend<0||divisor<0){
            r = false;
            dividend=Math.abs(dividend);
            divisor=Math.abs(divisor);
        }
        int result =0;
        while(dividend-divisor>=0){
            dividend = dividend-divisor;
            result++;
        }
        return r?result:-result;
    }
}