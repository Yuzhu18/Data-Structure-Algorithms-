public class Solution {
  public int[][] spiralGenerate(int n) {
    // 生成正方形
    int[][] rst = new int[n][n];
    if(n == 0){
      return rst;
    }
    helper( rst, n, 0, 1);
    return rst;
  }
  private void helper( int[][] rst, int size, int offset, int count){
    //base case
    if(size == 0){
      return;
    }
    if(size == 1){
      rst[offset][offset] = count;
      return;
    }
    for(int i = 0; i < size - 1; i++){
      rst[offset][offset + i] = count;
      count++;
    }
    for(int i = 0; i < size - 1; i++){
      rst[offset + i][offset + size - 1] = count;
      count++;
    }
    for(int i = size - 1; i >= 1; i--){
      rst[offset + size - 1][offset + i] = count;
      count++;
    }
    for(int i = size - 1; i >= 1; i--){
      rst[offset + i][offset] = count;
      count++;
    }
    helper(rst, size - 2, offset + 1, count);
  }
}
