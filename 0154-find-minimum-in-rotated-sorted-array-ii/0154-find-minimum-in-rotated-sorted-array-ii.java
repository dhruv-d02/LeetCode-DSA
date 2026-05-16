class Solution {
    public int findMin(int[] nums) {
        return find(nums, 0, nums.length - 1);
    }

    private int find(int[] nums, int start, int end) {
        int mid = start + (end - start)/2;
        if(start == end){
            return nums[start];
        }

        if(nums[start] < nums[end]){
            return nums[start];
        }
        
        return Math.min(find(nums, start, mid), find(nums, mid+1, end));
    }
}