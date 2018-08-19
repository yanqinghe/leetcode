import java.util.*;

public class Solution500 {

    final static int[] map = new int[]{
            1,2,2,1,0,1,1,1,0,1,1,1,2,2,0,0,0,0,1,0,0,2,0,2,0,2
    };

    public static void main(String[] args) {

    }
    public String[] findWords(String[] words) {
        List<String> arr =new ArrayList<>();
        for (String word : words) {
            boolean is = true;
            char[] chars = word.toCharArray();
            for (int i = 0; i < chars.length; i++) {
                if(chars[i]<'a'){
                    chars[i]-='A';

                }else {
                    chars[i]-='a';
                }
            }
            int i  = map[chars[0]];
            for (char c : chars) {
                if(map[c]!=i){
                    is=false;
                    break;
                }
            }
            if(is) arr.add(word);
        }
        String[] res = new String[arr.size()];
        return arr.toArray(res);
    }
}
