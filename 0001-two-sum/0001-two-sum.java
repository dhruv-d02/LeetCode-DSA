import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

class Solution {
    public int[] twoSum(int[] nums, int target) {
        int[] ans = new int[2];
        HashMap<Integer, Integer> idxMap = new HashMap<>();
        for (int i =0; i<nums.length; i++)
        {
            if(idxMap.containsKey(target-nums[i]))
            {
                ans[0] = i;
                ans[1] = idxMap.get(target - nums[i]);
            }
            idxMap.put(nums[i], i);
        }
        return ans;
    }
}