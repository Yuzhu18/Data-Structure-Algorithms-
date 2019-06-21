public class Solution {
    // selection sort, 谁小移谁
    // time: O(n^2)  1 + 2 + 3 + 4 + ..... + n  等差数列求和 = n(n + 1)/2
    // space: O(1) 
  public int[] solve(int[] array) {
    if (array == null || array.length == 0) {
        return array;
    }
    for (int i = 0; i < array.length ; i++) {
        int minLoc = i;
        for (int j = i + 1; j < array.length; j++) {
            if (array[j] < array[minLoc]) {
                minLoc = j;
            }
        }
        swap(array, minLoc, i);
    }
    return array;
  }
  private void swap (int[] array, int left, int right) {
    int tmp = array[left];
    array[left] = array[right];
    array[right] = tmp;
  }
}
