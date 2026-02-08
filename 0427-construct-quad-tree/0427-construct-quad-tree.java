
class Solution {
    public Node construct(int[][] grid) {
        return helper(grid, 0, 0, grid.length, grid[0].length);

    }

    private Node helper(int[][] grid, int startx, int starty, int endx, int endy) {
        if(startx == endx && starty == endy){
            return new Node(grid[startx][starty] == 1 ? true : false, true);
        }

        boolean mismatch = false;


        for (int i = startx; i < endx && !mismatch; i++) {
            for (int j = starty; j < endy; j++) {
                if(grid[i][j] != grid[startx][starty]){
                    mismatch =  true;
                    break;
                }
            }
        }

        if(!mismatch){
            return new Node(grid[startx][starty] == 1 ? true : false, true);
        }

        Node node = new Node(grid[startx][starty] == 1 ? true : false, false);

        int midx = startx + (endx - startx)/2;
        int midy = starty + (endy - starty)/2;


        node.topLeft = helper(grid, startx, starty, midx, midy);
        node.topRight = helper(grid, startx, midy, midx, endy);
        node.bottomLeft = helper(grid, midx, starty, endx, midy);
        node.bottomRight = helper(grid, midx,  midy, endx, endy);
        return node;

    }
}