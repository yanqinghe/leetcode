
import java.util.*;

public class Solution127 {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        Set<String> dict = new HashSet<>(wordList);
        Set<String> userdict = new HashSet<>();
        Queue<String> queue = new ArrayDeque<>();

        queue.offer(beginWord);
        userdict.add(beginWord);
        int level = 0;
        int lastLevN = 1;
        int curLevN = 0;
        while (!queue.isEmpty()) {
            String curStr = queue.poll();
            lastLevN--;
            for (int i = 0; i < curStr.length(); i++) {

                char[] curCharArr = curStr.toCharArray();
                for (char j = 'a'; j <= 'z'; j++) {
                    curCharArr[i] = j;
                    String toStr = new String(curCharArr);
                    if (toStr.equals(endWord)) {
                        return level + 1;
                    }
                    if (dict.contains(toStr) && !userdict.contains(toStr)) {
                        curLevN++;
                        queue.offer(toStr);
                        userdict.add(toStr);
                    }
                }
            }
            if (lastLevN == 0) {
                level++;
                lastLevN = curLevN;
                curLevN = 0;
            }
        }
        return 0;

    }

    private void help(String curWord, String endWord, Set<String> dict, int num, int[] min) {
        if (curWord.equals(endWord)) {
            if (num <= min[0]) {
                min[0] = num;
            }
            return;
        } else {
            char[] curStrCharArray = curWord.toCharArray();
            for (int i = 0; i < endWord.length(); i++) {
                char oChar = curStrCharArray[i];
                for (char c = 'a'; c <= 'z'; c++) {
                    curStrCharArray[i] = c;
                    String newStr = new String(curStrCharArray);
                    if (dict.contains(newStr)) {
                        dict.remove(newStr);
//                        help(newStr,endWord,dict,min,res);
                        dict.add(newStr);
                    }
                }
                curStrCharArray[i] = oChar;
            }
        }
    }
}
