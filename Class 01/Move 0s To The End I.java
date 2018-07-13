public class Solution {

 //所有0交换到尾部
 
  public int[] moveZero(int[] array) {
  
    if(array == null || array.length == 0){
      return array;
    }
    
    int pointer = 0;
    int zeros = array.length - 1;
    
    while(pointer <= zeros){
      if(array[pointer] == 0){
        swap(array, pointer, zeros);
        zeros--;
      }else{
        pointer++;
      }
    }
    return array;
  }
  
  private void swap(int[] array, int left, int right){
    int temp = array[left];
    array[left] = array[right];
    array[right] = temp;
  }
}
