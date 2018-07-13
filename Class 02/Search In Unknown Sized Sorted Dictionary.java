/*
*  interface Dictionary {
*    public Integer get(int index);
*  }
*/

// You do not need to implement the Dictionary interface.
// You can use it directly, the implementation is provided when testing your solution.
public class Solution {
  public int search(Dictionary dict, int target) {
  
    // 长度不确定的数组，先确定右边界，再binary search找target
    
    int right = 1;
    while(dict.get(right) != null){
      right = right * 2;
    }
    return binarySearch(dict, target, right);
  }
  
  //Binary Search
  private int binarySearch(Dictionary dict, int target, int right){
    int left = 0;
    while(left <= right){
      int mid = left + (right - left) / 2;
      if(dict.get(mid) == null){ //// 考虑dict里仍然存在null的情况
        right = mid -1;
      }else if(dict.get(mid) < target){
        left = mid + 1;
      }else if(dict.get(mid) == target){
        return mid;
      }else{
        right = mid - 1;
      }
    }
    return -1;
  }
}
