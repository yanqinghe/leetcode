import java.util.ArrayList;
import java.util.List;

public class Solution241 {
    public List<Integer> diffWaysToCompute(String input) {
        List<Integer> list = new ArrayList<>();
        if(input==null||input.length()<1) return list;
        for (int i = 0; i < input.length(); i++) {
            char c = input.charAt(i);
            if(c=='-'||c=='+'||c=='*'){
                String input1 = input.substring(0,i);
                String input2 = input.substring(i+1);
                List<Integer> res1 = diffWaysToCompute(input1);
                List<Integer> res2 = diffWaysToCompute(input2);
                for (int v1:res1){
                    for (int v2 :res2){
                        int tempRes = 0;
                        switch (c){
                            case '+':
                                tempRes=v1+v2;
                                break;
                            case '-':
                                tempRes=v1-v2;
                                break;
                            case '*':
                                tempRes=v1*v2;
                                break;
                        }
                        list.add(tempRes);
                    }
                }
            }
        }
        if(list.size()==0){
            list.add(Integer.valueOf(input));
        }
        return list;
    }
}
