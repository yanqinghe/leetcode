import java.util.HashSet;
import java.util.Set;

public class Solution804 {
    private final static String[] array = {  ".-","-...","-.-.","-..",".","..-.","--.","....","..",".---","-.-",".-..","--","-.","---",".--.","--.-",".-.","...","-","..-","...-",".--","-..-","-.--","--.."};
    public int uniqueMorseRepresentations(String[] words) {
        Set<String> stringSet = new HashSet<>();
        for (String word : words) {
            StringBuilder stringBuilder = new StringBuilder();
            for (int i = 0; i < word.length(); i++) {
                stringBuilder.append(array[word.charAt(i)-'a']);
            }
            stringSet.add(stringBuilder.toString());
        }
        return stringSet.size();
    }
}
