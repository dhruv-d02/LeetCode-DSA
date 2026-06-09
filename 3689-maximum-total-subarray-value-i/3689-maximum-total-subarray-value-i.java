class Solution {
    public long maxTotalValue(int[] nums, int k) {
        int max = nums[0], min = nums[0];

        for(int num : nums){
            max = Math.max(num, max);
            min = Math.min(num, min);
        }

        return (long)(max-min)*k;
    }
}