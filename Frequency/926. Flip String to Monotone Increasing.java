class Solution {
    // DP dp[i][0]: represents [0 ~ i] is monotone increasing and i position is 0 
    //    dp[i][1]: represents [0 ~ i] is monotone increasing and i position is 1
    // return min(dp[n][0], dp[n][1])
    // Time : O(n)
    // Space: O(n) --> 可以优化成O(1) , 只存 (i - 1) 的值 “prev”
    
//     public int minFlipsMonoIncr(String S) {
//         // corner case：
//         if (S.length() < 1) {
//             return S.length();
//         }
//         int[][] dp = new int[S.length() + 1][2]; 
//         for (int i = 1; i <= S.length(); i++) {
//             if (S.charAt(i - 1) == '0') {
//                 dp[i][0] = dp[i - 1][0];
//                 dp[i][1] = Math.min(dp[i - 1][0], dp[i - 1][1]) + 1;
//             } else {
//                 dp[i][0] = dp[i-1][0] + 1;
//                 dp[i][1] = Math.min(dp[i-1][0], dp[i-1][1]);
//             }
//         }
//         return Math.min(dp[S.length()][0], dp[S.length()][1]);
//     }
    
    // 优化空间--> O(1)
    public int minFlipsMonoIncr(String S) {
        // corner case：
        if (S.length() < 1) {
            return S.length();
        }
        int prev0 = 0;
        int prev1 = 0;
        int cur0 = 0;
        int cur1= 0;
        for (int i = 1; i <= S.length(); i++) {
            if (S.charAt(i-1) == '0') {
                cur0 = prev0;
                cur1 = Math.min(prev1,prev0) + 1;
            } else {
                cur0 = prev0 + 1;
                cur1 = Math.min(prev0, prev1);
            }
            prev0 = cur0;
            prev1 = cur1;
        }
        return Math.min(cur0, cur1);
    }
}
