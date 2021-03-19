class FindNumberIn2DArray {
    

    public boolean findNumberIn2DArray(int[][] matrix, int target) {
        
        int m = matrix.length;
        if (m == 0) {
            return false;
        }
        int n = matrix[0].length;
        if (n == 0) {
            return false;
        }
        int row = 0;
        int col = n - 1;
        while (row < m && col >= 0) {
            int temp = matrix[row][col];
            if (temp == target) {
                return true;
            }
            if (target > temp) {
                row += 1;
            } else {
                col -= 1;
            }
        }
        return false;
    }
}