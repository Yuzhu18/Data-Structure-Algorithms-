public class Solution {
  public void shuffle(int[] array) {
    // all perumation 类似的方法，只是每次随机
    if(array.length <= 1){
      return;
    }
    int size = array.length;
    for(int i = size; i > 0; i--){
      int right = (int)(Math.random() * i);
      swap(array, i - 1, right);
    }
  }
  private void swap(int[] array, int left, int right){
    int temp = array[left];
    array[left] = array[right];
    array[right] = temp;
  }
}
