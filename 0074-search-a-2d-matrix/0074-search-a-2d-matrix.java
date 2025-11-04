class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int m = matrix.length;
        int n = matrix[0].length;
        int total = m*n;

        int left = 0;
        int right = total - 1;
        while (left <= right){
            int mid = left + (right - left)/2;
            int r = mid/n;
            int c = mid%n;
            if(matrix[r][c] == target){
                return true;
            }
            if(matrix[r][c] < target){
                left = mid + 1;
            }
            if(matrix[r][c] > target){
                right = mid - 1;
            }
        }
        return false;
    }
}