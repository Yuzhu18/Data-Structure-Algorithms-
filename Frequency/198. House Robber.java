class Solution {
    public int rob(int[] nums) {
        // DP 
        // O (n)
        // space : O (1)
        // 每个house有两个选择 ： 偷( rob(n - 2) + cur  )  : 偷当前这个house意味着，n-1是没被偷的
        //                     或者不偷( rob(n - 1) ) ： 不偷当前这个，意味着是 n-1 的结果
        // Max (rob(n - 2) = cur, rob(n - 1)) 
        if (nums.length == 0) {
            return 0;
        }
        int prev1 = 0;
        int prev2 = 0;
        for (int num : nums) {
            int temp = prev1;
            prev1 = Math.max(prev2 + num, temp);
            prev2 = temp;
        }
        return prev1;
    }
}
