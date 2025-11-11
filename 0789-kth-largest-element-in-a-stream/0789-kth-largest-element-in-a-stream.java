class KthLargest {
    
    PriorityQueue<Integer> q = new PriorityQueue<>(); // Space-:O(K)
    int k;

    public KthLargest(int k, int[] nums) {
        //Kth largest  means largest element at k position. 
        this.k=k;
        // Time-: O(n*logn) for intitalization
        for(int i:nums){
            q.offer(i);
        }

        while(q.size()>k) q.poll();
        

    }
    
    public int add(int val) {
        
        // System.out.println(q);
        q.add(val);//Time-:O(logn)
        while(q.size()>k)//  Nearly Constant
        q.poll();
        // System.out.println(q);
        return q.peek();
        
    }
}

/**
 * Your KthLargest object will be instantiated and called as such:
 * KthLargest obj = new KthLargest(k, nums);
 * int param_1 = obj.add(val);
 */