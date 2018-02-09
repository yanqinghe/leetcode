
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

public class Solution71 {
    public static void main(String[] args) {
        Solution71 solution71 = new Solution71();
        System.out.println("args = [" + solution71.simplifyPath("/a/./b/../../c/") + "]");
    }

    public String simplifyPath(String path) {
        StringBuilder stringBuilder = new StringBuilder();
        String[] strings = path.split("/");
        List<String> list = new LinkedList<>();
        for (String str : strings
                ) {
            if (str.equals("") || str.equals(".")) {
                continue;
            }
            if (str.equals("..")) {
                if (!list.isEmpty()) {
                    //如果list不为空，那么移除栈顶元素
                    list.remove(list.size() - 1);
                }
                continue;
            }
            list.add(str);
        }
        //根目录
        stringBuilder.append('/');
        for (String str : list
                ) {
            stringBuilder.append(str + '/');
        }
        if (stringBuilder.length() > 1) {
            stringBuilder.deleteCharAt(stringBuilder.length() - 1);
        }
        return stringBuilder.toString();
    }
}

