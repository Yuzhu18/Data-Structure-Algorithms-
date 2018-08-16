public class Solution {
  public int largest(int[][] matrix) {
    // M[i][j] 代表以(i, j)点为左下角，最大的正方形的size
    if(matrix.length == 0){
      return 0;
    }
    int[][] M = new int[matrix.length][matrix[0].length];
    int max = 0;
    for(int i = 0; i < matrix.length; i++){
      for(int j = 0; j < matrix[0].length; j++){
        if(i == 0 || j == 0){
          M[i][j] = matrix[i][j] == 1 ? 1 : 0;
        }else if(matrix[i][j] == 1){
          int temp = Math.min(M[i - 1][j - 1], M[i - 1][j]);
          M[i][j] = Math.min(temp, M[i][j - 1]) + 1;
        }
        max = Math.max(max, M[i][j]);
      }
    }
    return max;
  }
}
