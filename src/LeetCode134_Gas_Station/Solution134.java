package LeetCode134_Gas_Station;

public class Solution134 {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        if (gas.length == 1 && cost.length == 1) {
            return gas[0] - cost[0] >= 0 ? 0 : -1;
        }
        int start = 0;
        int end = 1;
        int gasStock = gas[0] - cost[0];
        while (start != end) {
            if (gasStock >= 0) {
                gasStock += gas[end] - cost[end];
                end++;
                if (end == gas.length) end = 0;
            } else {
                start--;
                if (start == -1) start = gas.length - 1;
                gasStock += gas[start] - cost[start];
            }
        }
        if (gasStock >= 0) {
            return start;
        } else {
            return -1;
        }
    }
}
