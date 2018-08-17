public class Solution {
  public int largestSum(int[] array) {
    // M[i] 代表从0th - ith(必须包括i)的最大的和
    if(array.length == 1){
      return array[0];
    }
    int[] M = new int[array.length];
    M[0] = array[0];
    int max = array[0];
    for(int i = 1; i < array.length; i++){
      if(M[i - 1] + array[i] < array[i]){
        M[i] = array[i];
      }else{
        M[i] = M[i - 1] + array[i];
      }
      max = Math.max(max, M[i]);
    }
    return max;
  }
}
