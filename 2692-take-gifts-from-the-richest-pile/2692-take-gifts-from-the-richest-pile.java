class Solution {
    public long pickGifts(int[] gifts, int k) {
        Queue<Long> q = new PriorityQueue<>(Collections.reverseOrder());
        for(long i : gifts){
            q.add(i);
        }
        
        while(k-->0){
            long a = q.poll();
            q.add((long)Math.floor(Math.sqrt(a)));
        }

        long s= 0;
        while(!q.isEmpty()){
            s += q.poll();
        }
        return s;
    }
}