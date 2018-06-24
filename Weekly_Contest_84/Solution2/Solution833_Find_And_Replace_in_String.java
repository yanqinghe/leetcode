import java.util.Arrays;

public class Solution833_Find_And_Replace_in_String {
    public static void main(String[] args) {
        Solution833_Find_And_Replace_in_String solution833_find_and_replace_in_string = new Solution833_Find_And_Replace_in_String();
        System.out.println(
                solution833_find_and_replace_in_string
                        .findReplaceString("abcd",
                                new int[]{0,2},
                                new String[]{"a","cd"},new String[]{"eee", "ffff"}));
    }
    public String findReplaceString(String S, int[] indexes, String[] sources, String[] targets) {
        StringBuilder sb = new StringBuilder();
        String[] arr = new String[S.length()];
        for (int i = 0; i < S.length(); i++) {
            arr[i]=S.charAt(i)+"";
        }
        for (int i = 0; i < indexes.length; i++) {
            boolean is =true;
            int start = indexes[i];
            for (int j = 0; j < sources[i].length(); j++) {
                if(S.charAt(start+j)!=sources[i].charAt(j)){
                    is=false;
                }
            }
            if(is){
                Arrays.fill(arr,start,start+sources[i].length(),"");
                arr[start]=targets[i];
            }
        }
        for (String s : arr) {
            sb.append(s);
        }
        return sb.toString();
    }
}
