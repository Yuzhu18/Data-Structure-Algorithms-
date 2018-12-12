public class Solution {
 
 // 递归不是并行的，而是先运行到底
 // 每次二分排序（merge sort），谁小移谁合并（merge），最后复制回原来的array
 
 public int[] mergeSort(int[] array) {
    // Write your solution here
    int[] rst = new int[array.length];
    sort(array, rst, 0 , array.length - 1);
    return array;
  }
  
  private void sort(int[] array, int[] rst , int left, int right){
    if(left >= right){
      return;
    }
    int mid = left + (right - left) / 2;
    sort(array, rst, left, mid);
    sort(array, rst, mid + 1, right);
    merge(array, rst, left, right);
  }
  
  private void merge(int[] array,int[] rst, int left, int right){
    int mid = left + (right - left) / 2;
    int l = left;
    int r = mid + 1;
    int index = left;        /////////index 起始是left
    while(l <= mid && r <= right){
      if(array[l] <= array[r]){
        rst[index++] = array[l++];
      }else{
        rst[index++] = array[r++];
      }
    }
    while(l <= mid){
      rst[index++] = array[l++]; ////////// array[l ++] 记得++
    }
    while(r <= right){
      rst[index++] = array[r++];  ////////// array[r ++] 记得++
    }
    
    for( int i = left; i <= right ; i++){  ////// 注意是left - right
            array[i] = rst[i];
     }
  }
