class Solution {
    public boolean isMonotonic(int[] nums) {
        boolean increasing = true;
        int j = 1;
        while (j<nums.length){
            if(nums[j] < nums[j-1]) {
                increasing = false;
                break;
            }else if(nums[j] > nums[j-1]) {
                increasing = true;
                break;
            }
            j++;
        }

        for (int i = 1; i < nums.length; i++) {
            if(increasing){
                if(nums[i] < nums[i-1])
                    return false;
            }else{
                if(nums[i] > nums[i-1])
                    return false;
            }
        }
        return true;
    }
}