class Solution {
    public int maxArea(int[] height) {
        int l = 0;
        int r = height.length - 1;
        int ans = Integer.MIN_VALUE;
        while (l < r){
            int minHeight = Math.min(height[l], height[r]);
            ans = Math.max(ans, minHeight*(r-l));
            //Go to next height greater than minHeight
            while (l < r && height[l] <= minHeight) {
                l++;
            }
            while (l < r && height[r] <= minHeight) {
                r--;
            }
        }
        return ans;
    }
}