class Solution {
    public int maxAdjacentDistance(int[] nums) {
        int diff = Integer.MIN_VALUE;
        for(int i=1; i<nums.length; i++){
            diff = Math.max(diff, Math.abs(nums[i] - nums[i-1]));
        }

        return Math.max(diff, Math.abs(nums[nums.length - 1] - nums[0]));
    }
}