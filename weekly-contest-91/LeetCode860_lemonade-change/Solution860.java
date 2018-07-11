public class Solution860 {
    public static void main(String[] args) {
        Solution860 solution860 = new Solution860();
        System.out.println(solution860.lemonadeChange(new int[]{
//                5,5,10,10,20
                5,5,5,10,20
        }));
    }
    public boolean lemonadeChange(int[] bills) {
        int[] count  = new int[3];
        int len =bills.length;
        for (int bill : bills) {
            if(bill==5) count[0]++;
            else if(bill==10) {
                count[1]++;
                count[0]--;
                if(count[0]<0) return false;
            }else {
                //如果收到20的
                count[1]--;
                if(count[1]<0){
                   count[1]++;
                   count[0]-=3;
                }else {
                    count[0]--;
                }
                if(count[0]<0) return false;
            }
        }
        return true;
    }
}
