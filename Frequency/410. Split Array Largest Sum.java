class Solution {
    // DP 
    // time : O(m*n^2) -- m*n subproblem , each subproblem needs O(n) to find
    // space: O(n * m)
    // dp[i][j] := min of largest sum of splitting nums[0] ~ nums[j] into i groups.
    // 左大段 + 右小段
    public int splitArray(int[] nums, int m) {
        // 建立一个sum array来辅助表示前i个的和
        int[] sum = new int[nums.length];
        sum[0] = nums[0];
        for (int i = 1; i < nums.length; i++) {
            sum[i] = nums[i] + sum[i - 1];
        }

        int[][] dp = new int[m + 1][nums.length];
        for (int i = 0; i < nums.length; i++) {
            dp[1][i] = sum[i];
        }
        
        for (int i = 2; i <= m; i++) {
            for (int j = i - 1; j < nums.length; j++) {  /// 这里如果有要求每一个subarray至少有一个元素的话，就可以从 i-1 开始遍历
                dp[i][j] = Integer.MAX_VALUE;
                for (int k = 0; k < j; k++) {
                    dp[i][j] = Math.min(dp[i][j], Math.max(dp[i - 1][k], sum[j] - sum[k]));
                }
                
            }
        }
        return dp[m][nums.length - 1];
    }
}
