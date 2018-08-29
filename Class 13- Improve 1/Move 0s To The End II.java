public class Solution {
  public int[] moveZero(int[] array) {
    // two pointers有两种方法：
    // 1.同向而行(保证相对顺序)
    // 2.相向而行(不需要保证相对顺序)
    // O(n)
    if(array.length <= 1){
      return array;
    }
    int slow = 0;
    for(int fast = 0; fast < array.length; fast++){
      if(array[fast] != 0){
        array[slow++] = array[fast];
      }
    }
    for(int i = slow; i < array.length; i++){
        array[i] = 0;
    }
    return array;
  }
}
