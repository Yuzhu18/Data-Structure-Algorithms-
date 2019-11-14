class Solution {
  // 求最小跳的步数
  // dp[i] represents the minimum steps jump from 0 to current index
  // 每次遍历前面的最小的+1
  // Time: O(n^2)
  // Space: O(n)
  // 这道题可以用greedy优化
  
    public int jump(int[] nums) {
        int[] dp = new int[nums.length];
        dp[0] = 0;
        for (int i = 1; i < nums.length; i++) {
            dp[i] = -1;
            int min = Integer.MAX_VALUE;
            for (int j = 0; j < i; j++) {
                if (dp[j] != -1 && nums[j] + j >= i) {
                    min = Math.min(min, dp[j] + 1);
                }
            }
            if (min != Integer.MAX_VALUE) {
                dp[i] = min;
            }
        }
        return dp[nums.length - 1];
    }
}
