package Implement_strStr_28;


class Solution {
    public static void main(String[] args) {

    }

    public int strStr(String haystack, String needle) {
               if (needle.length() == 0) {
            return 0;
        }
        if (needle.length() > haystack.length()) {
            return -1;
        }
        // return haystack.indexOf(needle);
        boolean r = false;
        for (int i = 0; i <= haystack.length()-needle.length(); i++) {
            if (haystack.charAt(i) == needle.charAt(0)) {
                r =true;
                for (int j = 1; j < needle.length(); j++) {
                    if (haystack.charAt(i + j) != needle.charAt(j)) {
                        r = false;
                        break;
                    } 
                }
                if (r) {
                    return i;
                }
            }
        }
        return -1;
    }
}