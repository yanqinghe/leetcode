public class Solution313 {
    public int nthSuperUglyNumber(int n, int[] primes) {
        int cnt = 1;
        int len = primes.length;
        int[] array = new int[len];
        for (int i = 0; i < array.length; i++) {
            array[i]=1;
        }
        int[] uglyArray = new int[len+1];
        uglyArray[1]=1;
        int[] array2 = new int[len];
        while (cnt<n){
            int min = Integer.MAX_VALUE;
            for (int i = 0; i < len; i++) {
                array2[i]= uglyArray[array[i]]*primes[i];
                min = Math.min(min,array2[i]);
            }
            cnt++;
            uglyArray[cnt]=min;
            for (int i = 0; i < len; i++) {
                if(min==array2[i]) array[i]++;
            }

        }
        return uglyArray[cnt];
    }
}
