public class Solution {

// 	每次找min
//	位置互换

  public int[] solve(int[] array) {
    if(array == null || array.length <= 1){
      return array;
    }
    for(int j = 0; j < array.length; j++){
      int min = j;
      for(int i = j + 1; i < array.length ; i++){
       if(array[i] < array[min]){
         min = i;
       }
      }
      swap(array, j, min);
    }
    return array;
  }
  private void swap(int[]array, int left, int right ){
    int temp = array[left];
    array[left] = array[right];
    array[right] = temp;
  }
}
