import java.util.HashSet;
import java.util.Set;

public class Solution94_4 {
    public static void main(String[] args) {
        Solution94_4 solution94_4 = new Solution94_4();
        System.out.println('s');
    }
    public int lenLongestFibSubseq(int[] A) {
        Set<Integer> set = new HashSet<>();
        for (int i : A) {
            set.add(i);
        }
        int len =A.length;
        int res =0;
        for (int i = 0; i <len ; i++) {
            for (int j = i+1; j < len; j++) {
                int temp = 2;
                int num1 = A[i];
                int num2 =  A[j];
                while (set.contains(num1+num2)){
                    temp++;
                    int a = num2;
                    num2=num1+num2;
                    num1=a;
                    System.out.println(num2+";"+temp);
                 }
                 if(temp>2){
                     res = Math.max(res,temp);
                 }
            }
        }
        return res;
    }
}
