public class Solution260 {
    public int[] singleNumber(int[] nums) {
        int[] res = new int[2];
        int dif = 0;
        //首先根据SingleNumber的方法对所有的数字进行异或操作
        for (int num: nums
             ) {
            dif ^=num;
        }
        //异或操作后得到的是两个只出现一次的数字的异或结果。
        //那么利用下面的操作，就可以得到第一个为1的位；为1的位说明两个数字的当前位不同，那么就可以利用这一位将所有的数字分为两组。
        //两个数字就被分到两个不同的分组中，对两个分组内的元素进行操作。
        dif &= -dif;
        for (int num:nums
             ) {
            if((num&dif)==0) res[0]^=num;
            else res[1] ^= num;
        }
        return res;
    }
}
