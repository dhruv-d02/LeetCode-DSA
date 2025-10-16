import java.util.ArrayList;
import java.util.List;

class Solution {
    public int[] findDiagonalOrder(int[][] mat) {
        List<Integer> diagonalArr = new ArrayList<>();
        boolean goingUp = true;
        int[] next = {0,0, 1};
        int[] ret = new int[mat.length * mat[0].length];
        while (true){
            diagonalArr.add(mat[next[0]][next[1]]);
            int[] future = findNext(next, goingUp, mat);
            if(future == null){
                break;
            }
            if(next[2] != future[2]){
                goingUp = !goingUp;
            }
            next = future;
        }
        //TODO to array
        for(int i=0; i<diagonalArr.size(); i++){
            ret[i] = diagonalArr.get(i);
//            System.out.println(ret[i] + " ");
        }
        return ret;
    }

    private int[] findNext(int[] curr, boolean goingUp, int[][] mat) {
        int[] ret = new int[3];
        int nx = curr[0];
        int ny = curr [1];
        if(goingUp){
            nx = nx -1;
            ny = ny+1;
        }else{
            nx = nx+1;
            ny = ny-1;
        }
        if(validate(nx, ny, mat)){
            ret[0] = nx;
            ret[1] = ny;
            ret[2] = curr[2];
            return ret;
        }else{
            ret[2] = curr[2] == 0 ? 1 : 0;
            int[] next = rotate(curr[0], curr[1], goingUp, mat);
            if(next != null){
                ret[0] = next[0];
                ret[1] = next[1];
                return ret;
            }
        }
        return null;
    }

    private int[] rotate(int x, int y, boolean goingUp, int[][] mat) {
        int[] next = new int[2];
        int nx = x;
        int ny = y;
        //Check side
        if (goingUp) {
            ny = y + 1;
        } else {
            nx = x + 1;
        }
        if (validate(nx, ny, mat)) {
            return new int[]{nx, ny};
        }
        nx = x;
        ny = y;
        //Check other
        if (goingUp) {
            nx = x + 1;
        } else {
            ny = y + 1;
        }
        if (validate(nx, ny, mat)) {
            return new int[]{nx, ny};
        }
        return null;
    }

    private boolean validate(int x, int y, int[][] mat) {
        return x>=0 && x < mat.length && y>=0 && y<mat[0].length;
    }
}