public class Solution {
  public int[] largestAndSmallest(int[] array) {
    int length = array.length;
    compareByTwo(array, 0, length - 1);
    int min = getSmallest(array, 0, length/2);
    int max = getLargest(array, length/2, length - 1);
    return new int[] {max, min};
  }
  
  private void compareByTwo(int[] array, int left, int right) {
    while (left < right) {
      if (array[left] > array[right]) {
        swap(array, left, right);
      }
      left++;
      right--;
    }
  }
  
  private int getSmallest(int[] array, int start, int end) {
    int global_min = array[start];
    for (int i = start; i <= end; i++) {
      if (array[i] < global_min) {
        global_min = array[i];
      }
    }
    return global_min;
  }
  
    private int getLargest(int[] array, int start, int end) {
    int global_max = array[start];
    for (int i = start; i <= end; i++) {
      if (array[i] > global_max) {
        global_max = array[i];
      }
    }
    return global_max;
  }
  
  private void swap(int[] array, int a, int b) {
    int temp = array[a];
    array[a] = array[b];
    array[b] = temp;
  }
}

