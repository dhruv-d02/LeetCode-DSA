class Solution {
    public int[][] kClosest(int[][] points, int k) {
        PriorityQueue<Integer> pq = new PriorityQueue<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer i, Integer j) {
                return -(points[i][0]*points[i][0] + points[i][1]*points[i][1]) + (points[j][0]*points[j][0] + points[j][1]*points[j][1]);
            }
        });
        for(int i=0; i<points.length; i++){
            pq.offer(Math.abs(i));
        }
        while (pq.size() > k){
            pq.poll();
        }
        int[][] ret = new int[pq.size()][2];
        int id = 0;
        while (!pq.isEmpty()){
            int kIdx = pq.poll();
            int[] arr = new int[]{points[kIdx][0], points[kIdx][1]};
            ret[id] = arr;
            id++;
        }
        return ret;
    }
}