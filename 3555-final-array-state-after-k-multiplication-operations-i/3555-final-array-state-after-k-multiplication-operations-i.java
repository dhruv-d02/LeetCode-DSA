import java.util.Comparator;
import java.util.PriorityQueue;

class Solution {
    public int[] getFinalState(int[] nums, int k, int multiplier) {
        PriorityQueue<int[]> pq = new PriorityQueue<int[]>(new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                if(o1[0] == o2[0]){
                    return o1[1] - o2[1];
                }
                return o1[0]-o2[0];
            }
        });
        for (int i=0; i<nums.length; i++){
            pq.offer(new int[]{nums[i], i});
        }
        while (k > 0){
            int[] min = pq.poll();
            min[0] *= multiplier;
            pq.offer(min);
            k--;
        }
        while (!pq.isEmpty()){
            int[] min = pq.poll();
            nums[min[1]] = min[0];
        }
        return nums;
    }
}