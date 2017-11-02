package LeetCode57_Insert_Interval;

import java.util.LinkedList;
import java.util.List;

public class Solution57 {
    class Interval {
        int start;
        int end;

        Interval() {
            start = 0;
            end = 0;
        }

        Interval(int s, int e) {
            start = s;
            end = e;
        }
    }

    public List<Interval> insert(List<Interval> intervals, Interval newInterval) {
        List<Interval> result = new LinkedList<>();
        if (intervals == null || intervals.size() < 1) {
            result.add(newInterval);
            return result;
        }
        if (newInterval == null) {
            return intervals;
        }
        boolean b = false;
        for (int i = 0; i < intervals.size(); i++) {
            if ((!b) && newInterval.start <= intervals.get(i).end) {
                if (newInterval.end < intervals.get(i).start) {
                    //不存在重叠的部分
                    result.add(newInterval);
                    b = true;
                } else {
                    newInterval.end = Math.max(newInterval.end, intervals.get(i).end);
                    newInterval.start = Math.min(newInterval.start, intervals.get(i).start);
                    continue;
                }
            }
            result.add(intervals.get(i));
        }
        if (!b) {
            result.add(newInterval);
        }
        return result;


    }
}
