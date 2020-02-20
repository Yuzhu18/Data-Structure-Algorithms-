class Solution {
    // DP 经典题（Fibnacci 数列）
    // dp(n) = dp(n - 1) + dp(n - 2)
    // recursion: (top - down)
    //  corner case: f(1) = 1; f(0) = 1
    //  mem[n] = f(n - 1) + f(n - 2);
    // Time: O(n)
    // Space: O(n)
    
    
    // DP: (bottom-up)
    // dp[0] = 1; dp[1] = 1; 
    // for{
    //     dp[n] = dp[n - 1] + dp[n - 2];
    // }
    // time: O(n)
    // space: O(1) 只存两个变量
    
    // public int climbStairs(int n) {
    //     int[] dp = new int[n + 1];
    //     dp[0] = 1;
    //     dp[1] = 1;
    //     for (int i = 2; i <= n ; i++) {
    //         dp[i] = dp[i - 1] + dp[i - 2];
    //     }
    //     return dp[n];
    // }
    
    public int climbStairs(int n) {
        if (n < 0) {
            return 0;
        }
        if (n < 3) {
            return n;
        }
        int prev1 = 1;
        int prev2 = 1;
        int rst = 2;
        for (int i = 2; i <= n ; i++) {
            rst = prev1 + prev2;
            prev2 = prev1;
            prev1 = rst;
        }
        return rst;
    }
}
