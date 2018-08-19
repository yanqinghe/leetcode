import java.util.Locale;

public class Solution482 {
    public String licenseKeyFormatting(String S, int K) {
        StringBuilder sb= new StringBuilder();
        for (char c : S.toCharArray()) {
            if(c=='-') continue;
            if(c<='z'&&c>='a') c=Character.toUpperCase(c);
            sb.append(c);
        }
        int len =sb.length();
        if(sb.length()>=K){
            for (int i = len-K; i >0 ;i-=K) {
                sb.insert(i,'-');
            }
        }
        return sb.toString();
    }
}
