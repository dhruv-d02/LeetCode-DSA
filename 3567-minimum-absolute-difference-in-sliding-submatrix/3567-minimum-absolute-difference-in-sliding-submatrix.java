import java.util.HashSet;
import java.util.Set;
class Solution {
    public int[][] minAbsDiff(int[][] grid, int k) {
        int m = grid.length, n = grid[0].length;
        int[][] ans = new int[m - k + 1][n - k + 1];

        for (int i = 0; i <= m - k; i++) {
            for (int j = 0; j <= n - k; j++) {
                Set<Integer> v = new TreeSet<>();
                for (int x = i; x < i + k; x++)
                    for (int y = j; y < j + k; y++)
                        v.add(grid[x][y]);

                int mn = Integer.MAX_VALUE;
                int prev = Integer.MIN_VALUE;
                for(int val : v){
                    if(prev != Integer.MIN_VALUE) {
                        mn = Math.min(mn, Math.abs(val - prev));
                    }
                    prev = Math.max(prev, val);
                }
                ans[i][j] = (mn == Integer.MAX_VALUE) ? 0 : mn;
            }
        }
        return ans;
    }
}