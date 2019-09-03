class Solution {
    public int maximalSquare(char[][] matrix) {
        //DP : 存以[i,j] 为右下角的square的最大边长
        // time: O (mn)
        // space: O (mn)
        int rows = matrix.length;
        if (rows == 0) {
            return 0;
        }
        int cols = matrix[0].length;
        int[][] dp = new int[rows + 1][cols + 1];
        int maxLen = 0;
        for (int i = 1; i <= rows;i++) {
            for (int j = 1; j <= cols;j++) {
                if (matrix[i - 1][j - 1] == '1') {
                    dp[i][j] = Math.min(Math.min(dp[i][j - 1], dp[i - 1][j]), dp[i - 1][j - 1]) + 1;
                    maxLen = Math.max(maxLen, dp[i][j]);
                    
                }
            }
        }
        return maxLen * maxLen;
    }
}
