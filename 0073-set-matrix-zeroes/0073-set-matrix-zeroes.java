class Solution {
    public void setZeroes(int[][] matrix) {
        boolean[] row = new boolean[201];
        boolean[] col = new boolean[201];
        
        for(int i=0; i<matrix.length; i++)
        {
            for (int j=0; j<matrix[0].length; j++)
            {
                if(matrix[i][j] == 0)
                {
                    row[i] = true;
                    col[j] = true;
                }
            }
        }
        
        for(int i=0; i<row.length; i++){
            if(row[i]){
                for (int j=0; j<matrix[0].length; j++){
                    matrix[i][j] = 0;
                }
            }
        }


        for(int i=0; i<col.length; i++){
            if(col[i]){
                for (int j=0; j<matrix.length; j++){
                    matrix[j][i] = 0;
                }
            }
        }
   
    }
}