public class Solution {
  public int largest(int[][] matrix) {
    // 原理和longest cross of 1s 一样，只是预处理时四个方向不一样
    int N = matrix.length;
    int M = matrix[0].length;
    if(N == 0 || M == 0){
      return 0;
    }
    int[][] leftup = leftup(matrix, N, M);
    int[][] rightdown = rightdown(matrix, N, M);
    int rst = merge(leftup, rightdown, N, M);
    return rst;
  }
  
  // 把两个int[][]取最小值合并, 结果取最大值
  private int merge(int[][] leftup, int[][] rightdown, int N, int M){
    int rst = 0;
    for(int i = 0; i < N; i++){
      for(int j = 0; j < M; j++){
        leftup[i][j] = Math.min(leftup[i][j], rightdown[i][j]);
        rst = Math.max(rst, leftup[i][j]);
      }
    }
    return rst;
  }
  
  //预处理left和up方向、从左上角出发
  private int[][] leftup(int[][] matrix, int N, int M){
    int[][] left = new int[N][M];
    int[][] up = new int[N][M];
    for(int i = 0; i < N; i++){
      for(int j = 0; j < M; j++){
        if(matrix[i][j] == 1){
          left[i][j] = getNumber(left, i - 1, j - 1, N , M) + 1;
          up[i][j] = getNumber(up, i - 1, j + 1, N, M) + 1;
        }
      }
    }
    merge(left, up, N, M);
    return left;
  }
  
  //预处理右和下方向的，从右下角出发
  private int[][] rightdown(int[][] matrix, int N, int M){
    int[][] right = new int[N][M];
    int[][] down = new int[N][M];
    for(int i = N - 1; i >= 0; i--){
      for(int j = M - 1; j >= 0; j--){
        if(matrix[i][j] == 1){
          right[i][j] = getNumber(right, i + 1, j + 1, N, M) + 1;
          down[i][j] = getNumber(down, i + 1, j - 1, N, M) + 1;
        }
      }
    }
    merge(right, down, N, M);
    return right;
  }
  
  // 确定值，防止出界
  private int getNumber(int[][] number, int x, int y, int N, int M){
    if(x < 0 || x >= N || y < 0 || y >= M){
      return 0;
    }
    return number[x][y];
  }
  
  
  
}
