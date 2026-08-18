class Solution {
    public int largestInteger(int[] nums, int k) {
        int[] freq = new int[51];
        int n = nums.length;
        for(int i=0; i<n;i++){
            freq[nums[i]]++;
        }

        int max = -1;
        for (int i = 0; i < n; i++) {
            if(k==n  || (freq[nums[i]] == 1 && (i==0 || k == 1 || i==n-1)))
                max = Math.max(max, nums[i]);
        }

        return max;
    }
}