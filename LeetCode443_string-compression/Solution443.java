import java.lang.reflect.Array;

public class Solution443 {
    public static void main(String[] args) {
        Solution443 solution443 = new Solution443();
        System.out.println(solution443.compress(new char[]{
                'a','a','b','b','c','c','c','a','b'
        }));
    }
    public int compress(char[] chars) {
        int len = chars.length;
        int cnt =1;
        int ret =0;
        int index =0;
        for (int i = 1; i < len; i++) {
            if(chars[i]==chars[i-1]){
                cnt++;
            }else {
                ret++;
                chars[index++]=chars[i-1];
                if(cnt>1){
                    char[] chars1 = String.valueOf(cnt).toCharArray();
                    ret+=chars1.length;
                    for (int j = 0; j < chars1.length; j++) {
                        chars[index++]=chars1[j];
                    }
                }
                cnt=1;
            }
        }
        ret++;
        chars[index++]=chars[len-1];
        if(cnt>1){
            char[] chars1 = String.valueOf(cnt).toCharArray();
            ret+=chars1.length;
            for (int j = 0; j < chars1.length; j++) {
                chars[index++]=chars1[j];
            }
        }
        return ret;
    }
}
