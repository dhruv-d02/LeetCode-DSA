import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

class Solution {
    public long findScore(int[] nums) {
        long score = 0;
        PriorityQueue<int[]> pq = new PriorityQueue<>(new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                if(o1[0] == o2[0]){
                    return o1[1] - o2[1];
                }
                return o1[0] - o2[0];
            }
        });
        for (int i = 0; i < nums.length; i++) {
            pq.add(new int[]{nums[i], i});
        }
        int[] marked = new int[nums.length];
        while (!pq.isEmpty()){
            int[] min = pq.poll();
            if(marked[min[1]] == 1){
                continue;
            }
            score += min[0];
            marked[min[1]] = 1;
            if(min[1] - 1 >=0){
                marked[min[1] - 1] = 1;
            }
            if(min[1] + 1 < nums.length){
                marked[min[1] + 1] = 1;
            }
        }
        return score;
    }
}