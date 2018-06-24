public class Solution844 {
    public static void main(String[] args) {
        Solution844 solution844 = new Solution844();
        System.out.println(solution844.backspaceCompare("a#c","b"));
    }
    public boolean backspaceCompare(String S, String T) {
        StringBuilder sb1 = new StringBuilder();
        StringBuilder sb2 = new StringBuilder();
        for (int i = 0; i < S.length(); i++) {
            if(S.charAt(i)=='#'){
                if(sb1.length()>0){
                    sb1.deleteCharAt(sb1.length()-1);
                }
            }else {
                sb1.append(S.charAt(i));
            }
        }
        for (int i = 0; i < T.length(); i++) {
            if(T.charAt(i)=='#'){
                if(sb2.length()>0){
                    sb2.deleteCharAt(sb2.length()-1);
                }
            }else {
                sb2.append(T.charAt(i));
            }
        }
        if(sb1.toString().equals(sb2.toString())){
            return true;
        }
        return false;

    }
}
