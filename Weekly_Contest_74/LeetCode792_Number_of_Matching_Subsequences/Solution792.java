import java.util.ArrayList;
import java.util.List;

public class Solution792 {
    public static void main(String[] args) {
        Solution792 solution792 = new Solution792();
        solution792.numMatchingSubseq("abcde",
               new String[]{"a","bb","acd","ace"});
    }
    public int numMatchingSubseq(String S, String[] words) {

        int cnt = 0;
        if(words==null||words.length<1) return cnt;
        List<Integer>[] lists = new List[26];
        for (int i = 0; i < lists.length; i++) {
            lists[i] = new ArrayList<>();
        }
        for (int i = 0; i <S.length() ; i++) {
            lists[S.charAt(i)-'a'].add(i);
        }
        for (String word:words
             ) {
            boolean is=true;
            int index =-1;
            for (int i = 0; i < word.length(); i++) {
                int c  = word.charAt(i)-'a';
                int j =0;
                while (j<lists[c].size()&&lists[c].get(j)<=index){
                    j++;
                }
                if(j==lists[c].size()){
                    is=false;
                    break;
                }
                index=lists[c].get(j);
            }
            if(is) cnt++;
        }
        return cnt;
    }
}
