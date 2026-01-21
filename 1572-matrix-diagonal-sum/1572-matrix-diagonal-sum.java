class Solution {
    public int diagonalSum(int[][] mat) {
        int sum = 0;
        int i = 0;
        int j = 0;
        while (i<mat.length && j<mat[0].length){
            sum += mat[i][j];
            i++;
            j++;
        }
        i = 0;
        j = mat[0].length - 1;

        while (i<mat.length && j>=0){
            if(i != j)
                sum += mat[i][j];
            i++;
            j--;
        }
        return sum;
    }
}