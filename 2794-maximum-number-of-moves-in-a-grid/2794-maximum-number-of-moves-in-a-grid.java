class Solution {
    int[][] dp;
    public int maxMoves(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        dp = new int[m][n];
        int ans = 0;

        for(int i=0; i<m; i++){
            ans = Math.max(ans,traverse(i, 0, grid));
        }
        return ans;
    }

    private int traverse(int i, int j, int[][] grid) {
        if(j == grid[0].length-1){
            return dp[i][j];
        }
        if(dp[i][j] != 0){
            return dp[i][j];
        }
        if(i > 0 && grid[i-1][j+1] > grid[i][j]){
            dp[i][j] = Math.max(dp[i][j], traverse(i-1, j+1, grid)+1);

        }
        if(grid[i][j+1] > grid[i][j]){
            dp[i][j] = Math.max(dp[i][j], traverse(i, j+1, grid)+1);
        }
        if(i < grid.length -1 && grid[i+1][j+1] > grid[i][j]){
            dp[i][j] = Math.max(dp[i][j], traverse(i+1, j+1, grid)+1);
        }
        return dp[i][j];
    }
}