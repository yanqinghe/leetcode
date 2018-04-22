public class Solution806 {
    public int[] numberOfLines(int[] widths, String S) {
        int n = 0;
        int rowN =0;
        for (int i = 0; i < S.length(); i++) {
            int index = S.charAt(i)-'a';
            rowN+=widths[index];
            if(rowN>100){
                i--;
                n++;
                rowN=0;
            }
        }
        return new int[]{n+1,rowN};
    }

}
