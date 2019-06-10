public class Solution {
  // time： O（logn + k）
  public int[] kClosest(int[] array, int target, int k) {
    if (array == null || array.length < k) {
        return new int[k];
    }
    // 找到比target小且最近的index
    int l = findNearSmallest (array, target);
    int r = l + 1;
    int[] rst = new int[k];
    for (int i = 0; i < k; i++) {
        //谁小移谁
        // 如果right过界， 或者left更接近target
        if (r >= array.length || l >= 0 && target - array[l] < array[r] - target) {
            rst[i] = array[l--];
        }else {
            rst[i] = array[r++];
        }
    }
    return rst;
  }
  // 找到比target小且最近的index
  private int findNearSmallest(int[] array, int target) {
      int left = 0;
      int right = array.length - 1;
      while (left < right - 1) {
          int mid = left + (right - left) / 2;
          if (array[mid] <= target) {
              left = mid;
          }else {
              right = mid;
          }
      }
      //保证尽可能大
      if (array[right] <= target) {
          return right;
      }else {
          return left;
      }
  }
}
