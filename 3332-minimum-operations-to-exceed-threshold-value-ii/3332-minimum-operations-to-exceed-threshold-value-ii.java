import java.util.PriorityQueue;

class Solution {
    public int minOperations(int[] nums, int k) {
        PriorityQueue<Long> pq = new PriorityQueue<>();
        for(int num : nums){
            pq.offer((long) num);
        }
        int opCnt = 0;
        while (pq.peek() < k && pq.size() > 1){
            long x = pq.poll();
            long y = pq.poll();
            pq.offer(Math.min(x, y) * 2 + Math.max(x, y));
            opCnt++;
        }
        return opCnt;
    }
}