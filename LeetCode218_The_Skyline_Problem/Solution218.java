import java.util.*;

public class Solution218 {
    public static void main(String[] args) {
        Solution218 solution218 = new Solution218();
        solution218.getSkyline(new int[][]{{1,2,1},{1,2,2},{1,2,3}});
    }
    public List<int[]> getSkyline(int[][] buildings) {
        if(buildings==null||buildings.length<1) return new ArrayList<>();
        int currentBuiding = 0;
        int currentH =buildings[currentBuiding][2];
        int currentBUidingEnd = buildings[currentBuiding][1];
        Stack<Integer> stack = new Stack<>();
        Stack<Integer> buildingStack = new Stack<>();
        for (int i = buildings.length-1; i >0 ;i--) {
            buildingStack.push(i);
        }
        //初始化结果List
        List<int[]> res = new ArrayList<>();
        //向结果集中添加第一个建筑的点
        res.add(new int[]{buildings[0][0],currentH});
        while (!buildingStack.isEmpty()){
            int index = buildingStack.peek();
            if(currentBUidingEnd>=buildings[index][0]){
                //如果当前建筑与新的建筑出现重叠,首先将新建筑从未遍历建筑中剔除
                //因为当前高度没有发生变化，所以不用更新点的坐标
                buildingStack.pop();
                //然后当前建筑与新建筑建筑高度大小
                if(buildings[index][2]>currentH){
                    //如果新建筑高度大于当前高度,把当前的建筑添加到较矮建筑中
                    insert2Stack(stack,buildings,currentBuiding);
                    //更新高度
                    currentH = buildings[index][2];
                    currentBUidingEnd = buildings[index][1];
                    if(buildings[currentBuiding][0]==buildings[index][0]){
                        //如果开始就重合的话
                        res.get(res.size()-1)[1]=currentH;
                    }else {
                        //如果开始没有重合
                        res.add(new int[]{buildings[index][0],currentH});
                    }
                }else {

                    //如果新的建筑高度小于当前高度，把新的建筑添加到stack中
                    insert2Stack(stack,buildings,index);
                }
            }else {
                //如果当前建筑新建筑没有出现重叠，从候选建筑中选择新的建筑作为当前建筑
                while (!stack.isEmpty()){
                    //选择的需要选择没有end的
                    if(buildings[stack.peek()][1]>currentBUidingEnd) break;
                    else stack.pop();
                }
                if(stack.isEmpty()){
                    //如果候选建筑为空，选择新的建筑
                    //添加地平线
                    res.add(new int[]{currentBUidingEnd,0});
                    currentBuiding = buildingStack.pop();
                    currentBUidingEnd = buildings[currentBuiding][1];
                    currentH = buildings[currentBuiding][2];
                    //将新建筑的点添加进来
                    res.add(new int[]{buildings[currentBuiding][0],currentH});
                }else {
                    //如果下降到另外一个建筑
                    currentBuiding = stack.pop();
                    //当前建筑的高度
                    if(currentH>buildings[currentBuiding][2]){
                        currentH = buildings[currentBuiding][2];
                        //因为是从高高度下降到低高度，所以点坐标需要-1
                        res.add(new int[]{currentBUidingEnd,currentH});
                    }
                    //当前建筑的end
                    currentBUidingEnd =buildings[currentBuiding][1];
                }

            }
        }
        while (!stack.isEmpty()){
            if(buildings[stack.peek()][1]>currentBUidingEnd){
                //如果下降到另外一个建筑
                currentBuiding = stack.pop();
                //当前建筑的高度
                //当前建筑的高度
                if(currentH>buildings[currentBuiding][2]){
                    currentH = buildings[currentBuiding][2];
                    //因为是从高高度下降到低高度，所以点坐标需要-1
                    res.add(new int[]{currentBUidingEnd,currentH});
                }
                //当前建筑的end
                currentBUidingEnd =buildings[currentBuiding][1];
            }else {
                stack.pop();
            }

        }
        res.add(new int[]{currentBUidingEnd,0});
        return res;
    }

