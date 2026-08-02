class Solution {
    int[][] dp;
    public boolean stoneGame(int[] piles) {
        int sum = 0;
        dp = new int[piles.length+1][piles.length+1];
        for(int pile : piles){
            sum += pile;
        }

        int alice = solve(0, piles.length-1, piles);

        return alice > sum/2;
    }

    private int solve(int i, int j, int[] piles) {
        if(i > j){
            return 0;
        }
        if(dp[i][j] != 0){
            return dp[i][j];
        }

        int take_i = piles[i] + Math.min(solve(i+1, j-1, piles), solve(i+2, j, piles));
        int take_j = piles[j] + Math.min(solve(i, j-2, piles), solve(i+1, j-1, piles));
        return dp[i][j] = Math.max(take_j, take_i);
    }
}