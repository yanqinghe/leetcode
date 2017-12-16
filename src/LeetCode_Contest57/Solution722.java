
import java.util.ArrayList;
import java.util.List;

public class Solution722 {
    public static void main(String[] args) {
            Solution722 solution722 = new Solution722();
            String[] s  ={"a//*b/*/c","blank","d/*/e/*/f"};
            solution722.removeComments(s);
    }
    public List<String> removeComments(String[] source) {
        boolean inB = false;
        List<String> res = new ArrayList<>();
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < source.length; i++) {
            boolean inL =false;
            if(!inB){
                if(stringBuilder.length()>0){
                    res.add(stringBuilder.toString());
                }
                stringBuilder = new StringBuilder();
            }
            int j = 0;
            for (; j < source[i].length(); j++) {
                if(inL){
                    break;
                }
                if(!inB&&source[i].charAt(j)=='/'){
                    if(j+1<source[i].length()){
                        if(source[i].charAt(j+1)=='*'){
                            inB=true;
                            j++;
                            continue;
                        }else if(!inB&&source[i].charAt(j+1)=='/'){
                            inL=true;
                            j++;
                            continue;
                        }
                    }
                }else if (source[i].charAt(j)=='*'){
                    if(j+1<source[i].length()){
                        if (inB&&source[i].charAt(j+1)=='/'){
                            inB=false;
                            j++;
                            continue;
                        }
                    }
                }
                if(!inB&& !inL&&j<source[i].length()){
                    stringBuilder.append(source[i].charAt(j));
                }
            }


        }
        if(!inB){
            res.add(stringBuilder.toString());
        }
        return res;
    }
}
