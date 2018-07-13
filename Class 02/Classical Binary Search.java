public class Solution {
  
  public int binarySearch(int[] array, int target) {
    
    // while循环后再无操作版 --- start，end 错开时跳出
    if(array == null || array.length == 0){
      return -1;
    }
    int start = 0;
    int end = array.length -1;
    while(start <= end){
      int mid = start + (end - start) / 2;
      if(array[mid] < target){
        start = mid + 1;
      }else if(array[mid] == target){
        return mid;
      }else{
        end = mid - 1;
      }
    }
    return -1;
  }
  
  //常用版本：单独考虑最后两个元素---start， end 相邻时跳出
  public int binarySearch(int[] array, int target) {
    if(array == null || array.length == 0){
      return -1;
    }
    int start = 0;
    int end = array.length -1;
    while( start + 1 < end ){
      int mid = start + (end - start) / 2;
      if(array[mid] == target){
        return mid;
      }else if(array[mid] < target){
        start = mid; //此时可以加1
      }else{
        end = mid; // 此时可以减1
      }
    }
    if(array[start] == target){
      return start;
    }else if (array[end] == target){
      return end;
    }else{
      return -1;
    }
  }
}


