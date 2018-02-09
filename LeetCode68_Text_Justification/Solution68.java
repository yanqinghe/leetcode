
import java.util.LinkedList;
import java.util.List;

public class Solution68 {
    public List<String> fullJustify(String[] words, int maxWidth) {

        List<String> result = new LinkedList<>();
        if (words == null || words.length < 1) {
            return result;
        }
        int start = 0;
        int num = 1;//元素的个数
        int sum = words[0].length();//元素累加的长度，包括空格
        for (int i = 1; i < words.length; i++) {
            if (sum + num + words[i].length() > maxWidth) {
                //如果加上当前元素越界的话，或者是到最后一个元素的话
                StringBuilder sb = new StringBuilder();
                if (num == 1) {
                    //如果只包含一个元素。
                    int blank = maxWidth - sum;
                    sb.append(words[start]);
                    for (int j = 0; j < blank; j++) {
                        sb.append(' ');
                    }
                } else {
                    //包含多个元素
                    //获取空格的个数
                    int blank = maxWidth - sum;
                    //获取元素的个数
                    //多余的空格数
                    int blankHelp = blank % (num - 1);
                    blank /= (num - 1);
                    //形成空格数组
                    int[] n = new int[num];
                    for (int j = 0; j < num - 1; j++) {
                        if (blankHelp-- > 0) {
                            n[j] = blank + 1;
                        } else {
                            n[j] = blank;
                        }
                    }
                    n[num - 1] = 0;
                    for (int j = start; j < i; j++) {
                        sb.append(words[j]);
                        for (int k = 0; k < n[j - start]; k++) {
                            sb.append(' ');
                        }
                    }
                }
                result.add(sb.toString());
                sum = words[i].length();//长度
                start = i;//重置起始位置
                num = 1;//清空个数

            } else {
                //如果不越界的话
                sum = sum + words[i].length();
                num++;
            }
        }
        StringBuilder sb = new StringBuilder();
        if (sum + num - 1 <= maxWidth) {

            for (int i = start; i < words.length - 1; i++) {
                sb.append(words[i]);
                sb.append(' ');
            }
            sb.append(words[words.length - 1]);
            for (int i = sum + num - 1; i < maxWidth; i++) {
                sb.append(' ');
            }
        }
        result.add(sb.toString());
        return result;

    }

}

