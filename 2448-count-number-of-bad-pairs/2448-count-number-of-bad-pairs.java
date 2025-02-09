import java.util.HashMap;

class Solution {
    public long countBadPairs(int[] nums) {
        HashMap<Integer, Integer> map = new HashMap<>();
        long count = 0;
        for(int i=0; i<nums.length; i++){
            int d = nums[i]-i;
            count += map.getOrDefault(d, 0);
            map.put(d, map.getOrDefault(d, 0)+1);
        }
        int n = nums.length;
        return ((1L*n*(n-1))/2) - count;
    }
}