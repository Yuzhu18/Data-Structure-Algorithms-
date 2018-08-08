public class Solution {
  public int[] reorder(int[] array) {
    // 每次二分，swap两次
    if(array.length == 0){
      return array;
    }
    if(array.length % 2 == 0){
      helper(array, 0, array.length - 1);
    }else{
      helper(array, 0, array.length - 2);
    }
    return array;
  }
  
  private void helper(int[] array, int left, int right){

    int size = right - left + 1; ////计算size
    if(size <= 2){
      return;
    }
    int mid = left + size / 2;
    int lMid = left + size / 4;
    int rMid = left + 3 * size / 4;
    reverse(array, lMid, mid - 1);
    reverse(array, mid, rMid - 1);
    reverse(array, lMid, rMid - 1);
    
    helper(array, left, left + (lMid - left) * 2 - 1);
    helper(array, left + (lMid - left) * 2, right);
  }
  
  private void reverse(int[] array, int left, int right){
    while(left < right){
      int temp = array[left];
      array[left] = array[right];
      array[right] = temp;
      left++;
      right--;
    }
  }
}

