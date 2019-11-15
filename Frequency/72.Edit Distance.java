class Solution {
    // 二维dp (最好画出来表格讲解)
    // 二维dp要初始第一行➕第一列（区别于一维dp只初始index 0）
    // dp[i][j] represents minimum steps to make str1[0:i) and str2[0:j) match
    // Time: O(n * m)
    // Space:O(n * m)
    public int minDistance(String word1, String word2) {
        // corner case:
        if (word1.length() == 0 && word2.length() == 0) {
            return 0;
        } else if (word1.length() == 0 || word2.length() == 0) {
            return word1.length() == 0 ? word2.length() : word1.length();
        }
        int[][] dp = new int[word1.length() + 1][word2.length() + 1];
        for (int i = 0; i <= word1.length(); i++) {
            for (int j = 0; j <= word2.length(); j++) {
                // initial values
                if (i == 0 || j == 0) {
                    dp[i][j] = i == 0 ? j : i;
                } else {
                    if (word1.charAt(i - 1) == word2.charAt(j - 1)) {
                        dp[i][j] = dp[i - 1][j - 1];
                    } else {
                        //                      delete                 replace          insert
                        dp[i][j] = Math.min(dp[i - 1][j], Math.min(dp[i - 1][j - 1], dp[i][j - 1])) + 1;
                    }
                }
            }
        }
        return dp[word1.length()][word2.length()];
    }
}
