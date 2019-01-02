class Solution {
    // DP : dp[n] = dp[n - 1] + dp[n - 2]
    // 只需维护两个变量 prevOne, prevTwo
    // time: O(n)
    //space: O(1)
    public int climbStairs(int n) {
        if(n < 0){
            return 0;
        }
        if(n < 3){
            return n;
        }
        int one = 1;
        int two = 2;
        int cur= 0;
        for(int i = 3; i <= n; i++){
            cur = one + two;
            one = two;
            two = cur;
        }
        return cur;
    }
}
