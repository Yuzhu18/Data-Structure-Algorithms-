class Solution {
    // Dp[i] : represents whether can jump from the beginning to index i
    // 每次判断在index i 之前的是true的位置，是否能跳到index i
    // Time: O(n^2)
    // Space: O(n)
    // public boolean canJump(int[] nums) {
    //     boolean[] dp = new boolean[nums.length];
    //     dp[0] = true;
    //     for (int i = 1; i < nums.length; i++) {
    //         for (int j = 0; j < i; j++) {
    //             if (dp[j] && nums[j] + j >= i) {
    //                 dp[i] = true;
    //             }
    //         }
    //     }
    //     return dp[nums.length - 1];
    // }
    
    
    // 这题可以优化成greedy
    // 从后往前跳，
    // 我们只需要记录 最小的lastIndex,最后返回lastIndex 是否是0
    // Time: O(n)
    // Space:O(1)
    public boolean canJump(int[] nums) {
        int lastIndex = nums.length - 1;
        for (int i = nums.length - 2; i >= 0; i--) {
            if (i + nums[i] >= lastIndex) {
                lastIndex = i;
            }
        }
        return lastIndex == 0;
    }
}
