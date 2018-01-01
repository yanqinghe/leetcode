public class Solution754 {
    public static void main(String[] args) {
        Solution754 solution1 = new Solution754();
        for (int i = 0; i < 10; i++) {
            System.out.println(i+":"+solution1.reachNumber2(i));
        }
    }
    public int reachNumber(int target) {
        target = Math.abs(target);
        int allStep =0;
        int step = 0;
        while (allStep<target||((allStep-target)&1)!=0){
            step++;
            allStep+=step;
        }
        return step;
    }
    public int reachNumber2(int target){
        target =Math.abs(target);
        int n = (int)Math.ceil((-1.0+Math.sqrt(1+8.0*target))/2);
        long sum = n*(n+1)/2;
        if(sum==target) return n;
        long res = sum- target;
        if((res&1)==0){
            //如果res为偶数,sum和target都为偶数,那么在累加的过程中，只需要将[1,n]的某个元素x反转为-x,即可
            return n;
        }else {
            //如果res为奇数,如果n为奇数
            return n+((n&1)==1?2:1);
        }
    }

}
