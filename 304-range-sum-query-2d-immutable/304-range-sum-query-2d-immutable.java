class NumMatrix {
    int[][] sum;
    int m, n;
    public NumMatrix(int[][] matrix) {
        m = matrix.length;
        n = matrix[0].length;
        sum = new int[m+1][n+1];

        for(int i = 1; i <= m; i++) {
            for(int j = 1; j <= n; j++) {
                sum[i][j] = sum[i][j-1] + matrix[i-1][j-1];
            }
        }
    }

    public int sumRegion(int row1, int col1, int row2, int col2) {
        int totalSum = 0;
        for(int r = row1 + 1; r <= row2+1; r++) {
            totalSum += sum[r][col2+1] - sum[r][col1];
        }

        return totalSum;
    }
}

/**
 * Your NumMatrix object will be instantiated and called as such:
 * NumMatrix obj = new NumMatrix(matrix);
 * int param_1 = obj.sumRegion(row1,col1,row2,col2);
 */