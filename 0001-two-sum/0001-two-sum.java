import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

class Solution {
    public int[] twoSum(int[] nums, int target) {
        int[] ans = new int[2];
        HashMap<Integer, List<Integer>> idxMap = new HashMap<>();
        for(int i=0; i< nums.length; i++) {
            idxMap.put(nums[i], idxMap.getOrDefault(nums[i], new ArrayList<>()));
            idxMap.get(nums[i]).add(i);
        }
        for(int i=0; i< nums.length; i++)
        {
            idxMap.get(nums[i]).remove(0);
            if(idxMap.get(nums[i]).isEmpty())
                idxMap.remove(nums[i]);
            if(idxMap.get(target - nums[i]) != null)
            {
                ans[0] = i;
                ans[1] = idxMap.get(target-nums[i]).get(0);
                return ans;
            }
            
        }
        return ans;
    }
}