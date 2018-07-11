public class Solution557 {
    public String reverseWords(String s) {
       char[] chars = s.toCharArray();
       int left =0,right = 0;
       char temp;
       for (int i = 0; i < chars.length; i++) {
            if(chars[i]==' '){
                right=i-1;
                while (left<right){
                    temp=chars[left];
                    chars[left]=chars[right];
                    chars[right]=temp;
                    left++;
                    right--;
                }
                left=i+1;
            }
        }
        right=chars.length-1;
        while (left<right){
            temp=chars[left];
            chars[left]=chars[right];
            chars[right]=temp;
            left++;
            right--;
        }
        return String.valueOf(chars);
    }
}
