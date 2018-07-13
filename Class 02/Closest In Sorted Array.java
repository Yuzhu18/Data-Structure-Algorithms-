public class Solution {

  public int closest(int[] array, int target) {
  
    // 找大小最接近target的数，while用相邻跳出
    //单独判断最后两个数
    
    if(array == null || array.length == 0){
      return -1;
    }
    int start = 0;
    int end = array.length - 1;
    while(start + 1 < end){
      int mid = start + (end - start) / 2;
      if(array[mid] == target){
        return mid;
      }else if(array[mid] < target){
        start = mid;
      }else{
        end = mid;
      }
    }
    if(target - array[start] < array[end] - target ){
      return start;
    }else{
      return end;
    }
  }
}
