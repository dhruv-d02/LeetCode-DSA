import java.util.HashMap;

class Solution {
    public int maxSubarrayLength(int[] nums, int k) {
        HashMap<Integer, Integer> map = new HashMap<>();

        int start = 0, curr = 0;
        int longestSubArrayLen = 0;
        while (curr < nums.length){
            map.put(nums[curr], map.getOrDefault(nums[curr], 0) + 1);
            while (map.getOrDefault(nums[curr], 0) > k){
                map.put(nums[start], map.get(nums[start]) - 1);
                start++;
            }

            longestSubArrayLen = Math.max(longestSubArrayLen, curr - start);
            curr++;
        }
        return longestSubArrayLen+1;
    }
}