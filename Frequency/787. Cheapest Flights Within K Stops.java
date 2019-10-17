// https://zxi.mytechroad.com/blog/dynamic-programming/leetcode-787-cheapest-flights-within-k-stops/

// DP
//Bellman-Ford's Algorithm
// time : O(k|E|) 边数 = O(k*m)  --m: flight array size
// space: O(kn)   "dp[][]"
// dp[k][v]: min cost from source to v with up to k flights
// 初始值： dp[0: k + 2][src] = 0;
// 转移方程： dp[k][v] = min { ( dp[k - 1][u] + cost[u][v] ) , dp[k][v] }
// 比较在 u 中停再到V， 或者直飞到V ，取最小值
// 结果是返回（最小cost）：dp[k + 1][destination]  (可以中停k个地方，所以最多乘坐 k + 1 次航班)


class Solution {
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int K) {
        // 设置一个dp里面的初始值，infCost (不取Integer.MAX_VALUE 因为会overflow)
        int infCost = 1 << 30;  // (位运算： 左移30位， 2^29)
        int[][] dp = new int[K + 2][n];
        // fill the dp[][] with the intial value
        for (int i = 0; i < dp.length; i++) {
            Arrays.fill(dp[i], infCost); // 赋值dp[i] 一整行的值都是infCost
        }
        
        dp[0][src] = 0;
        
        for (int i = 1; i <= K + 1; i++) {
            dp[i][src] = 0;
            for (int j = 0 ; j < flights.length; j++) {
                dp[i][flights[j][1]] = Math.min(dp[i][flights[j][1]], dp[i - 1][flights[j][0]] + flights[j][2]);
            }
        }
        return dp[K + 1][dst] >= infCost ? -1 : dp[K + 1][dst];
    }
}
