public class Solution {
  public int longest(int[] array) {
    //M[i] : represents 0th - ith (includes ith) longest length
    // 只需要回头看一个
    int cur = 0;
    int max = 0 ;
    for(int i = 0; i < array.length; i++){
      if(array[i] == 1){
        if(i == 0 || array[i - 1] == 0){
          cur = 1;
        }else{
          cur ++;
        }
      }
      max = Math.max(max, cur);
    }
    return max;
  }
}
