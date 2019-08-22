/*
*  interface Dictionary {
*    public Integer get(int index);
*  }
*/
// You do not need to implement the Dictionary interface.
// You can use it directly, the implementation is provided when testing your solution.
public class Solution {
  // 长度不确定的数组，先确定右边界，再binary search找target
  // time: O(logn)
  public int search(Dictionary dict, int target) {
    int right = 1;
    while (dict.get(right) != null) {
        right = right * 2;
    }
    return binarySearch(dict, target, right);
  }
  
  private int binarySearch(Dictionary dict, int target, int right){
    int left = 0;
    while (left < right - 1) {
        int mid = left + (right - left) / 2;
        if (dict.get(mid) == null || dict.get(mid) > target) { // 需要考虑mid仍然存在null的情况
            right = mid;
        } else if (dict.get(mid) == target) {
            return mid;
        }else {
            left = mid;
        }
    }
    // 需要考虑left(全是null的dictionary) / right仍然存在null的情况
    if (dict.get(left) != null && dict.get(left) == target) {
        return left;
    }else if (dict.get(right) != null && dict.get(right) == target){
        return right;
    }else {
        return -1;
    }
  }
}



