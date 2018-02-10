import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Solution290{
    public static void main(String[] args) {
        Solution290 solution290 = new Solution290();
        solution290.wordPattern("abba",
        "dog cat cat dog");
    }

    public boolean wordPattern(String pattern, String str) {
        //如果输入有问题，返回false
        if(pattern==null||pattern.length()<1 ||str==null||str.length()<1) return false;
        //首先分割字符串
        String[] strArr = str.split(" ");
        //建立从abba 到dog cat cat dog的索引,a-> dog b->cat 因为只有26个小写英文字母，所以数组大小为26
        String[] table = new String[26];
        //还需要建立从dog cat cat dog 到 abba 的索引，否则可能会出现dog cat cat dog 与aaaa 相匹配的情况，因为字符串的大小未知，所以考虑采用HashMap的形式保存
        Map<String,Integer> hashMap = new HashMap<>();
        //如果个数不同，返回false
        if(pattern.length()!=strArr.length) return false;
        for(int i=0;i<strArr.length;i++){
            int index = pattern.charAt(i)-'a';
            //如果出现两种索引都不匹配的情况，返回false
            if(table[index]!=null&&!table[index].equals(strArr[i]) || hashMap.containsKey(strArr[i])&&hashMap.get(strArr[i])!=index) return false;
            table[index] = strArr[i];
            hashMap.put(strArr[i], index);
        }
        return true;
    }
}