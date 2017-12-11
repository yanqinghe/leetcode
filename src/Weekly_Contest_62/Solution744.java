package Weekly_Contest_62;

public class Solution744 {
    public char nextGreatestLetter(char[] letters, char target) {
        for (int i = letters.length-1; i >=0; i--) {
            //从后向前遍历整个数组
            if(letters[i]<=target){
                //如果大于target大于或等于当前的元素，说明前一个元素是符合要求的，这里需要考虑循环的问题
                if(i==letters.length-1) return letters[0];
                else return letters[i+1];
            }
        }
        //如果遍历完都没有返回，就返回第一个元素
        return letters[0];
    }
}
