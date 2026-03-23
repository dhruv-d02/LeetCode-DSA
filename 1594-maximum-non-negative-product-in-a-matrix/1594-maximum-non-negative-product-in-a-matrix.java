class Solution {
    public int maxProductPath(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        long[][] max = new long[m][n];
        long[][] min = new long[m][n];
        int MOD = 1000000007;

        max[0][0] = grid[0][0];
        min[0][0] = grid[0][0];

        for(int i=1; i<m; i++) {
            max[i][0] = min[i][0] = max[i-1][0]*grid[i][0];
        }
        for(int i=1; i<n; i++) {
            min[0][i] = max[0][i] = min[0][i-1]*grid[0][i];
        }

        for(int i=1; i<m; i++){
            for (int j=1; j<n; j++){
                long x = grid[i][j];

                long a = max[i - 1][j] * x;
                long b = min[i - 1][j] * x;
                long c = max[i][j - 1] * x;
                long d = min[i][j - 1] * x;

                max[i][j] = Math.max(Math.max(a, b), Math.max(c, d));
                min[i][j] = Math.min(Math.min(a, b), Math.min(c, d));
            }
        }

        if(max[m-1][n-1] < 0)
            return -1;
        return (int) (max[m-1][n-1]%MOD);
    }
}