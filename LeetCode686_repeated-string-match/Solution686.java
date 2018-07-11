public class Solution686 {
    public static void main(String[] args) {
        Solution686 solution686  = new Solution686();
        System.out.println(solution686.repeatedStringMatch("aaaaaaaaaaaaaaaaaaaaa",
                "bacbacbac"));
    }
    public int repeatedStringMatch(String A, String B) {
        int ret = 1;
        int indexA =0;
        int indexB=0;
        StringBuilder sb = new StringBuilder(A);
        while (true){
            if(indexB>=B.length()){
                break;
            }
            if(indexA>=sb.length()){
                sb.append(A);
                ret++;
            }

            if(sb.charAt(indexA)==B.charAt(indexB)){
                indexA++;
                indexB++;
            }else{
                if(indexB==0){
                    indexA++;
                }else {
                    indexA-=indexB-1;
                    indexB=0;

                }
                if(indexA>=A.length()) {
                    ret = -1;
                    break;
                }
            }
        }
        return ret;
    }
}
