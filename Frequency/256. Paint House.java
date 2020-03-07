class Solution {
    // DP: 假设前 n - 1 个 house 都paint了, paint 第 n 个 
    // 本来需要三个dp array：
    // dpR[n] = Math.min(dpB[n - 1], dpG[n - 1]) + cost[n][R];
    // dpB[n] = Math.min(dpR[n - 1], dpG[n - 1]) + cost[n][B];
    // dpG[n] = Math.min(dpB[n - 1], dpR[n - 1]) + cost[n][G];;
    // dp[n] = Math.min(dpR[n], dpB[n], dpG[n]);
    // 我们只需要存三个变量 prevR, prevB, prevG
    // Time: O(n)
    // Space:O(1)
    public int minCost(int[][] costs) {
        // corner case:
        if (costs.length == 0) {
            return 0;
        }
        int prevR = costs[0][0];
        int prevB = costs[0][1];
        int prevG = costs[0][2];
        for (int i = 1; i < costs.length; i++) {
            int curR = Math.min(prevB, prevG) + costs[i][0];
            int curB = Math.min(prevR, prevG) + costs[i][1];;
            int curG = Math.min(prevR, prevB) + costs[i][2];;
            
            prevR = curR;
            prevB = curB;
            prevG = curG;
        }
        return Math.min(prevR, Math.min(prevB, prevG));
    }
}
