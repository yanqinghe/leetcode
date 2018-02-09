
import javax.print.DocFlavor;
import java.util.ArrayList;
import java.util.List;

public class Solution93 {
    List<String> res = new ArrayList<>();

    public List<String> restoreIpAddresses(String s) {
        if (s == null || s.length() < 4 || s.length() > 12) {
            return res;
        }
        help(s, new int[4], 0, 0);
        return res;
    }

    private void help(String s, int[] nums, int index, int count) {
        if (count == 4) {
            if (index == s.length()) {
                StringBuilder sb = new StringBuilder();
                sb.append(nums[0]);
                for (int i = 1; i < 4; i++) {
                    sb.append('.');
                    sb.append(nums[i]);
                }
                res.add(sb.toString());
            }
            return;
        }
        nums[count] = 0;
        for (int i = 0; i < 3; i++) {
            if (index + i < s.length()) {
                nums[count] = nums[count] * 10 + s.charAt(index + i) - '0';
                if (nums[count] < 256) {
                    help(s, nums, index + 1 + i, count + 1);
                }
                if (nums[count] == 0 && i == 0) {
                    return;
                }
            }
        }
    }
}
