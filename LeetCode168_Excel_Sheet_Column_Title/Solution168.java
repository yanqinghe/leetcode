
public class Solution168 {
    public String convertToTitle(int n) {
        if(n==0) return "";
        StringBuilder res = new StringBuilder();

        while (n!=0){
            n--;
            res.append((char)( n%26 +'A'));
            n = n/26;
        }
        res.reverse();
        return res.toString();
    }
}
