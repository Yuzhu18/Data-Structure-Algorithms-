class Solution {
    // DP：左大段➕右小段
    // 需要寻找break point
    // dp[n] represents [0 ~ n) can be divide or not
    // 因为substring(i,j) 左闭右开所以要dp长度为n+1
    // time ：O(n^3) --substring() is O(n)
    // Space: O(n)
    public boolean wordBreak(String s, List<String> wordDict) {
        // build dictionary
        Set<String> dict = new HashSet<String>();
        for (String ss: wordDict) {
            dict.add(ss);
        }
        int n = s.length();
        boolean[] dp = new boolean[n + 1];
        // run dp
        dp[0] = true;
        for (int i = 1; i <= n; i++) {
            for (int j = i; j >= 0; j--) {
                if (dp[j] && dict.contains(s.substring(j, i))) {
                    dp[i] = true;
                    break;
                }
            }
        }
        return dp[s.length() ];
    }
}


