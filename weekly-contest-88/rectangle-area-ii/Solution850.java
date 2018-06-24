import java.lang.reflect.Array;
import java.util.*;

public class Solution850 {
    final static int MOD = 1000000007;

    class Point{
        int x = 0;
        int y =0;
        int v = 0;
        final static int START_ADD=0;
        final static int START_SUB=1;
        final static int END_ADD=2;
        final static int END_SUB=3;

        public Point(int x, int y, int v) {
            this.x = x;
            this.y = y;
            this.v = v;
        }
    }
    public int rectangleArea(int[][] rectangles) {
        List<Point> data = new ArrayList<>();
        for (int[] r : rectangles) {
            data.add(new Point(r[0], r[1], Point.START_SUB));
            data.add(new Point(r[0], r[3], Point.START_ADD));
            data.add(new Point(r[2], r[1], Point.END_SUB));
            data.add(new Point(r[2], r[3], Point.END_ADD));
        }
        Collections.sort(data, (a, b) -> {
            if (a.x == b.x) {
                return b.y - a.y;
            }
            return a.x - b.x;
        });
//
    return 0;
    }
}
