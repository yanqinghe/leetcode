import java.util.*;

import static java.util.stream.Collectors.toList;

public class Solution820 {
    public static void main(String[] args) {
        Solution820 solution820 = new Solution820();
        System.out.println(solution820.minimumLengthEncoding(new String[]{
                "time", "time", "time"
        }));
    }
    public int minimumLengthEncoding(String[] words) {
            return getLen(Arrays.asList(words),0);
    }

    private int getLen(List<String> list,int l){
        if(list==null||list.size()==0)
            return l+1;
        if(list.size()==1)
            return l+list.get(0).length()+1;
        Map<Character,List<String>> map = new HashMap<>();
        for (String word : list) {
            char c = word.charAt(word.length()-1);
            if(map.containsKey(c)){
                map.get(c).add(word);
            }else {
                map.put(c,new ArrayList<String>(){
                    {add(word);}
                });
            }
        }
        int cnt =0;
        if(list.size()==map.keySet().size()){
            for (String s : list) {
                cnt+=s.length()+l+1;
            }
            return cnt;
        }
        cnt=0;
        for (char c:map.keySet()){
            List<String> strings = map.get(c);
            if(strings.size()>=0){
                cnt+=getLen(strings.stream().filter(str-> str.length()>1).map(str->{
                    return str.substring(0,str.length()-1);
                }).collect(toList()),l+1);
            }
        }
        return cnt;
    }

}
