class Solution {
    //dp : dp[i] represents {0 - i} (indcluding i) maximum num
    // time:  O(n)
    //space: O(n)
    public int maxSubArray(int[] nums) {
        int[] dp = new int[nums.length];
        int max = nums[0];
        dp[0] = nums[0];
        for(int i = 1; i < nums.length ; i++){
            dp[i] = nums[i] + (dp[i - 1] > 0 ? dp[i - 1] : 0);
            max = Math.max(max, dp[i]);
        }
        return max;
    }
}
