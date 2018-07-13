public class Solution {

//随机找pivot

  public int[] quickSort(int[] array) {
    if(array == null || array.length == 0){
      return array;
    }
    quicksort(array, 0, array.length -1);
    return array;
  }
  
  //recurion quicksort 
  private void quicksort(int[] array, int left, int right){
    if(left >= right){
      return;
    }
    int pivot = partition(array, left, right);
    quicksort(array, left, pivot -1);
    quicksort(array, pivot + 1, right);
  }
  
  //分成pivot为中心的两部分，左小右大
  private int partition(int[] array, int left, int right){
    int pivotI = pivotIndex(left, right);
    int pivotVal = array[pivotI];
    //先把pivot移到最后
    swap(array, pivotI, right);
    int leftBound = left;
    int rightBound = right - 1;
    while(leftBound <= rightBound){
      if(array[leftBound] <= pivotVal){
        leftBound++;
      }else if(array[rightBound] >= pivotVal){
        rightBound--;
      }else {
        swap(array, leftBound, rightBound);
      }
    }
    //移回pivot
    swap(array, leftBound, right);
    return leftBound;
  } 
  
  private int pivotIndex(int left, int right){
    return left + (int)(Math.random()* (right - left +1));
  }
  
  private void swap(int[] array, int left, int right){
    int temp = array[left];
    array[left] = array[right];
    array[right] = temp;
  }
}