    /**
     * 向Stack中插入新元素，保证Stack处于生序排列
     * @param stack
     * @param buildings
     * @param bN
     */
    void insert2Stack(Stack<Integer> stack,int[][] buildings,int bN){
        if(stack.isEmpty()) stack.add(bN);
        else {
            Stack<Integer> newStack = new Stack<>();
            while (!stack.isEmpty()){
                if(buildings[stack.peek()][2]<=buildings[bN][2]){
                    if(buildings[stack.peek()][1]<=buildings[bN][1]){
                        stack.pop();
                    }else {
                        break;
                    }
                }else {
                    newStack.add(stack.pop());
                }
            }
            stack.add(bN);
            if(!newStack.isEmpty()&&buildings[newStack.peek()][1]>=buildings[stack.peek()][1]){
                stack.pop();
            }
            while (!newStack.isEmpty()){
                stack.add(newStack.peek());
            }
        }
    }
    public List<int[]> getSkyline2(int[][] buildings) {
        //初始化结果数组
        List<int[]> result = new ArrayList<>();
        //初始化高度List，List内的数组保存的是建筑的左右两点，和对应的高度
        //[左边点,-高度]，使用负高度的原因是方便排序和区分左右点
        //[右边点,高度]
        List<int[]> height = new ArrayList<>();
        for(int[] b:buildings) {
            height.add(new int[]{b[0], -b[2]});
            height.add(new int[]{b[1], b[2]});
        }
        //对高度list进行排序，排序的规则是如果两个点相同，比较高度，如果两个点不同，比较位置
        Collections.sort(height, new Comparator<int[]>(){
            public int compare(int[] a, int[] b) {
                if(a[0] != b[0]) return a[0] - b[0];
                return a[1] - b[1];
            }
        });

        //初始化优先队列
        Queue<Integer> pq = new PriorityQueue<>(new Comparator<Integer>(){
            public int compare(Integer a, Integer b) {
                return b - a;
            }
        });
        //将起始点
        pq.offer(0);
        //初始高度
        int prev = 0;
        for(int[] h:height) {
            if(h[1] < 0) {
                //如果当前高度为负数，说明为某个建筑的起始点,将高度添加进来。
                pq.offer(-h[1]);
            } else {
                //如果当前高度为正数，说明为某个建筑的结束点，说明该建筑已经结束，将对应的高度删除
                pq.remove(h[1]);
            }
            //获取目前高度
            int cur = pq.peek();
            if(prev != cur) {
                //如果当前点的高度与上一次遍历的时候点的高度不同，将当前点的高度加入到结果中
                //并修改Prev
                result.add(new int[]{h[0], cur});
                prev = cur;
            }
        }
        //返回结果数组
        return result;
    }
    public List<int[]> getSkyline3(int[][] buildings) {
        return merge(buildings, 0, buildings.length-1);
    }

    private LinkedList<int[]>merge(int[][] buildings, int lo, int hi){
        //分治的结果
        LinkedList<int[]> res = new LinkedList<>();
        if(lo > hi){
            //如果边界有误，返回空
            return res;
        } else if(lo == hi){
            //如果只有一个点，返回当前点
            res.add(new int[]{buildings[lo][0], buildings[lo][2]});
            res.add(new int[]{buildings[lo][1], 0});
            return res;
        }
        //取中间值
        int mid = lo+(hi-lo)/2;
        //递归
        LinkedList<int[]> left = merge(buildings, lo, mid);
        LinkedList<int[]> right = merge(buildings, mid+1, hi);
        int leftH = 0, rightH = 0;
        //如果左右两边的结果有不为空，
        while(!left.isEmpty() || !right.isEmpty()){
            //获取左右两边的高度，进行合并
            long x1 = left.isEmpty() ? Long.MAX_VALUE : left.peekFirst()[0];
            long x2 = right.isEmpty() ? Long.MAX_VALUE : right.peekFirst()[0];
            int x = 0;
            if(x1 < x2){
                int[] temp = left.pollFirst();
                x = temp[0];
                leftH = temp[1];
            }else if(x1 > x2){
                int[] temp = right.pollFirst();
                x = temp[0];
                rightH = temp[1];
            }else{
                x = left.peekFirst()[0];
                leftH = left.pollFirst()[1];
                rightH = right.pollFirst()[1];
            }
            int h = Math.max(leftH, rightH);
            if(res.isEmpty() || h!=res.peekLast()[1]){
                res.add(new int[]{x, h});
            }
        }
        //返回合并的结果
        return res;
    }

}
