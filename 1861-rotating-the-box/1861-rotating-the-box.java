class Solution {
    public char[][] rotate(char[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;

        char[][] ret = new char[n][m];

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                ret[j][m - 1 - i] = matrix[i][j];
            }
        }

        return ret;
    }

    public char[][] rotateTheBox(char[][] boxGrid) {
        boxGrid = rotate(boxGrid);
        //print(boxGrid);
        for (int i = boxGrid.length-1; i >=0; i--) {
            for (int j = 0; j < boxGrid[0].length; j++) {
                if(boxGrid[i][j] == '#'){
                    dropDownStone(i, j, boxGrid);
                }
            }
        }
        return boxGrid;
    }

    private void print(char[][] boxGrid) {
        for (int i = 0; i < boxGrid.length; i++) {
            for (int j = 0; j < boxGrid[0].length; j++) {
                System.out.print(boxGrid[i][j] + " ");
            }
            System.out.println("");
        }
    }

    private void dropDownStone(int i, int j, char[][] boxGrid) {
        while (i+1<boxGrid.length){
            if(boxGrid[i+1][j] == '.'){
                boxGrid[i][j] = '.';
                i++;
            }
            else{
                break;
            }
        }
        if(i < boxGrid.length)
            boxGrid[i][j] = '#';
    }
}
