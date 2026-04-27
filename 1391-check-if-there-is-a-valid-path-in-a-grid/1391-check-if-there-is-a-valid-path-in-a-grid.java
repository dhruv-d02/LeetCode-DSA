import java.util.*;

class Solution {

    public boolean hasValidPath(int[][] grid) {

        boolean[][] vis = new boolean[grid.length][grid[0].length];

        HashMap<Integer, List<int[]>> map = new HashMap<>();

        for (int i = 1; i <= 6; i++) {
            map.put(i, new ArrayList<>());

            switch (i) {
                case 1:
                    map.get(i).add(new int[]{0, 1});
                    map.get(i).add(new int[]{0, -1});
                    break;

                case 2:
                    map.get(i).add(new int[]{1, 0});
                    map.get(i).add(new int[]{-1, 0});
                    break;

                case 3:
                    map.get(i).add(new int[]{0, -1});
                    map.get(i).add(new int[]{1, 0});
                    break;

                case 4:
                    map.get(i).add(new int[]{0, 1});
                    map.get(i).add(new int[]{1, 0});
                    break;

                case 5:
                    map.get(i).add(new int[]{0, -1});
                    map.get(i).add(new int[]{-1, 0});
                    break;

                case 6:
                    map.get(i).add(new int[]{0, 1});
                    map.get(i).add(new int[]{-1, 0});
                    break;
            }
        }

        return dfs(0, 0, grid, vis, map);
    }

    private boolean dfs(int i, int j, int[][] grid,
                        boolean[][] vis,
                        HashMap<Integer, List<int[]>> map) {

        if (i == grid.length - 1 && j == grid[0].length - 1)
            return true;

        vis[i][j] = true;

        for (int[] dir : map.get(grid[i][j])) {

            int nx = i + dir[0];
            int ny = j + dir[1];

            if (valid(nx, ny, grid.length, grid[0].length) && !vis[nx][ny]) {

                // check reverse connection
                if (isConnectedBack(nx, ny, -dir[0], -dir[1], grid, map)) {

                    if (dfs(nx, ny, grid, vis, map))
                        return true;
                }
            }
        }

        return false;
    }

    private boolean isConnectedBack(int x, int y, int dx, int dy,
                                    int[][] grid,
                                    HashMap<Integer, List<int[]>> map) {

        for (int[] dir : map.get(grid[x][y])) {
            if (dir[0] == dx && dir[1] == dy)
                return true;
        }

        return false;
    }

    private boolean valid(int i, int j, int m, int n) {
        return i >= 0 && j >= 0 && i < m && j < n;
    }
}