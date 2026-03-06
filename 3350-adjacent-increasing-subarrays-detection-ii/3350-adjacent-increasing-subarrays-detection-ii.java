class Solution {
    public int maxIncreasingSubarrays(List<Integer> nums) {
        int n = nums.size();
        int maxK = 0, prev = 0, curr = 1;        
        // walk through and track the length of increasing runs
        for (int i = 1; i < n; i++) {
            if (nums.get(i) > nums.get(i - 1)) {
                // still climbing the hill
                curr++;
            } else {
                // hit a break! time to calculate what we can get
                // option 1: split the current run in half
                // option 2: use prev run + current run back-to-back
                maxK = Math.max(maxK, Math.max(curr / 2, Math.min(prev, curr)));
                
                // current run becomes the previous for next iteration
                prev = curr;
                curr = 1;  // reset for new run
            }
        }        
        // don't forget the last run (no break at the end to trigger calculation)
        maxK = Math.max(maxK, Math.max(curr / 2, Math.min(prev, curr)));        
        return maxK;
    }
}