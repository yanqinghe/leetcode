import java.awt.geom.QuadCurve2D;
import java.util.*;

/**
 * Created with Hehel
 * Description:
 * User: Hehel
 * Date: 2017-12-24
 * Time: 10:27
 */
public class Solution3 {
    public static void main(String[] args) {
        Solution3 solution3 = new Solution3();
        String[] strings = {"0201","0101","0102","1212","2002"};

        System.out.println(solution3.openLock(strings,"0202"));
    }
    public int openLock(String[] deadends, String target) {
        Map<String,Integer> map = new HashMap<>();
        Set<String> has = new HashSet<>();
        Queue<String> queue = new LinkedList<>();
        for(String deadend:deadends){
            has.add(deadend);
        }
        queue.add("0000");
        map.put("0000",0);
        while (!queue.isEmpty()){
            String font = queue.poll();
            if(has.contains(font)) continue;

            for (int i = 0; i < 4; i++) {
                for (int j = -1; j <=1; j+=2) {
                    char[] chars = font.toCharArray();
                    chars[i]+=j;
                    if(chars[i]>'9') chars[i]-=10;
                    if(chars[i]<'0') chars[i]+=10;
                    String res = new String(chars);
                    if(map.containsKey(res))  continue;
                    map.put(res,map.get(font)+1);
                    queue.add(res);
                }
            }
        }
        if(map.containsKey(target)) return map.get(target);
        else return -1;
    }

}
