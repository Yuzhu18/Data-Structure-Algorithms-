public class Solution {
  public boolean canJump(int[] array) {
  
    // DP 从后往前(很少是这种情况)
    // time : O(n^2)
    if(array.length == 1){
      return true;
    }
    int size = array.length;
    boolean[] M = new boolean[size];
    M[size - 1] = true;
    for(int i = array.length - 2; i >= 0;i-- ){
      if(array[i] + i >= array.length - 1){
        M[i] = true;
      }else{
        for(int j = array[i]; j >= 1; j--){
          if(M[i + j]){
            M[i] = true;
            break;
          }
        }
      }
    }
    return M[0];
  }
}
