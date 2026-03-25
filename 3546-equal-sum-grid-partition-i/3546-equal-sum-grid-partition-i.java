class Solution {
    public boolean canPartitionGrid(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        long[] vSum = new long[n];
        long[] hSum = new long[m];
        long total = 0;
        for(int i=0; i<m; i++){
            for (int j = 0; j < n; j++) {
                hSum[i] += grid[i][j];
                vSum[j] += grid[i][j];
                total += grid[i][j];
            }
        }

        if(total % 2 == 1) return false;

        if(check(vSum, total)) return true;
        if(check(hSum, total)) return true;

        return false;

    }

    private boolean check(long[] arr, long total) {
        long l = arr[0];
        long r = total-arr[0];

        for (int i=1; i<arr.length; i++){
            if(l == r) return true;
            if(l > r) return false;
            l += arr[i];
            r -= arr[i];
        }
        return false;
    }
}