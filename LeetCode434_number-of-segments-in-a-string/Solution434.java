public class Solution434 {
    public int countSegments(String s) {
        boolean is =true;
        int cnt =0;
        for (char c : s.toCharArray()) {
            if(c==' ') is=true;
            else if(is){
                cnt++;
                is=false;
            }
        }
        return cnt;
    }
}
