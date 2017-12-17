import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class Solution748 {
    public static void main(String[] args) {
        Solution748 solution_2  =new Solution748();
        System.out.println(solution_2.shortestCompletingWord("iMSlpe4",
        new String[]{
                "claim","consumer","student","camera","public","never","wonder","simple","thought","use"}));
    }
    public String shortestCompletingWord(String licensePlate, String[] words) {
        Integer [] word = new Integer[words.length];
        for (int i = 0; i < word.length; i++) {
            word[i]=i;
        }
        Arrays.sort(word, new Comparator<Integer>() {
            @Override
            public int compare(Integer s, Integer t1) {
                if (words[s].length()==words[t1].length()) return s-t1;
                return words[s].length()-words[t1].length();
            }
        });

        int[] ch = new int[26];
        licensePlate = licensePlate.toLowerCase();
        for (int i = 0; i < licensePlate.length() ; i++) {
            if(licensePlate.charAt(i)>='a'){
                ch[licensePlate.charAt(i)-'a']++;
            }
        }

        for (int index: word
             ) {

            boolean is =true;

            int[]temp = ch.clone();
            String string = new String(words[index].toLowerCase());
            for (int i = 0; i < string.length(); i++) {
                temp[string.charAt(i)-'a']--;
            }
            for (int i = 0; i < temp.length; i++) {
                if(temp[i]>0) is=false;
            }
            if(is) return words[index];
        }
        return "";
    }
}
