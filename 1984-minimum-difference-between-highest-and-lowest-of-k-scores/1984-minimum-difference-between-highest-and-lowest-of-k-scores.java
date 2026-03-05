import java.util.Arrays;
import java.util.Map;

class Solution {
    public int minimumDifference(int[] nums, int k) {
        Arrays.sort(nums);
        int left =0;
        int ans = Integer.MAX_VALUE;
        while (nums.length - left  >= k){
            ans = Math.min(ans, nums[left+k-1] - nums[left]);
            left++;
        }
        return ans;
    }
}