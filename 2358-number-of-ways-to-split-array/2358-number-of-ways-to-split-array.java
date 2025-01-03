class Solution {
    public int waysToSplitArray(int[] nums) {
        int n = nums.length;
        long total = 0;
        for (int i = 0; i < n; i++) {
            total += nums[i];
        }
        int ans = 0;
        long lSum = 0;
        for (int i=0; i<n-1; i++){
            lSum += nums[i];
            total -= nums[i];
            if(lSum >= total){
                ans++;
            }
        }

        return ans;
    }
}