public class Solution762 {

    public static void main(String[] args) {
        for (int m = 0; m < 33; m++) {
            boolean is =true;

            if(m < 2){
                is=false;
            }else {
                for (int i = 2; i*i <= m; i++)  // 控制条件必须是 <=
                {
                    if (m % i == 0){
                        is=false;
                        break;
                    }
                }
            }
            System.out.print(is);
            System.out.print(',');
        }
        Solution762 solution762 = new Solution762();
        System.out.println(solution762.countPrimeSetBits(842
                ,888));
    }
    static boolean[] prime = {false,false,true,true,false,true,false,true,false,false,false,true,false,true,false,false,false,true,false,true,false,false,false,true,false,false,false,false,false,true,false,true,false};

    public int countPrimeSetBits(int L, int R) {
        int ret = 0;
        for (int i = L; i <=R ; i++) {
            int cnt = 0;
            int m =i;
            while (m>0){
                if((m&1)==1) cnt++;
                m=m>>>1;
            }
            if(prime[cnt]){
                ret++;
            }
        }
        return ret;
    }
}
