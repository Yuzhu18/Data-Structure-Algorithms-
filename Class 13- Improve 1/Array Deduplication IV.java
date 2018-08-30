public class Solution {
  public int[] dedup(int[] array) {
    // 包含回头看的结构：stack
    // class 7(stack) 做过
    if(array.length <= 1){
      return array;
    }

    int end = -1;
    for(int fast = 0; fast < array.length; fast++){
      if(end == -1 || array[end] != array[fast]){
        array[++end] = array[fast];
      }else{
        while(fast + 1 < array.length && array[fast + 1] == array[end]){
          fast++;
        }
        end--;
      }
    }
    return Arrays.copyOf(array, end + 1);
  }
}
