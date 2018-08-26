import java.util.*;

public class FreqStack {

    TreeMap<Integer,List<Integer>> map = new TreeMap<>();
    Map<Integer,Integer> freq = new HashMap<>();
    public FreqStack() {

    }

    public void push(int x) {
        int xFreq = freq.getOrDefault(x,0)+1;
        map.computeIfAbsent(xFreq,key->new ArrayList<>()).add(x);
        freq.put(x,xFreq);
    }

    public int pop() {
        Map.Entry<Integer, List<Integer>> entry = map.floorEntry(Integer.MAX_VALUE);
        List<Integer> values = entry.getValue();
        int ret = values.remove(values.size() - 1);
        freq.put(ret, freq.getOrDefault(ret, 0) - 1);
        if (values.isEmpty()) {
            map.remove(entry.getKey());
        }
        return ret;
    }

    public static void main(String[] args) {
        FreqStack freqStack = new FreqStack();
        freqStack.push(5);
        freqStack.push(7);
        freqStack.push(5);

        freqStack.push(7);
        freqStack.push(4);
        freqStack.push(5);
        freqStack.pop();
        freqStack.pop();
        freqStack.pop();
        freqStack.pop();
        freqStack.pop();


    }
}
