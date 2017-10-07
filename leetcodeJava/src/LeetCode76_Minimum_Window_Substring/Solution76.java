package LeetCode76_Minimum_Window_Substring;

import java.util.HashMap;
import java.util.Map;

public class Solution76 {
    public String minWindow(String s, String t) {
        if(s==null||s.length()<1){
            return "";
        }
        Map<Character,Integer> tMap = new HashMap<>();
        //将t字符串中的字符保存到Map中
        for (int i = 0; i < t.length() ; i++) {
            if(tMap.containsKey(t.charAt(i))){
                //如果已存在，累加
                tMap.put(t.charAt(i),tMap.get(t.charAt(i))+1);
            }else {
                //如果不存在,添加
                tMap.put(t.charAt(i),1);
            }
        }

        int left = 0;//最小字符串对应t字符串的左边位置
        int right = s.length();//最小字符串对应s字符串的右边位置
        int count =0; //当前窗口的大小
        for(int r=0,l=0;r<s.length();r++){
            if(tMap.containsKey(s.charAt(r))){
                tMap.put(s.charAt(r),tMap.get(s.charAt(r))-1);
                if(tMap.get(s.charAt(r))>=0){
                    count++;
                }
                while(count==t.length()){
                    //if size of window == s.length()
                    if(r-l<=right-left){
                        left=l;
                        right=r;
                    }
                    if(tMap.containsKey(s.charAt(l))){
                        tMap.put(s.charAt(l),tMap.get(s.charAt(l))+1);
                        if(tMap.get(s.charAt(l))>0){
                            count--;
                        }
                    }
                    l++;
                }
            }

        }
        if(right-left+1>s.length()){
            return "";
        }
        return s.substring(left,right+1);
    }
}

