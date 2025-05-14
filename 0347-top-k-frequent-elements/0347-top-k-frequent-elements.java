class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for(int i : nums){
            map.put(i, map.getOrDefault(i, 0)+1);
        }
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> b[1] - a[1]);
        for(Map.Entry<Integer, Integer> entry : map.entrySet()){
            pq.offer(new int[]{entry.getKey(), entry.getValue()});
        }
        int[] ret = new int[k];
        for(int i=0; i<k; i++){
            ret[i] = pq.poll()[0];
        }
        return ret;
    }
}