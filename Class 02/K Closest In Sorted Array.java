public class Solution {

  public int[] kClosest(int[] array, int target, int k) {
  
    // 找k个与target相邻的数
    //想找到最近邻的数，然后谁小取谁，取k个
    //O(logn + k)
    
    if(array == null || array.length == 0){
      return new int[k];
    }
    if(k == 0){
      return new int[k];
    }
    
      int start = 0;
      int end = array.length - 1;
      int temp = 0;
      while(start + 1 < end){
        int mid = start + (end - start) / 2;
        if(array[mid] == target){
          temp = mid;
          return findK(array, k, temp, target);
        }else if(array[mid] < target){
          start = mid;
        }else{
          end = mid;
        }
      }
    
      if(target - array[start] < array[end] - target){
        temp = start;   
      }else{
        temp = end;
      }
      return findK(array, k, temp, target);
    
  }
  
  private int[] findK(int[] array,int k, int temp, int target){
    int[] result = new int[k];
    result[0] = array[temp];
    if(temp == 0){
      for(int i =1; i < k; i++){
        result[i] = array[i];
      }
      return result;
    }else if(temp == array.length -1){
      int j = 1;
      int tmp = temp - 1;
      while(j < k){
        result[j] = array[tmp];
        j++;
        tmp--;
      }
      return result;
    }else{
      int left = temp - 1;
      int right = temp + 1;
      int index = 1;
      while(left >=0 && right < array.length){
      if(target - array[left] < array[right] - target){
        result[index] = array[left];
        left--;
        index++;
      }else{
        result[index] = array[right];
        index++;
        right++;
      }
      if(index == k){
        break;
      }
    }
      return result;
    }
  }
}
