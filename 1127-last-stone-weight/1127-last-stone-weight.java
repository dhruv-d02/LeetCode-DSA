import java.util.Collections;
import java.util.PriorityQueue;

class Solution {
    public int lastStoneWeight(int[] stones) {
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        for(int stone : stones){
            pq.offer(stone);
        }
        
        while (pq.size() > 1){
            int y = pq.poll(); //heaviest stone
            int x = pq.poll(); //second heaviest stone
            if(x != y){
                pq.offer(y - x);
            }
        }
        return pq.size() > 0 ? pq.poll() : 0;
    }
}