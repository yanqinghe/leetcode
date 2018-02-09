
import java.util.ArrayList;
import java.util.List;

public class Solution119 {
    public List<Integer> getRow(int rowIndex) {
        int length = rowIndex + 1;
        List<Integer> res = new ArrayList<>(length);
        res.add(1);
        int half = rowIndex / 2;
        long val = rowIndex;
        for (int i = 1; i <= half; i++) {
            res.add((int) val);
            val = val * (rowIndex - i) / (i + 1);
        }
        for (int i = half - (1 - (rowIndex & 1)); i >= 0; i--)
            res.add(res.get(i));
        return res;
    }
}
