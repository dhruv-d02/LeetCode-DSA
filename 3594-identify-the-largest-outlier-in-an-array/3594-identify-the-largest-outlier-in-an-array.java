import java.util.HashMap;

class Solution {
    public int getLargestOutlier(int[] nums) {
        int total = 0;
        HashMap<Integer, Integer> map = new HashMap<>();
        for(int n : nums){
            total += n;
            map.put( n, map.getOrDefault(n,0)+1);
        }
        int largestOutlier = Integer.MIN_VALUE;
        for(int i=0; i<nums.length; i++){
            int curr_outlier = nums[i];
            int temp = total - curr_outlier;
            if(temp%2 == 0){
                if(map.get(curr_outlier) != null && map.get(curr_outlier) != 0){
                    map.put(curr_outlier, map.get(curr_outlier)-1);
                }
                int x = temp/2;
                if(map.get(x) != null && map.get(x) != 0){
                    largestOutlier = Math.max(curr_outlier, largestOutlier);
                }
                map.put(curr_outlier, map.get(curr_outlier)+1);
            }
        }
        return largestOutlier;

    }
}