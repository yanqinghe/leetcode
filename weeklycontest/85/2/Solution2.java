import java.util.ArrayList;
import java.util.List;

public class Solution2 {
    public static void main(String[] args) {
        Solution2 solution2 = new Solution2();
        System.out.println(solution2.pushDominoes(".L.R...LR..L.."));
        System.out.println(solution2.pushDominoes("RR.L"));
        System.out.println(solution2.pushDominoes(".L.R."));
        System.out.println(solution2.pushDominoes("R....R....R....L"));


    }
    public String pushDominoes(String dominoes) {
        int len  = dominoes.length();
        char[] chars = dominoes.toCharArray();
        int index =0;
        for (int i = 0; i < len; i++) {
            if(chars[i]!='.'){
                change(chars,index,i);
                index=i;
            }
        }
        if(index<len){
            change(chars,index,len-1);
        }
        return String.valueOf(chars);
    }
    void  change(char[] chars,int i,int j){
        if(chars[i]=='R'&&chars[j]=='L'){
            int mid = (j-i-1)/2;
            for (int k = 0; k <= mid; k++) {
                chars[i+k]='R';
                chars[j-k]='L';
            }
        }else if(chars[i]=='R'){
            for (int k = i; k <= j; k++) {
                chars[k]='R';
            }
        }else if(chars[j]=='L'){
            for (int k = i; k <= j; k++) {
                chars[k]='L';
            }
        }
    }
}
