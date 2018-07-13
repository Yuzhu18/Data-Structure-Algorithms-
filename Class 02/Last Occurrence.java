public class Solution {

  public int lastOccur(int[] array, int target) {
  
    // 找last occur，while用相邻跳出
    // array[mid] == target 是继续向后找
    
    if(array == null || array.length == 0){
      return -1;
    }
    int start = 0;
    int end = array.length -1;
    while(start + 1 < end){
      int mid = start + (end -start ) / 2;
      if(array[mid] > target){
        end = mid;
      }else{
        start = mid;
      }
    }
    if(array[end] == target){
      return end;
    }else if(array[start] == target){
      return start;
    }else{
      return -1;
    }
  }
}


