public class Solution389 {
    public char findTheDifference(String s, String t) {
        int[] cnt = new int[26];
        for (char c : t.toCharArray()) {
            cnt[c-'a']++;
        }
        for (char c : s.toCharArray()) {
            cnt[c-'a']--;
        }
        for (int i = 0; i < 26; i++) {
            if(cnt[i]!=0) return (char)( i+'a');
        }
        return 'a';
    }
}
