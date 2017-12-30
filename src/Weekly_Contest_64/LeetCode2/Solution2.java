import java.util.ArrayList;
import java.util.List;

/**
 * Created with Hehel
 * Description:
 * User: Hehel
 * Date: 2017-12-24
 * Time: 10:27
 */
public class Solution2 {
    public static void main(String[] args) {
        Solution2 solution2 = new Solution2();
        System.out.println(solution2.ipToCIDR("225.0.0.7", 10));
    }

    public List<String> ipToCIDR(String ip, int range) {
        long startIP = ip2Int(ip);
        long endIP = startIP + range - 1;
        System.out.println(Long.toBinaryString(startIP));
        System.out.println(Long.toBinaryString(endIP));
        int prefix_length = 32;
        long mask= ((long)1<<prefix_length);
        while (prefix_length >= 0) {
            mask >>=1;
            if ((startIP&mask) != (endIP& mask)) {
                break;
            } else {
                --prefix_length;
            }
        }
        List<String> res = new ArrayList<>();
        helper(startIP, endIP, (startIP>>prefix_length)<<prefix_length, prefix_length, res);
        return res;
    }

    String int2Binary(String str) {
        StringBuilder res = new StringBuilder();
        int val = 0;
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) != '.') {
                val *= 10;
                val += str.charAt(i) - '0';
            } else {
                res.append(Integer.toBinaryString(val));
            }
        }
        res.append(Integer.toBinaryString(val));
        return res.toString();
    }

    long ip2Int(String str) {
        long res = 0;
        int pre = 0;
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) == '.') {
                res = res << 8;
                res += Integer.parseInt(str.substring(pre, i++));
                pre = i;
            }
        }
        res = res << 8;
        res += Integer.parseInt(str.substring(pre, str.length()));
        return res;
    }

    String int2IP(long ip) {
        StringBuilder res = new StringBuilder();
        for (int i = 0; i < 4; i++) {
            long mod = ip % 256;
            res.insert(0, mod+".");
            ip >>= 8;
        }
        res.deleteCharAt(res.length()-1);
        return res.toString();
    }

    void helper(long start, long end, long prefix, long prefix_length, List<String> res) {
        long range_start = prefix;
        long range_end = prefix + ((long) 1 << prefix_length) - 1;
        if (start == range_start && end == range_end) {
            StringBuilder cidr = new StringBuilder(int2IP(prefix));
            cidr.append("/");
            cidr.append(32-prefix_length);
            res.add(cidr.toString());
            return;
        }
        long mid = prefix + ((long)1 << (prefix_length-1));
        if (end < mid) {
            helper(start, end, prefix, prefix_length - 1, res);
        } else if (start >= mid) {
            helper(start, end, mid, prefix_length - 1, res);
        } else {
            helper(start, mid - 1, prefix, prefix_length - 1, res);
            helper(mid, end, mid, prefix_length - 1, res);
        }
    }
}
