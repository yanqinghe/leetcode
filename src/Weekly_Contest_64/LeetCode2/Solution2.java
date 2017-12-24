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
        System.out.println(solution2);
    }
    public List<String> ipToCIDR(String ip, int range) {
        long start = ip2Int(ip);
        long endIp = start+range-1;
        long prefix_length = 0;
        while (prefix_length <= 31) {
            int mask = 1 << (31 - prefix_length);
            if ((mask & endIp)==0) {
                break;
            }
            else {
                ++prefix_length;
            }
        }
        List<String> res = new ArrayList<>();
        helper(start,endIp,0,prefix_length,res);
        return res;
    }

    long ip2Int(String str){
        long res = 0;
        String[] strings = str.split(".");
        for (String s:strings
             ) {
            res = res<<8;
            res+=Integer.parseInt(s);
        }
        return res;
    }
    String int2IP(long ip){
        StringBuilder res = new StringBuilder();
        for (int i = 0; i <4 ; i++) {
            long mod = ip%256;
            res.append(mod+"");
            ip>>=8;
        }
        return res.toString();
    }
    void helper(long start, long end, long prefix, long prefix_length, List<String> res) {
        long range_start = prefix;
        long range_end = prefix + ((long)1 << (32 - prefix_length)) - 1;
        if (start == range_start && end == range_end) {
            StringBuilder cidr= new StringBuilder(int2IP(prefix));
            cidr.append("/");
            cidr.append(prefix_length+"");
            res.add(cidr.toString());
            return;
        }
        long prefix_1 = prefix + (1 << (31 - prefix_length));
        if (end < prefix_1) {
            helper(start, end, prefix, prefix_length + 1, res);
        }
        else if(start >= prefix_1){
            helper(start, end, prefix_1, prefix_length + 1, res);
        }
        else {
            helper(start, prefix_1 - 1, prefix, prefix_length + 1, res);
            helper(prefix_1, end, prefix_1, prefix_length + 1, res);
        }
    }
}
