public class Solution {
  public void rotate(int[][] matrix) {
    // 类似剥洋葱的题
    int n = matrix.length;
    if(n <= 1){
      return;
    }
    int round = n / 2;
    for(int level = 0; level < n; level++){
      int left = level;
      int right = n - 2 - level;
      for(int i = left; i <= right; i++){
        int tmp = matrix[left][i];
        matrix[left][i] = matrix[n - 1 - i][left];
        matrix[n - 1 - i][left] = matrix[n - 1 - left][n - 1 - i];
        matrix[n - 1 - left][n - 1 - i] = matrix[i][n - 1 - left];
        matrix[i][n - 1 - left] = tmp;
      }
    }
  }
}

