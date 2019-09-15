public class Solution {
  public int[] rainbowSort(int[] array) {
  
    if(array == null || array.length == 0){
      return array;
    }
    
    int neg = 0;
    int pointer = 0;
    int pos = array.length - 1;
    
    //三个挡板，四个区域，pointer扫未知区域
    while(pointer <= pos){
      if(array[pointer] == 0){
        pointer++;
      }else if(array[pointer] == -1){
        swap(array, neg, pointer);
        neg++;
        pointer++;   //////和-1交换pointer也需要++
      }else{
        swap(array, pointer, pos);
        pos--;
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
