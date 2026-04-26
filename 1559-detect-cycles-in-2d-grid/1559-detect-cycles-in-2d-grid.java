class Solution {
    int[][] dir = new int[][]{{0,1}, {0,-1}, {1,0}, {-1, 0}};
    public boolean containsCycle(char[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        boolean[][] vis  = new boolean[m][n];

        for(int i=0; i<m; i++)
            for (int j = 0; j <n; j++) {
                if(!vis[i][j]){
                    if(dfs(i, j, -1, -1, vis, grid))
                        return true;
                }
            }
        return false;
    }

    private boolean dfs(int i, int j, int pX, int pY, boolean[][] vis, char[][] grid) {
        vis[i][j] = true;

        for(int[] d : dir){
            int nx = i + d[0];
            int ny = j + d[1];
            if(!valid(nx, ny, grid.length, grid[0].length))
                continue;

            if(nx == pX && ny == pY)
                continue;

            if(grid[nx][ny] != grid[i][j])
                continue;

            if(vis[nx][ny]){
                return true;
            }

            if(dfs(nx, ny, i, j, vis, grid))
                return true;

        }

        return false;
    }

    private boolean valid(int x, int y, int m, int n) {
        if(x < 0 || y < 0)
            return false;
        if(x >= m || y >= n)
            return false;
        return true;
    }
}