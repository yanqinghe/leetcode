import java.util.Comparator;
import java.util.PriorityQueue;
/**
 * 
 * 
 * 15 / 18 test cases passed.
Status: Time Limit Exceeded
 */
class MedianFinder1 {

    PriorityQueue<Integer> integers ;
    double median = 0;
    /** initialize your data structure here. */
    public MedianFinder() {
        integers = new PriorityQueue<>();
    }
    
    public void addNum(int num) {
        integers.add(num);
        PriorityQueue<Integer> temp = new PriorityQueue<>();
        int size = integers.size();
        int curNum =0;
        int lastNum = 0;
        for(int i =0;i<=size/2;i++){
            lastNum= num;
            num = integers.poll();
            temp.add(num);
        }
        integers.addAll(temp);
        if((size&1)==0){
           this.median = ((double)num+(double)lastNum)/2.0;
        }else{
            this.median =  (double)num;
        }
    }
    
    public double findMedian() {
       return this.median;
    }
}
class MedianFinder {

    PriorityQueue<Integer> maxHeap ;
    PriorityQueue<Integer> minHeap;
    double median = 0;
    /** initialize your data structure here. */
    public MedianFinder() {
        minHeap = new PriorityQueue<>();
        maxHeap = new PriorityQueue<>(Collections.reverseOrder());
    }
    
    public void addNum(int num) {
        maxHeap.offer(num);
        minHeap.offer(maxHeap.poll());
        if(maxHeap.size() < minHeap.size()){
            maxHeap.offer(minHeap.poll());
        }      
    }
    
    public double findMedian() {
       return maxHeap.size()==minHeap.size()?(double)(maxHeap.peek()+minHeap.peek())/2.0:maxHeap.peek();
    }
}
/**
 * Your MedianFinder object will be instantiated and called as such:
 * MedianFinder obj = new MedianFinder();
 * obj.addNum(num);
 * double param_2 = obj.findMedian();
 */