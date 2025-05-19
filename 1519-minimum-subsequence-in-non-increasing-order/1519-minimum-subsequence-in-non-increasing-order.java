import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Solution {
    public List<Integer> minSubsequence(int[] nums) {
        List<Integer> ret = new ArrayList<>();
        Arrays.sort(nums);
        int total = 0;
        for(int i : nums)
            total += i;
        int curr = 0;
        for(int i =nums.length-1; i>=0; i--) {
            ret.add(nums[i]);
            curr += nums[i];
            if(curr > (total - curr))
                break;
        }
        return ret;
    }
}