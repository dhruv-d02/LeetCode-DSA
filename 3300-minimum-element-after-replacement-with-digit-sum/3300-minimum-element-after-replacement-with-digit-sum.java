class Solution {
    public int minElement(int[] nums){
        int ans = Integer.MAX_VALUE;
        for(int n : nums){
            ans = Math.min(ans, findSum(n));
        }
        return ans;
    }

    private int findSum(int n) {
        int sum =  0;
        while (n > 0){
            sum += n%10;
            n = n/10;
        }
        return sum;
    }
}