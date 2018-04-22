import java.util.*;

public class Solution819 {
    public static void main(String[] args) {
        Solution819 solution819 = new Solution819();
        System.out.println(solution819.mostCommonWord("Bob",new String[]{
        }));
    }
    public String mostCommonWord(String paragraph, String[] banned) {
        StringBuffer stringBuffer = new StringBuffer();
        for (int i = 0; i <banned.length ; i++) {
            banned[i]=banned[i].toLowerCase();
        }

        Set<String> stringSet= new HashSet<>(Arrays.asList(banned));

        Map<String,Integer> map = new HashMap<>();
        paragraph = paragraph.toLowerCase();
        for (int i = 0; i < paragraph.length(); i++) {
            char c  = paragraph.charAt(i);
            if(c<='z'&&c>='a'){
                stringBuffer.append(c);
            }else {
                String str = stringBuffer.toString();
                if(str.length()==0||stringSet.contains(str)) {

                }else {
                    if(map.containsKey(str)){
                        map.put(str,map.get(str)+1);
                    }else {
                        map.put(str,1);
                    }
                }
                stringBuffer = new StringBuffer();
            }
        }
        String str = stringBuffer.toString();
        if(str.length()==0||stringSet.contains(str)) {

        }else {
            if(map.containsKey(str)){
                map.put(str,map.get(str)+1);
            }else {
                map.put(str,1);
            }
        }
        int max = 0;
        String ret = "";
        for (String s:map.keySet()) {
            if(map.get(s)>max){
                ret =s;
                max=map.get(s);
            }
        }
        return ret;
    }
}
