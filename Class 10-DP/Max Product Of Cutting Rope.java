public class Solution {
  public int maxProduct(int length) {
    // 左大段 + 右小段
    if(length == 2){
      return 1;
    }
    int result = 1;
    int[] M = new int[length + 1];
    M[1] = 0;
    M[2] = 1;
    // 长度从1-n
    for(int i = 3; i <= length; i++){
      // 从哪里切的可能性 1 - （i-1）
      for(int j = 1; j < i; j++){
        int cur = Math.max(M[j], j) * (i - j);  // 每种case的结果
        result = Math.max(result, cur);   // 取所有case的最大值
        M[i] = result;
      }
    }
    return result;
  }
}
