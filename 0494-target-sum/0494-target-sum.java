class Solution {
    int cnt;
    public int findTargetSumWays(int[] nums, int target) {
        cnt = 0;
        traverse(nums, target, 0, 0);
        return cnt;
    }

    private void traverse(int[] nums, int target, int sum, int i) {
        if(i == nums.length){
            if(sum == target){
                cnt++;
            }
            return;
        }

        traverse(nums,target, sum + nums[i], i+1);
        traverse(nums,target, sum - nums[i], i+1);
    }
}