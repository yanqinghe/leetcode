public class Solution541 {
    public static void main(String[] args) {
        Solution541 solution541 = new Solution541();
        System.out.println(solution541.reverseStr("abcd",4));
    }
    public String reverseStr(String s, int k) {
        char[] chars =  s.toCharArray();
        int len = chars.length;
        char temp;
        for (int i = 0; i < len; i+=2*k) {
            int jMax = Math.min(k,len-i);
            int left = i,right = jMax+i-1;
            while (left<right){
                temp=chars[left];
                chars[left]=chars[right];
                chars[right]=temp;
                left++;
                right--;
            }
        }
        return String.valueOf(chars);
    }
}
