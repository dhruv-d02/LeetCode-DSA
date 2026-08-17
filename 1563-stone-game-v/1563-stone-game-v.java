class Solution {
    int[] prefixSum;
    int[][] dp;
    public int stoneGameV(int[] stoneValue) {
        int max = 0;
        dp = new int[501][501];

        prefixSum = new int[stoneValue.length];
        prefixSum[0] = stoneValue[0];
        for (int i = 1; i < stoneValue.length; i++) {
            prefixSum[i] = prefixSum[i-1] + stoneValue[i];
        }


        return solve(0, stoneValue.length-1);
    }

    private int solve(int l, int r){

        int max = 0;
        if(dp[l][r] > 0)
            return dp[l][r];
        for (int mid=l; mid<=r-1; mid++){
            int lSum = prefixSum[mid] - (l-1>=0 ? prefixSum[l-1] : 0);
            int rSum = prefixSum[r] - prefixSum[mid];


            if(lSum < rSum){
                max = Math.max(max, solve(l, mid) + lSum);
            }else if(lSum > rSum){
                max = Math.max(max, solve(mid+1, r) + rSum);
            }else{
                max = Math.max(max, Math.max(solve(l, mid)+lSum, solve(mid+1, r)+rSum));
            }
        }
        return dp[l][r] = max;
    }


}