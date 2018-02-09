import java.util.ArrayList;
import java.util.List;

public class Solution279 {
    public static void main(String[] args) {
        Solution279 solution279 = new Solution279();
        System.out.println(solution279.numSquares1(7927));
    }

    /**
     *
     550 / 586 test cases passed.
     Status: Time Limit Exceeded
     Submitted: 1 minute ago
     Last executed input:
     7927
     * @param n
     * @return
     */
    public int numSquares(int n) {
        int[] array = new int[n+1];
        List<Integer> linkedList = new LinkedList<>();
        List<Integer> linkedList2 =  new LinkedList<>();
        int i2=1;
        for (int i = 1; i2 <= n; i++,i2=i*i) {
            array[i2]=1;
            linkedList.add(i2);
            linkedList2.add(i2);
        }
        while (array[n]==0){
            List<Integer> linkedList3 =  new LinkedList<>();
            for (int i = 0; i < linkedList.size(); i++) {
                for (int j = 0; j < linkedList2.size(); j++) {
                    int sum = linkedList.get(i)+linkedList2.get(j);
                    if(sum<n&&array[sum]==0){
                        array[sum]=array[linkedList.get(i)]
                                +array[linkedList2.get(j)];
                        linkedList3.add(sum);
                    }else if(sum==n){
                        return array[linkedList.get(i)]+array[linkedList2.get(j)];
                    }
                }
            }
            linkedList=linkedList3;
        }
        return array[n];
    }


    /**
     * 改进以上代码可以AC
     * @param n
     * @return
     */
    int numSquares1(int n) {
        int[] array = new int[n+1];
        int i2=1;
        for (int i = 1; i2 <= n; i++,i2=i*i) {
            array[i2]=1;
        }
        i2=1;
        for (int a = 0; a <= n; ++a)
        {
            i2 = a;
            for (int b = 0; i2 <= n; ++b,i2=a+b*b)
            {
                array[i2] = Math.min(array[a] + 1, array[i2]==0?Integer.MAX_VALUE:array[i2]);
            }
        }
        return array[n];
    }

    /**
     * 这部分代码来自LeetCode Java部分最高排名
     * @param n
     * @return
     */
    //1.Math Lagrange's four-square theorem, also known as Bachet's conjecture, states that every natural number can be represented as the sum of four integer squares.
    private boolean isSquare(int n){
        int sq = (int)Math.sqrt(n);
        return sq*sq == n;
    }
    public int numSquares2(int n) {
        if(isSquare(n))
            return 1;
        // The result is 4 if and only if n can be written in the form of 4^k*(8*m + 7). Please refer to
        // Legendre's three-square theorem.
        while(n % 4 == 0){
            n >>= 2;
        }
        if(n % 8 == 7)
            return 4;
        //check 2
        int sq = (int)Math.sqrt(n);
        for(int i = 1; i <= sq; i++){
            if(isSquare(n-i*i))
                return 2;
        }
        return 3;
    }
}
