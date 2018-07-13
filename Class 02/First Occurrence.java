public class Solution {

  public int firstOccur(int[] array, int target) {
  
    // 找first occur，用相邻跳出
    // 当array[mid] = target时继续找
    
    if(array == null || array.length == 0){
      return -1;
    }
    int start = 0;
    int end = array.length - 1;
    while(start + 1 < end){
      int mid = start + (end - start) / 2;
      if(array[mid] < target){
        start = mid;
      }else{
        end = mid;
      }
    }
    if(array[start] == target){
      return start;
    }else if(array[end] == target){
      return end;
    }else{
      return -1;
    }
  }
}
