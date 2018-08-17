public class Solution {
  public int largest(int[][] matrix) {
    // 预处理：将matrix压扁， S0,S1,S2....Sn 
    // O(n^2) : 每行largest Pre sum + O(n) 压扁每一列
    // 遍历一次
    int N = matrix.length;
    int M = matrix[0].length;
    int result = Integer.MIN_VALUE;
    for(int i = 0; i < N; i++){
      int[] cur = new int[M];
      for(int j = i; j < N; j++){
        add(cur, matrix[j]); ///matrix[j] 是一整行
        result = Math.max(result, max(cur));
      }
    }
    return result;
  }
  
  private void add(int[] cur, int[]add){
    for(int i = 0; i < cur.length; i++){
      cur[i] += add[i];
    }
  }
  
  // largest subarray sum
  private int max(int[] cur){
    int result = cur[0];
    int tmp = cur[0];
    for(int i = 1; i < cur.length; i++){
      tmp = Math.max(tmp + cur[i], cur[i]);
      result = Math.max(result, tmp);
    }
    return result;
  }
  
}
