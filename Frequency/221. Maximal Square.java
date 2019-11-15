class Solution {
  // 二维dp
  // dp[i][j] represents largest square size when matrix[i][j] as bottom-right point
  // dp[i][j] = Math.min{ dp[i - 1][j - 1], dp[i - 1][j], dp[i][j - 1] }; 
  // Time: O(n * m)
  // Space: O(n * m)
  public int maximalSquare(char[][] matrix) {
    // corner case
      if (matrix == null || matrix.length == 0) {
          return 0;
      }
    int[][] dp = new int[matrix.length][matrix[0].length];
    int maxSize = 0;
    for (int i = 0; i < matrix.length; i++) {
      for (int j = 0; j < matrix[0].length; j++) {
        // initial values
        if (i == 0 || j == 0) {
          dp[i][j] = matrix[i][j] == '1' ? 1 : 0;
        } else if (matrix[i][j] == '1') {
          dp[i][j] = Math.min(dp[i - 1][j - 1], Math.min(dp[i - 1][j], dp[i][j - 1]))  + 1;
        }
        maxSize = Math.max(maxSize, dp[i][j]);
      }
    }
    return maxSize * maxSize;
  }
}
