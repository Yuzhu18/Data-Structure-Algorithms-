public class Solution {
  // dp[i] represents the largest subarray sum from 0 to current index i
  // 每次更新 dp[i] = Max{array[i], dp[i - 1] + array[i] }
  // Time: O(n)
  // 空间可以优化成，只记录prev就可以，不需要保留dp array
  // Space: O(1)

  public int largestSum(int[] array) {
    int[] dp = new int[array.length];
    int largest = array[0];
    // base case:
    int prev = array[0];
    for (int i = 1; i < array.length; i++) {
      int current = Math.max(array[i], prev + array[i]);
      prev = current;
      largest = Math.max(largest, current);
    }
    return largest;
  }
}
