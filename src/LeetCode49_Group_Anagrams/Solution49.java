package LeetCode49_Group_Anagrams;


import java.util.*;

public class Solution49 {
    public static void main(String[] args) {

    }

    public List<List<String>> groupAnagrams(String[] strs) {
        //初始化结果List
        List<List<String>> result = new ArrayList<>();
        //初始化辅助的HashMap
        Map<String, Integer> map = new HashMap();
        for (int i = 0; i < strs.length; i++) {
            char[] temp = strs[i].toCharArray();
            Arrays.sort(temp);
            String str = String.valueOf(temp);
            if (map.containsKey(str)) {
                result.get(map.get(str)).add(strs[i]);
            } else {
                List<String> list = new ArrayList<>();
                list.add(strs[i]);
                map.put(str, result.size());
                result.add(list);
            }
        }
        return result;
    }
}
