import java.util.Locale;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Solution831 {
    public static void main(String[] args) {
        Solution831 solution831 = new Solution831();
        System.out.println(solution831.maskPII("86-(10)12345678"));;
    }
    public String maskPII(String S) {
        int index = S.indexOf('@');
        if(index>0){
            return email(S,index);
        }else {
            Pattern pattern = Pattern.compile("[^0-9]");
            Matcher matcher = pattern.matcher(S);
            String all = matcher.replaceAll("");
            return telNumber(all);
        }
    }
    private String email(String email,int index){
        StringBuilder stringBuilder =new StringBuilder();
        email = email.toLowerCase(Locale.US);
        stringBuilder.append(email.charAt(0)).append("*****").append(email.substring(index-1));
        return stringBuilder.toString();
    }
    private String telNumber(String telNumber){
        StringBuilder stringBuilder = new StringBuilder("***-****-");
        int len  = telNumber.length();
        stringBuilder.append(telNumber.substring(len-4));
        if(len>10){
            if(len==13){
                stringBuilder.insert(0,"+***-");
            }
            else if(len==12){
                stringBuilder.insert(0,"+**-");
            }else if(len==11){
                stringBuilder.insert(0,"+*-");
            }
        }
        return stringBuilder.toString();
    }
}
