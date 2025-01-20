import java.util.HashMap;

class Solution {
    public int firstCompleteIndex(int[] arr, int[][] mat) {
        HashMap<Integer, Cell> matMap = new HashMap<>();
        for(int i=0; i< mat.length; i++){
            for (int j = 0; j < mat[0].length; j++) {
                Cell c = new Cell(i, j);
                matMap.put(mat[i][j], c);
            }
        }
        int[] rows = new int[mat.length];
        int[] cols = new int[mat[0].length];

        for(int i=0; i<arr.length; i++){
            Cell currCell = matMap.get(arr[i]);
            rows[currCell.row]++;
            cols[currCell.col]++;
            if(rows[currCell.row] == mat[0].length){
                return i;
            }
            if(cols[currCell.col] == mat.length){
                return i;
            }
        }
        return -1;
    }
}
class Cell{
    int row;
    int col;

    public Cell(int row, int col) {
        this.row = row;
        this.col = col;
    }
}