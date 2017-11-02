package LeetCode126_Word_Ladder_2;

import org.omg.CORBA.INTERNAL;

import java.lang.reflect.Array;
import java.util.*;

public class Solution126 {
    public static void main(String[] args) {
        Solution126 solution126 = new Solution126();
        List<String> wordList  = new ArrayList<>();
                wordList.add("hot");
                wordList.add("dot");
                wordList.add("dog");
        wordList.add("lot");
        wordList.add("log");
        wordList.add("cog");

//        wordList.add("hot");
//        wordList.add("cog");
//        wordList.add("dog");
//        wordList.add("tot");
//        wordList.add("hog");
//        wordList.add("hop");
//        wordList.add("pot");


//        wordList.add("lot");
//        wordList.add("log");

        solution126.findLadders("hit","cog",wordList);
        return;
    }
    public List<List<String>> findLadders(String beginWord, String endWord, List<String> wordList){
        Set<String> dict = new HashSet<>(wordList);
        Map<String,Integer> path  = new HashMap<>();
        List<String> list = new ArrayList<String>();
        list.add(beginWord);
        Queue<String> queue = new ArrayDeque<>();
        queue.offer(beginWord);
        path.put(beginWord,1);
        while (!queue.isEmpty()){
            String curStr = queue.poll();
            for (int i =0;i<curStr.length();i++){
                char[] chars = curStr.toCharArray();
                for (char c = 'a';c<='z';c++){
                    char oChar = chars[i];
                    if(oChar==c)
                        continue;
                    chars[i]=c;
                    String toStr = new String(chars);
                    if(dict.contains(toStr)&&path.get(toStr)==null){
                        path.put(toStr,path.get(curStr) + 1);
                        queue.add(toStr);
                    }
                }
            }
        }
        List<List<String>> res = new ArrayList<>();
        getPath(endWord,beginWord,new ArrayList<>(),path,dict,res);
        return res;
    }
    private void getPath(String curStr,String endWord,List<String> list, Map<String,Integer> path  ,   Set<String> dict,List<List<String>> res){
        if(curStr.equals(endWord)){
            list.add(curStr);
            Collections.reverse(list);
            res.add(list);
            return;
        }
        if(!path.containsKey(curStr)) return;
        list.add(curStr);
        int nextPath = path.get(curStr)-1;
        for(int i=0;i<curStr.length();i++) {
            char[] strCharArr = curStr.toCharArray();
            for(char ch='a';ch<='z';ch++) {
                if(strCharArr[i]==ch) {
                    continue;
                }
                strCharArr[i] = ch;
                String newWord = new String(strCharArr);
                //只相差一个字母同时这个单词所在的层数也是当前单词的上一层
                if(path.get(newWord)!=null&&(path.get(newWord)==nextPath)) {
                    ArrayList<String> newPathArray = new ArrayList<String>(list);
                    getPath(newWord,endWord,newPathArray,path,dict,res);
                }
            }
        }
    }
    public List<List<String>> findLadders1(String beginWord, String endWord, List<String> wordList){
        Set<String> dict = new HashSet<>(wordList);
        Set<String> usedDict  = new HashSet<>();
        List<String> list = new ArrayList<String>();
        list.add(beginWord);
        int[] min = new int[1];
        min[0]= Integer.MAX_VALUE;
        Map<Integer,List<List<String>> > res = new HashMap<>();

//        List<List<String>> res = new ArrayList<>();
        help(beginWord,endWord,dict,usedDict,list,min,res);
        return res.get(min[0]);
    }
    private void help(String curWord,String endWord,Set<String> dict,Set<String> usedDict,List<String> list,int[] min,Map<Integer,List<List<String>> > res ){
        if(curWord.equals(endWord)){
            if(list.size()<=min[0]){
                min[0]=list.size();
                if(res.containsKey(min[0])){
                    res.get(min[0]).add(new ArrayList<>(list));
                }else {
                    List<List<String>> listList = new ArrayList<>();
                    listList.add(new ArrayList<>(list));
                    res.put(min[0],listList);
                }
            }
            return;
        }else {
            char[] curStrCharArray = curWord.toCharArray();
            for (int i = 0; i <endWord.length() ; i++) {
                char oChar = curStrCharArray[i];
                for(char c='a';c<='z';c++){
                    curStrCharArray[i]=c;
                    String newStr = new String(curStrCharArray);
                    if(dict.contains(newStr)){
                        usedDict.add(newStr);
                        dict.remove(newStr);
                        list.add(newStr);
                        help(newStr,endWord,dict,usedDict,list,min,res);
                        list.remove(list.size()-1);
                        dict.add(newStr);
                    }
                }
                curStrCharArray[i]=oChar;
            }
        }
    }

    public List<List<String>> findLadders2(String beginWord, String endWord, List<String> wordList) {
//        List<Integer>[] p = new ArrayList[27];


        Map<String,List<Integer>> map = new HashMap<>();
        for (int i = 0; i < wordList.size(); i++) {
            String string = wordList.get(i);
            for(int j=0;j<beginWord.length();j++){
                String str = new StringBuilder(string).replace(j,j+1,"?").toString();
                if(map.containsKey(str)){
                    map.get(str).add(i);
                }else {
                    List<Integer> list  = new ArrayList<>();
                    list.add(i);
                    map.put(str,list);
                }
            }
        }
        int[] min = new int[1];
        min[0]= Integer.MAX_VALUE;
        List<String> list = new ArrayList<String>();
        list.add(beginWord);
        List<List<String>> res = new ArrayList<>();
        help(beginWord.toCharArray(),map,wordList,endWord.toCharArray(),min,list,res);

        for (int i = 0; i < res.size(); ) {
            if(res.get(i).size()>min[0]){
                res.remove(i);
            }else {
                i++;
            }
        }
        return res;
    }
    private void help(char[] dp,Map<String,List<Integer>> map,List<String> wordList,char[] endWord,int[] min,List<String> list,List<List<String>> res){
        if(isEqual(dp,endWord)) {
            //如果全部完成替换
            if(list.size()<=min[0]){
                min[0]=list.size();
                res.add(new ArrayList<>(list));
            }
            return;
        }
        if(map.size()==0||list.size()>min[0]) return;
        for (int i = 0; i <endWord.length ; i++) {
            char tempC = dp[i];
            dp[i]='?';
            String str = new String(dp);
            if(map.containsKey(str)){
                List<Integer> tempList = map.get(str);
                map.remove(str);
                for (Integer index: tempList
                     ) {
                    list.add(wordList.get(index));
                    help(wordList.get(index).toCharArray(),map,wordList,endWord,min,list,res);
                    list.remove(list.size()-1);
                }
                map.put(str,tempList);
            }
            dp[i]=tempC;
        }
    }
    private boolean isEqual(char[] a, char[] b){
        for (int i = 0; i < a.length; i++) {
            if(a[i]!=b[i]) return false;
        }
        return true;
    }


}
