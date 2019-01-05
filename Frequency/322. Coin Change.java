class Solution {
    //DP
    //1. iterative way
    // time: O(k*n)
    // space: O(n)
    public int coinChange(int[] coins, int amount) {
        
        int[] dp = new int[amount + 1];
        
        for(int i = 1; i <= amount ; i++){
            // 建立当前amount 的 minCount
            int minCount = Integer.MAX_VALUE;
            for(int coin : coins){
                // 后面有dp[i - coin] 保证大于=0
                if( i - coin >= 0 && dp[i - coin] != -1){
                    // 更新minCount, 找最小的count 
                    minCount = dp[i - coin] < minCount ? dp[i - coin] : minCount;
                }
            }
            //存下目前结果
            dp[i] = minCount == Integer.MAX_VALUE ?  -1 : minCount + 1;
        }
        return dp[amount];
    }
  
  
  //=======================================================================================================================================
  
    // 2. recursive way 
    // time : O(k * n)
    // space: O(n)
     public int coinChange(int[] coins, int amount) {
         //corner case 
         if(amount < 1){
             return 0;
         }
         return helper(coins, amount, new int[amount]);
     }
    
     private int helper(int[] coins, int remain, int[] dp){
         // not valid 
        if(remain < 0){ return -1;}
         //completed
         if(remain == 0){ return 0; }
         //dp 存下来的 already computed
         if(dp[remain - 1] != 0){ return dp[remain - 1]; }
         // 目前min count
         int minCount = Integer.MAX_VALUE;
         for(int coin : coins){
             int lastCount = helper(coins, remain - coin, dp);
             // 更新minCOunt
             if(lastCount >= 0 && lastCount < minCount ){
                 minCount = lastCount + 1;
             }
         }
         //存dp
         dp[remain - 1] = minCount == Integer.MAX_VALUE ? -1 : minCount;
         return dp[remain - 1];
     }
   
}


