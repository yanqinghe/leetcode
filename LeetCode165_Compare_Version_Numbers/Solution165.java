
import java.util.Arrays;

public class Solution165 {
    public static void main(String[] args) {
        Solution165 solution165 = new Solution165();
        solution165.compareVersion("1.1.1","1.1.1.1");
    }
    public int compareVersion(String version1, String version2) {
        String [] strings1 = version1.split("\\.");
        String [] strings2 = version2.split("\\.");
        if(strings1.length>strings2.length){
            return helpJudge(strings1,strings2);
        }else {
            return -helpJudge(strings2,strings1);
        }

    }
    int helpJudge(String[] longStr,String[] shortStr){
        int i =0;
        for (; i < shortStr.length; i++) {
            if(Integer.valueOf(longStr[i])>Integer.valueOf(shortStr[i])){
                return 1;
            }else if(Integer.valueOf(longStr[i])<Integer.valueOf(shortStr[i])){
                return -1;
            }
        }
        for(;i<longStr.length;i++){
            if(Integer.valueOf(longStr[i])>0){
                return 1;
            }
        }
        return 0;
    }
}
