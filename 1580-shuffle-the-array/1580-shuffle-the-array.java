class Solution {
    public int[] shuffle(int[] nums, int n) {
        int i = 0, j = n;
        int[] ret = new int[nums.length];
        int k = 0;
        while (j<nums.length){
            ret[k] = nums[i];
            i++;
            k++;
            ret[k] = nums[j];
            j++;
            k++;
        }
        return ret;
    }
}