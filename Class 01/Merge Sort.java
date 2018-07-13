public class Solution {
 
 // 递归不是并行的，而是先运行到底
 // 每次二分排序（merge sort），谁小移谁合并（merge），最后复制回原来的array
 
  public int[] mergeSort(int[] array) {
 
    if(array == null || array.length == 0){
      return array;
    }
    int[] helper = new int[array.length];
    mergesort(array, helper, 0, array.length-1);
    return array;
  }
  
  private void mergesort(int[] array, int[] helper, int left, int right){
    if(left >= right){
      return;
    }
    int mid = left + (right - left) / 2;
    mergesort(array, helper, left, mid);
    mergesort(array, helper, mid+1, right);
    merge(array, helper, left, right);
  }
  
  private void merge(int[] array, int[] helper, int left, int right){
    int leftIndex = left;
    int mid = left + (right - left) / 2;
    int rightIndex = mid + 1;
    int i = left;
    while(leftIndex <= mid && rightIndex <= right){
      if(array[leftIndex] < array[rightIndex]){
        helper[i] = array[leftIndex];
        leftIndex++;
      }else{
        helper[i] = array[rightIndex];
        rightIndex++;
      }
      i++;
    }
    while(leftIndex <= mid){
      helper[i] = array[leftIndex];
      leftIndex++;
      i++;
    }
    while(rightIndex <= right){
      helper[i] = array[rightIndex];
      rightIndex++;
      i++;
    }
    
    for(int j = left; j <= right ; j++){
      array[j] = helper[j];
    }
  }
}
