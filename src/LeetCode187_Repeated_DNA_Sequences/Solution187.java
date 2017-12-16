
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Solution187 {
    public static void main(String[] args) {
        Solution187 solution187 = new Solution187();
        solution187.findRepeatedDnaSequences("AAAAAAAAAAA");
    }

    public List<String> findRepeatedDnaSequences(String s) {
        List<String> res = new ArrayList<>();
        if(s==null||s.length()<10) return res;
        int num =1;
        int max = (int) Math.pow(2,20);// 2^20-1
        for (int i = 0; i < 10; i++) {
            num<<=2;
            num|=convert2Int(s.charAt(i));

        }
        Map<Integer,Integer> map = new HashMap<>();
        map.put(num,1);
        for (int i = 10; i < s.length(); i++) {

            num<<=2;
            num&=(max-1);
            num|=max;
            num|=convert2Int(s.charAt(i));
            int temp = 0;
            if(map.containsKey(num)) temp = map.get(num);
            map.put(num,temp+1);
        }

        for (int key:map.keySet()
             ) {
            if(map.get(key)>1){
                res.add(convert2Str(key));
            }
        }
        return res;
    }
    String convert2Str(int num){
        StringBuilder res = new StringBuilder();
        while (num!=1){
            switch (num&3){
                case 0:
                    res.append('A');
                    break;
                case 1:
                    res.append('C');
                    break;
                case 2:
                    res.append('G');
                    break;
                case 3:
                    res.append('T');
                    break;
            }
            num>>=2;
        }
        return res.reverse().toString();
    }
    int convert2Int(char c){
        switch (c){
            case 'A':
                return 0;
            case 'C':
                return 1;
            case 'G':
                return 2;
            case 'T':
                return 3;
                default:
                    return 0;
        }
    }
}
